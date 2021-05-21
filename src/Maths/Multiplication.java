package Maths;

public class Multiplication {
    public static long multiplyUsingLoop(int a , int b){
        int absB = Math.abs(b);
        long result = 0;
        for (int i = 0; i < absB; i++) {
            result += a;
        }
        return (b < 0) ? -result : result;
    }
    public static void main (String[] args) {
        System.out.println(multiplyUsingLoop(9,6));
    }
}
