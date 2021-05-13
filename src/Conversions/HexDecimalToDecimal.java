package Conversions;

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
