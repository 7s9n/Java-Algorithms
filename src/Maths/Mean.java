package Maths;

import java.util.Arrays;

public class Mean {
    public static void main (String[] args) {
        System.out.println(getMean(1 , 2 , 2) );
        System.out.println(getMean(3, 4, 6, 6, 8, 9, 11));
        System.out.println(getMean());
    }

    /**
     * This method return the mean of the given data set
     * @param values are integers (data set)
     * @return mean (Average) .
     */
    public static double getMean(int... values){
        if (values.length < 1){
            throw new RuntimeException("Error: You may enter at least 1 value.");
        }
        double sum = Arrays.stream(values).sum(); // or use Arrays.stream(values).average().getAsDouble();
        return sum / values.length;
    }
}
