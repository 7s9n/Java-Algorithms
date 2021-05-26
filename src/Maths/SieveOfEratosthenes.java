package Maths;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * In mathematics,
 * the sieve of Eratosthenes is an ancient algorithm for finding all prime numbers up to any given limit.
 */
public class SieveOfEratosthenes {
    public static void main (String[] args) {
        for (var prime : sieveOfEratosthenes(1000000000))
            assert new BigInteger(String.valueOf(prime)).isProbablePrime(1);
            //assert PrimalityTest.isPrime(prime); // This function is implemented in class PrimalityTest check it out.
    }
    /**
     * function that returns all the prime numbers less than or equal to n.
     * @param n the limit.
     * @return list of prime number less than or equal to n.
     */
    public static List<Integer> sieveOfEratosthenes(int n){
        if (n <= 1){
            throw new IllegalArgumentException("Enter number bigger than or equal to 2");
        }
        boolean [] primes = new boolean[n + 1];
        Arrays.fill(primes,true);
        List<Integer> provenPrimes = new LinkedList<>();
        for (int i = 2 , limit = (int) Math.sqrt(n); i <= limit; i++) {
            if (primes[i]){
                for (int j = i * i ; j <= n; j += i){
                    primes[j] = false;
                }
            }
        }
        provenPrimes.add(2);
        for (int i = 3 , len = primes.length ; i < len ; i += 2) {
            if (primes[i])
                provenPrimes.add(i);
        }
        return provenPrimes;
    }
}
