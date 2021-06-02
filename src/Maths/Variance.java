package Maths;

import java.util.Arrays;

public class Variance {
    public static void main (String[] args) {
        // test
        System.out.println(getVarianceP(2, 3 , 7 , 4 ));
        System.out.println(getVarianceS(2, 3 , 7 , 4 ));
        System.out.println(getVarianceP(4,7,3,2));
        //System.out.println(getVarianceS(1)); // gives error.
    }
    /**
     * This method calculates variance based on the entire population given as argument.
     * @param values data set (argument).
     * @return variance of the given data set.
     */
    public static double getVarianceP(int ... values){
        double mean = Arrays.stream(values).sum() / values.length;
        double variance = 0.0;
        for (int value : values){
            variance += Math.pow((value - mean), 2);
        }
        variance /= values.length; //Divide the sum of the squares by n (for a population).
        return variance;
    }
    /**
     * This  method calculates variance based on a sample given as argument.
     * @param values data set (argument).
     * @return variance of the given data set.
     */
    public static double getVarianceS(int ... values){
        if (values.length <= 1){
            throw new RuntimeException("Error: You may enter at least 2 values.");
        }
        double mean = Arrays.stream(values).average().getAsDouble();
        double variance = 0.0;
        for (int value : values){
            variance += Math.pow((value - mean), 2) ;
        }
        variance /= values.length - 1; //Divide the sum of the squares by n – 1 (for a sample) .
        return variance;
    }
}
