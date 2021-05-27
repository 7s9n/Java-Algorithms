package Maths;

/**
 * Given a number N, calculate the sum of all the digits in 1–N
 */
public class SumOfDigits {
    public static void main (String[] args) {
        System.out.println(sumOfDigits(328));
    }
    /**
     * Function to computer sum of digits in
     * numbers from 1 to n.
     * @param x is the last number in the range for example if x is 90 then sum of digits from 1 - 90
     * @return sum of digits from 1 to x
     */
    public static int sumOfDigits(int x){
        if (x<10) return x*(x+1)/2;

        int d = (int)Math.log10(x); //number of digits less one
        int p = (int)Math.pow(10,d);
        int msd = x/p; // Most significant digit (msd) of n, which can be obtained using x / p

        return (int) ((msd * 45 * d * Math.pow(10,d-1)) + (msd * (msd-1)/2 * p) + (msd * (1+ x%p) + sumOfDigits(x%p)));
    }
}
