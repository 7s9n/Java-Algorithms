package Conversions;

import java.lang.ref.PhantomReference;

public class DecimalToHexaDecimal {
    private final static byte numOfDigit = 8;
    private final static String  alpha = "0123456789ABCDEF";
    public static void main (String[] args) {
        System.out.println(toHex(50546));
        System.out.println(decimalToHex(444444444));
    }
    public static String decimalToHex(int dec){
        StringBuilder result = new StringBuilder(numOfDigit); // capacity
        result.setLength(numOfDigit); // length
        for (int i = numOfDigit - 1; i >= 0; --i) {
            int idx = dec & 0b1111 ;
            result.setCharAt(i , alpha.charAt(idx));
            dec >>= 0b100; // 0x100 -> 4
        }
        return result.toString();
    }
    /***
     * This is a recursive method .
     * @param num to be converted
     * @return the hex value of the given num.
     */
    public static String toHex(int num){
        int rem = num % 16;
        if (num - rem == 0){
            return toChar(rem) + "";
        }
        return toHex( (num - rem) / 16 ) + toChar(rem);
    }
    public static char toChar(int n){
        var alpha = "0123456789ABCDEF";
        return alpha.charAt(n);
    }
}
