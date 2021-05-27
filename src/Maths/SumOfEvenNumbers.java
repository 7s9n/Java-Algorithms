package Maths;

public class SumOfEvenNumbers {
    public static void main (String[] args) {
        System.out.println(getSum(3));
    }
    /**
     * Function that calculates the sum of first n even numbers.
     * @param n first n even number if n is 3 the result is 2 + 4 + 6 , if n is 2 the result is 2 + 4
     * @return the sum of n even number
     */
    public static int getSum(int n){
        return n * (n + 1);
    }
}
