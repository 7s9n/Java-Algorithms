package Maths;

import java.util.Arrays;

public class Mean {
    public static void main (String[] args) {
        System.out.println(getMean(new int[]{1 , 2 , 2}));
        System.out.println(getMean(3, 4, 6, 6, 8, 9, 11));
    }
    public static double getMean(int... values){
        double sum = Arrays.stream(values).sum();
        return sum / values.length;
    }
}
