import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Create by chenhd on 2021/8/3.
 */
public class MyClassLoader extends ClassLoader {

    public static void main(String[] args) {
        try {
            Class<?> helloClass = new MyClassLoader().findClass("Hello");
            helloClass.getDeclaredMethod("hello").invoke(helloClass.newInstance());
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            //log
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) {

        try (FileInputStream fileInputStream = new FileInputStream(new File("Hello.xlass"))) {
            byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (255 - bytes[i]);
            }
            return super.defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            //log
            e.printStackTrace();
        }
        return null;
    }
}
