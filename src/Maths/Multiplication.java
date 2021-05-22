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
    public static long multiplyUsingLogs(int a , int b){
        int absA = Math.abs(a);
        int absB = Math.abs(b);
        long result = Math.round(Math.pow(10 , Math.log10(absA) + Math.log10(absB)));
        return (a > 0 && b > 0 || a < 0 && b < 0) ? result : -result;
    }
    public static void main (String[] args) {
        System.out.println(multiplyUsingLoop(9,6));
        System.out.println(multiplyUsingLogs(9,6));
        System.out.println(multiplyUsingLoop(9,99));
        System.out.println(multiplyUsingLogs(9,99));
    }
}
