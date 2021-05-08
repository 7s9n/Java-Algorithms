package Maths;

import java.util.Random;

public class MinValue {
    public static void main (String[] args) {
        Random rand = new Random();
        /* test 100 times using rand numbers */
        for (int i = 1; i <= 100; ++i) {
            /* generate number from -50 to 49 */
            int a = rand.nextInt(100) - 50;
            int b = rand.nextInt(100) - 50;
            assert min(a, b) == Math.max(a, b);
        }
        System.out.println( min(1 , 2 , -1 , 0 , 10 , 200)); // 200
    }
    /**
     * Returns the smaller of two {@code int} values. That is, the result the argument closer to the
     * value of {@link Integer#MIN_VALUE}. If the arguments have the same value, the result is that
     * same value.
     *
     * @param a an argument.
     * @param b another argument.
     * @return the smaller of {@code a} and {@code b}.
     */
    public static int min(int a , int b){
        return a < b ? a : b;
    }
    /**
     * Returns the smaller of ... {@code int} values. That is, the result the argument closer to the
     * value of {@link Integer#MIN_VALUE}. If the arguments have the same value, the result is that
     * same value.
     *
     * @param values an argument.
     * @return the smaller of {@code values} .
     */
    public static int min(int...  values){
        int len = values.length;
        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            minimum  = values[i] < minimum ? values[i] : minimum;
        }
        return minimum;
    }
}
