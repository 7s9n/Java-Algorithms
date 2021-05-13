package Maths;

public class GCD {
    public static void main (String[] args) {
        System.out.println(getGCD(12,6));
        System.out.println(getGCD2(12,6));
        System.out.println(getGCD3(12,6));
    }

    /**
     * The recursive version.
     * @param a first number.
     * @param b second number.
     * @return gcd
     */
    public static int getGCD(int a , int b){
       if (a == 0)
           return b;
       return getGCD(b % a ,a);
    }

    /**
     * the division-based version.
     * @param a first number.
     * @param b second number.
     * @return gcd
     */
    public static int getGCD2(int a , int b){
        while (b != 0){
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

    /**
     * subtraction-based version which was Euclid's original version,
     * the remainder calculation (b := a mod b) is replaced by repeated subtraction.
     * @param a first number.
     * @param b second number.
     * @return gcd
     */
    public static int getGCD3(int a , int b){
        while (a != b){
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        return a;
    }
}
