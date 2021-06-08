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
    //generate random number between [lowerBound - upperBound] inclusive.
    private static char getRandomChar(char lowerBound , char upperBound){
        return (char) (lowerBound + random.nextInt(upperBound + 1 - lowerBound));
    }
    /** Generate a random lowercase letter */
    public static char getRandomLowerCase(){
        return getRandomChar('a' , 'z');
    }

    /** Generate a random lowercase letter */
    public static char getRandomUpperCase(){
        return getRandomChar('A' , 'Z');
    }
    public static Character[] getUpperCaseCharacterArray(int size){
        return IntStream
                .generate(TestUtils::getRandomUpperCase)
                .limit(size)
                .mapToObj(c-> Character.valueOf((char) c))
                .toArray(Character[]::new);
    }
    public static Character[] getLowerCaseCharacterArray(int size){
        return IntStream
                .generate(TestUtils::getRandomLowerCase)
                .limit(size)
                .mapToObj(c-> Character.valueOf((char) c))
                .toArray(Character[]::new);
    }
    public static int[][] getRandomMatrix(int r , int c){
        int[][] mat = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                mat[i][j] = getRandomInt(1 , 9);
        } // end outer loop
        return mat;
    }
}
