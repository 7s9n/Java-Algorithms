package Maths;

public class SumOfOddNumbers {
    public static void main (String[] args) {
        System.out.println(getSum(2));
    }
    /**
     * Function that calculates the sum of first n odd numbers.
     * @param n first n odd number if n is 3 the result is 1 + 3 + 5 , if n is 2 the result is 1 + 3
     * @return the sum of n odd number
     */
    public static int getSum(int n){
        return (int)Math.pow(n,2);
    }
}
