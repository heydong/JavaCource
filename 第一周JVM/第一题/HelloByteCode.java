/**
 * Create by chenhd on 2021/8/3.
 */
public class HelloByteCode {

    public static double calSum() {
        double sum = 0;
        for (int count = 0; count < 100; count++) {
            sum += count;
            if (sum > 3000) {
                break;
            }
        }
        return sum;
    }

}
