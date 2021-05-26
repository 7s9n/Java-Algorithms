package Maths;

import java.math.BigInteger;

public class PrimalityTest {
    public static void main (String[] args) {
        var primes = SieveOfEratosthenes.sieveOfEratosthenes(200000000);
        for (int prime : primes)
            assert isPrime(prime) == new BigInteger(String.valueOf(prime)).isProbablePrime(1);
    }
    /***
     * Checks if a number is prime or not using trialDivision
     * @param n the number
     * @return {@code true} if {@code n} is prime
     */
    public static boolean isPrime(int n){
        if (n == 2)
            return true;
        if (n % 2 == 0)
            return false;
        for (int i = 3 , limit = (int)Math.sqrt(n); i <= limit; i += 2){
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
