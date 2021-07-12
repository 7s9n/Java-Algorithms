package DataStructures.Arrays;

import java.util.Arrays;

public class GenericTwoArrayConcatenation {
    public static <T> T[] arrayConcat(T[] first , T[] second){
        var result = Arrays.copyOf(first , first.length + second.length);
        System.arraycopy(second , 0 , result , first.length , second.length);
        return result;
    }

    public static void main (String[] args) {
        Integer[] first = new Integer[]{1 , 2 , 3 , 4 , 5};
        Integer[] second = new Integer[]{6 , 7 , 8 , 9 , 10};

        var newArray = arrayConcat(first , second);
        System.out.println( Arrays.toString(newArray) );
    }
}
