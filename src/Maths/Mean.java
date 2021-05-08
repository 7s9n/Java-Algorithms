package Maths;

public class Mean {
    public static void main (String[] args) {
        System.out.println(getMean(new int[]{1 , 2 , 2}));
    }
    public static double getMean(int... values){
        double sum = 0.0;
        for (int value : values)sum += value;
        return sum / values.length;
    }
}
