package Conversions;

/**
 * This class converts a Binary number to a Decimal number.
 */

public class BinaryToDecimal {
    public static void main (String[] args) {
        System.out.println(binaryToDecimal(11));
    }
    public static int binaryToDecimal(int bin){
        int rem , dec = 0 , c = 0;
        while (bin != 0){
            rem = bin % 10;
            dec += rem * (int)Math.pow(2 , c++);
            bin /= 10;
        }
        return dec;
    }
}
