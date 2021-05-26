package Maths;

public class Factorial {
    public static void main (String[] args) {
        assert factorial(0) == 1;
        assert factorial(1) == 1;
        assert factorial(11) == 39916800;
        assert factorial(12) == 479001600;
        System.out.println(factorial(21));
    }
    /**
     * Calculate factorial of N using iteration approach
     *
     * @param n the number
     * @return the factorial of {@code n}
     */
    public static long factorial(int n){
        if (n < 0 || n > 20){
            throw new IllegalArgumentException("Either number is negative or bigger than 20");
        } // Factorials n > 20 can’t be stored even in a 64 bit long long variable.
        long fact = 1;
        for (int i = 1; i <= n; fact *= i , ++i);
        return fact;
    }
}
