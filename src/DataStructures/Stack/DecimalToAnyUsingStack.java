package DataStructures.Stack;

import java.util.Stack;

public class DecimalToAnyUsingStack {
    public static void main (String[] args) {
        System.out.println(convert(10,2));
    }
    /**
     * Convert decimal number to another radix
     *
     * @param number the number to be converted
     * @param radix the radix
     * @return another radix
     * @throws ArithmeticException if <tt>number</tt> or <tt>radius</tt> is invalid
     */
    public static String convert(int number , int radix){
        if (radix < 2 || radix > 16){
            throw new IllegalArgumentException("Invalid argument");
        }
        Stack<Character> bits = new Stack<>();
        String table = "0123456789ABCDEF";
        do {
            bits.push(table.charAt(number % radix));
            number /= radix;
        } while (number != 0);
        StringBuilder result = new StringBuilder();
        while (!bits.empty()){
            result.append(bits.pop());
        }
        return result.toString();
    }
}
