package Maths;

import java.util.Arrays;

public class Range {
    public static void main (String[] args) {
        System.out.println(getRange(1 , 2 , 3 , 4));
    }
    public static int getRange(int... values){
        return Arrays.stream(values).max().getAsInt() - Arrays.stream(values).min().getAsInt();
    }
}
