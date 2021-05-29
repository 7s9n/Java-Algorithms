package Conversions;

/**
 *  This class converts a Decimal number to a Binary number .
 */
public class DecimalToBinary {

    public static void main (String[] args) {
        // test 900 times
        for (int i = 0; i < 900; i++) {
            assert Integer.parseInt(Integer.toBinaryString(i)) == decimalToBinary(i);
            assert Integer.parseInt(Integer.toBinaryString(i)) == decimalToBinaryBitWise(i);
        }
    }

    /**
     * This method converts a decimal number to a binary number using a conventional algorithm.
     * @param decimal number
     * @return binary form of the decimal.
     */
    public static int decimalToBinary(int decimal){
        int bit , b = 0 , c = 0 ;
        while (decimal != 0){
            bit = decimal % 2 ;
            b = b + bit * (int) Math.pow(10 , c++);
            decimal /= 2;
        }
        return b;
    }

    /***
     * This method converts a decimal number to a binary number using a bitwise algorithm.
     * @param decimal number
     * @return binary form of the decimal.
     */
    public static int decimalToBinaryBitWise(int decimal){
        int b = 0 , c = 0 , bit;
        while (decimal != 0){
            bit = (decimal & 0b1);
            b += bit * (int)Math.pow(10 , c++);
            decimal >>= 1;
        }
        return b;
    }

}
