package Maths;

import java.util.Arrays;

public class StandardDeviation {
    public static void main (String[] args) {
        // test
        System.out.println(getStandardDeviationP(2, 3 , 7 , 4 ));
        System.out.println(getStandardDeviationS(2, 3 , 7 , 4 ));
    }

    /**
     * This  method calculates standard deviation based on the entire population given as argument.
     * @param values data set (argument).
     * @return standard deviation of the given data set.
     */
    public static double getStandardDeviationP(int ... values){
        double mean = Arrays.stream(values).sum() / values.length;
        double stdDev = 0.0;
        for (int value : values){
            stdDev += Math.pow((value - mean), 2) ;
        }
        stdDev /= values.length; //Divide the sum of the squares by n (for a population).
        stdDev = Math.sqrt(stdDev);
        return stdDev;
    }
    /**
     * This  method estimates standard deviation based on sample.
     * @param values data set (sample).
     * @return standard deviation of the given data set.
     */
    public static double getStandardDeviationS(int ... values){
        if (values.length == 1 ){
            throw new ArithmeticException("Divide by zero");
        }
        double mean = Arrays.stream(values).sum() / values.length;
        double stdDev = 0.0;
        for (int value : values){
            stdDev += Math.pow((value - mean), 2) ;
        }
        stdDev /= values.length - 1; //Divide the sum of the squares by n – 1 (for a sample) .
        stdDev = Math.sqrt(stdDev);
        return stdDev;
    }
}
