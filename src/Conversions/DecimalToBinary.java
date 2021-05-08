package Conversions;

/**
 *  This class converts a Decimal number to a Binary number .
 *
 */
public class DecimalToBinary {
    public static void main (String[] args) {
        System.out.println(decimalToBinary(200));
        System.out.println(decimalToBinaryBitWise(200));
    }
    public static int decimalToBinary(int decimal){
        int bit = 0, b = 0 , c = 0 ;
        while (decimal != 0){
            bit = decimal % 2 ;
            b = b + bit * (int) Math.pow(10 , c++);
            decimal /= 2;
        }
        return b;
    }

    /***
     * This method converts a decimal number to a binary number using a bitwise algorithm.
     * @param decimal
     * @return binary form of the decimal.
     */
    public static int decimalToBinaryBitWise(int decimal){
        int b = 0 , c = 0 , bit;
        while (decimal != 0){
            bit = (decimal & 0x1);
            b += bit * (int)Math.pow(10 , c++);
            decimal >>= 1;
        }
        return b;
    }

}
