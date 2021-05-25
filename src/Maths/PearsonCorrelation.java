package Maths;

import java.util.Arrays;

public class PearsonCorrelation {
    public static void main (String[] args) {
        int[] x = new int[]{ 2 , 5 , 1 , 3 , 4 };
        int[] y = new int[]{ 8 , 3 , 1 , 2 , 5 };
        System.out.println(getPearsonCorrelation(x  , y));
        System.out.println(getPearsonCorrelation2(x , y));
    }

    /**
     * This method computes Pearson's correlation coefficients.
     * @param x values.
     * @param y values.
     * @return the correlation coefficient between two data sets.
     */
    public static double getPearsonCorrelation(int[] x , int[] y){
        int len = x.length;
        if (len != y.length || len <= 0){
            throw new RuntimeException("Error! Please ensure you have the same number of scores for both your X and Y variable.");
        }
        double sigmaX , sigmaY , sigmaXY , sigmaXS , sigmaYS ;
        sigmaX = sigmaY = sigmaXY = sigmaXS = sigmaYS = 0.0;
        for (int i = 0; i < len; ++i){
            sigmaX += x[i]; // sum of elements of array x.
            sigmaY += y[i]; // sum of elements of array y.
            sigmaXY += ( x[i] * y[i] );
            sigmaXS += ( x[i] * x[i]);
            sigmaYS += ( y[i] * y[i]);
        }
        return (len * sigmaXY - sigmaX * sigmaY) /
                Math.sqrt( (len * sigmaXS - sigmaX * sigmaX) * (len * sigmaYS - sigmaY * sigmaY) );
    }
    /**
     * This method computes Pearson's correlation coefficients ,
     * It's another implementation for Pearson's correlation coefficients.
     * @param x values
     * @param y values
     * @return the correlation coefficient between two data sets.
     */
    public static double getPearsonCorrelation2(int[] x , int[] y){
        if (x.length != y.length || x.length <= 0){
            throw new RuntimeException("Error! Please ensure you have the same number of scores for both your X and Y variable.");
        }
        double meanX = Arrays.stream(x).average().getAsDouble();
        double meanY = Arrays.stream(y).average().getAsDouble();
        double r = 0.0;
        double squareSumXMinusMeanX = 0.0;
        double squareSumYMinusMeanY = 0.0;
        for (int i = 0; i < x.length; i++) {
            r += (x[i] - meanX) * (y[i] - meanY);
            squareSumXMinusMeanX += Math.pow((x[i] - meanX), 2) ;
            squareSumYMinusMeanY += Math.pow((y[i] - meanY), 2) ;
        }
        squareSumXMinusMeanX = Math.sqrt(squareSumXMinusMeanX);
        squareSumYMinusMeanY = Math.sqrt(squareSumYMinusMeanY);
        return r / (squareSumXMinusMeanX * squareSumYMinusMeanY);
    }
}
