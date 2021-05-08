package Maths;

import java.util.Arrays;

public class StandardDeviation {
    public static void main (String[] args) {
        System.out.println(getStandardDeviation(2,3,7,4));
    }
    public static double getStandardDeviation(int ... values){
        if (values.length == 1){
            throw new ArithmeticException("Divide by zero");
        }
        double mean = Arrays.stream(values).sum() / values.length;
        double stdDev = 0.0;
        for (int value : values){
            stdDev += Math.pow((value - mean), 2) ;
        }
        stdDev /= values.length;
        stdDev = Math.sqrt(stdDev);
        return stdDev;
    }
}
