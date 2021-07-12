package DataStructures.Arrays;

import java.util.Arrays;

public class GenericNArrayConcatenation {
    public static <T> T[] nArrayConcat(T[] first , T[]...rest){
        var totalLength = first.length;
        for (var array : rest)
            totalLength += array.length;

        T[] result = Arrays.copyOf(first , totalLength);

        var offset = first.length;

        for (var array : rest){
            System.arraycopy(array , 0 , result , offset , array.length);
            offset += array.length;
        }
        return result;
    }

    public static void main (String[] args) {
        Integer[] first = new Integer[]{1 , 2 , 3 , 4 , 5};
        Integer[] second = new Integer[]{6 , 7 , 8 , 9 , 10};
        Integer[] third = new Integer[]{11 , 12 , 13 , 14 , 15};
        Integer[] fourth = new Integer[]{16 , 17 , 18 , 19 , 20};

        var newArray = nArrayConcat(first , second , third , fourth);

        System.out.println( Arrays.toString(newArray) );
    }
}
