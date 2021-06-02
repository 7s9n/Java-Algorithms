package Utils;

import java.util.Random;
import java.util.stream.IntStream;


public class TestUtils {
    private static final Random random = new Random();
    // Generates an array of random values where every number is between
    // [min, max] and there are possible repeats.
    public static int[] randomIntegerArray(int size, int min, int max) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) array[i] = getRandomInt(min, max);
        return array;
    }
    // Generates an array of random values where every number is between
    // [min, max] and there are possible repeats.
    public static Integer[] randomIntegerSortedArray(int size, int min, int max) {
        IntStream integers = IntStream.of(randomIntegerArray(size , min , max));
        return integers.sorted().boxed().toArray(Integer[]::new);
    }
    //generate random number between [lowerBound - upperBound] inclusive.
    public static int getRandomInt(int lowerBound , int upperBound){
        return lowerBound + random.nextInt(upperBound + 1 - lowerBound);
    }
}
