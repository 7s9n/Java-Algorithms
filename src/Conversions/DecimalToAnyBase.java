package Conversions;

public class DecimalToAnyBase {
    /**
     *
     * @param n is a decimal number to be converted.
     * @param base base that we want to convert to
     * @return a string format of n in base.
     */
    public static String convertToAnyBase(int n , int base){
        StringBuilder ans = new StringBuilder();
        while ()
    }
    /**
     * This method produces character value of the input integer and returns it
     *
     * @param num integer of which we need the character value of
     * @return character value of input integer
     */
    public static char getChar(int num){
        if (num >= 0 && num <= 9)
            return (char) (num + '0');
        return (char) (num - 10 + 'A');
    }
}
