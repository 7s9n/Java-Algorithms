package Maths;

import java.util.Arrays;

public class Median {
    public static void main (String[] args) {
        assert getMedian(0) == 0;
        assert getMedian(1, 2) == 1.5;
        assert getMedian(4, 1, 3, 2) == 2.5;
        assert getMedian(1, 3, 3, 6, 7, 8, 9) == 6;
        assert getMedian(1, 2, 3, 4, 5, 6, 8, 9) == 4.5;

        System.out.println(getMedian(1, 2, 3, 4, 5, 6, 8, 9));
        System.out.println(getMedian(3 , 2 ,0 ,8,7 ,1));
    }
    /**
     * Method to compute the median from a set of numerical values.
     * @param values number series
     * @return median of given {@code values}
     */
    public static double getMedian(int... values){
        if (values.length <= 1){
            throw new RuntimeException("Error: You may enter 2 to .... values.");
        }
        Arrays.sort(values);
        int length = values.length;
        return length % 2 != 0 ? (values[length / 2]) : (values[length / 2 ] + values[length / 2 - 1]) / 2.0;
    }
}
