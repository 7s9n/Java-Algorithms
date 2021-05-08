package Maths;

import java.util.Collection;
import java.util.Random;

public class MaxValue {
    public static void main (String[] args) {
        Random rand = new Random();
        /* test 100 times using rand numbers */
        for (int i = 1; i <= 100; ++i) {
            /* generate number from -50 to 49 */
            int a = rand.nextInt(100) - 50;
            int b = rand.nextInt(100) - 50;
            assert max(a, b) == Math.max(a, b);
        }
        System.out.println( max(1 , 2 , -1 , 0 , 10 , 200)); // 200
    }
    /**
     * Returns the greater of two {@code int} values. That is, the result is the argument closer to
     * the value of {@link Integer#MAX_VALUE}. If the arguments have the same value, the result is
     * that same value.
     *
     * @param a an argument.
     * @param b another argument.
     * @return the larger of {@code a} and {@code b}.
     */
    public static int max(int a , int b){
        return a > b ? a : b;
    }
    /**
     * Returns the greater of ... {@code int} values. That is, the result is the argument closer to
     * the value of {@link Integer#MAX_VALUE}. If the arguments have the same value, the result is
     * that same value.
     *
     * @param values are array of integers.
     * @return the larger of {@code values}.
     */
    public static int max(int...  values){
        int len = values.length;
        int maximum = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            maximum  = values[i] > maximum ? values[i] : maximum;
        }
        return maximum;
    }
}
