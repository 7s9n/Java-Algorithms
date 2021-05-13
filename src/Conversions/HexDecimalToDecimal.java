package Conversions;

import java.util.Locale;

public class HexDecimalToDecimal {
    public static void main (String[] args) {
        System.out.println(hexDecimalToDecimal("abcdef"));
    }
    public static int hexDecimalToDecimal(String hex){
        hex = hex.toUpperCase();
        int dec = 0 , cnt = 0;
        for (int i = hex.length() -1; i >= 0 ; --i) {
            char c = hex.charAt(i);
            int num = (Character.isDigit(c) ? c - '0' : c - 'A' + 10);
            if (num < 0 || num >= 16){
                throw new NumberFormatException("Error , enter valid hex decimal");
            }
            dec += num * Math.pow(16,cnt++);
        }
        return dec;
    }
}
