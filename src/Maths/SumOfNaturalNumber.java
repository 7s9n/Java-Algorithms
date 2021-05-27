package Maths;

public class SumOfNaturalNumber {
    public static void main (String[] args) {
        System.out.println(getSum(6000));
    }

    /**
     * Function that calculates the sum of first n natural numbers.
     * @param n first n natural number if n is 3 the result is 1 + 2 + 3 , if n is 6 the result is 1 + 2 + 3 + 4 + 5 + 6
     * @return the sum of n natural number
     */
    public static int getSum(int n){
        return ((n & 1) != 0) ? ((n + 1) / 2) * n : (n / 2) * (n + 1);
    }
}
