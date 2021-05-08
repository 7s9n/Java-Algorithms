package Conversions;

/**
 * Converts any Octal Number to a Decimal Number
 *
 * @author Hussein Sarea
 */

public class OctalToDecimal {
    public static void main (String[] args) {
        System.out.println(octalToDecimal(20));
    }
    public static int octalToDecimal(int oct){
        int dec = 0 , rem , c = 0;
        while (oct != 0){
            rem = oct % 10;
            dec += rem  * (int)Math.pow(8 , c++);
            oct /= 10;
        }
        return dec;
    }
}
