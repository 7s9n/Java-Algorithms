package Maths;

public class LCM {
    public static void main (String[] args) {
        System.out.println(getLCM(2,3));
    }
    public static double getLCM(int a , int b){
        double lcm = 0d;
        if (a > 0d || b > 0d){
            lcm = Math.abs(a * b) / greatestCommonDivisor(a , b);
        }
        return lcm;
    }
    public static int greatestCommonDivisor(int a , int b){
        while (b != 0){
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}
