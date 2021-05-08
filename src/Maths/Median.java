package Maths;

import java.util.Arrays;

public class Median {
    public static void main (String[] args) {
        assert getMedian(new int[] {0}) == 0;
        assert getMedian(new int[] {1, 2}) == 1.5;
        assert getMedian(new int[] {4, 1, 3, 2}) == 2.5;
        assert getMedian(new int[] {1, 3, 3, 6, 7, 8, 9}) == 6;
        assert getMedian(new int[] {1, 2, 3, 4, 5, 6, 8, 9}) == 4.5;

        System.out.println(getMedian(new int[]{1, 2, 3, 4, 5, 6, 8, 9}));
    }
    /**
     * Calculate average median
     *
     * @param values number series
     * @return median of given {@code values}
     */
    public static double getMedian(int[] values){
        Arrays.sort(values);
        int length = values.length;
        return length % 2 != 0 ? (values[length / 2]) : (values[length / 2 ] + values[length / 2 - 1]) / 2.0;
    }
}
