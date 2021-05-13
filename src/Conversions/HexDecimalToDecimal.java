package Conversions;

/**
 * for more information look at wikipedia.
 * https://simple.wikipedia.org/wiki/Hexadecimal#:~:text=To%20convert%20a%20number%20from,14%2C%20and%20F%20%3D%2015.
 */
public class HexDecimalToDecimal {
    public static void main (String[] args) {
        System.out.println(hexDecimalToDecimal("f"));
    }
    public static int hexDecimalToDecimal(String hex){
        hex = hex.toUpperCase();
        int dec = 0 , size = hex.length();
        String table = "0123456789ABCDEF";
        for (int i = 0; i < size; i++) {
            int digit = table.indexOf(hex.charAt(i));
            if (digit == -1){
                throw new NumberFormatException("Enter a valid hex value");
            }
            dec = dec * 16 + digit;
        }
        return dec;
    }
}
