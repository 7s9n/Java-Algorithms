package LeetCode;

/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence,
 * called the Fibonacci sequence, such that each number is the sum of the two preceding ones,
 * starting from 0 and 1. That is,
 *
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * Given n, calculate F(n).
 *
 *
 *
 * Example 1:
 * Input: n = 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 *
 * Example 2:
 * Input: n = 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 *
 * Example 3:
 * Input: n = 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 */
public class FibonacciNumber {
    public static void main (String[] args) {
        System.out.println(fib(44));
        System.out.println(fib2(46));
    }

    /**
     * Approach 1: Math
     * Use the golden ratio formula to calculate the Nth Fibonacci number.
     * @param n number
     * @return nth term
     */
    public static int fib(int n) {
        if (n < 0 || n > 46)
            throw new RuntimeException("Number must be in range 0 and 46");
        double goldenRatio = (1 + Math.sqrt(5)) / 2;
        return (int)Math.round(Math.pow(goldenRatio, n)/ Math.sqrt(5));
    }
    public static int fib2(int n) {
        if (n < 0 || n > 46)
            throw new RuntimeException("Number must be in range 0 and 46");
        if (n <= 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }

        int current = 0;
        int prev1 = 1;
        int prev2 = 1;

        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }
}
