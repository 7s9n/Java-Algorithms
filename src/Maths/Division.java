package Maths;

public class Division {
    public static float divisionUsingLoop(int a , int b){
        if (b == 0){
            throw new ArithmeticException("Second number is 0");
        }
        int absA = Math.abs(a);
        int absB = Math.abs(b);
        int tmp = absA;
        float result = 0.0f;
        while (tmp >= 0){
            tmp -= absB;
            if (tmp >= 0)
                ++result;
        }
        return (a > 0 && b > 0 || a < 0 && b < 0) ? result : -result;
    }
    // log(a/b)=log(a)−log(b).
    public static float divisionUsingLogs(int a , int b){
        if (b == 0){
            throw new ArithmeticException("Second number is 0");
        }
        int absA = Math.abs(a);
        int absB = Math.abs(b);
        double logBas10A = Math.log10(absA);
        double logBas10B = Math.log10(absB);
        double powOf10 = Math.pow(10 , (logBas10A - logBas10B));
        float result = (float) Math.floor(powOf10);
        return (a > 0 && b > 0 || a < 0 && b < 0) ? result : -result;
    }
    public static void main (String[] args) {

        System.out.println(divisionUsingLoop(2,9));
        System.out.println(divisionUsingLogs(2,0));
    }
}
