package LeetCode;


/**
 * Given an integer num, return a string representing its hexadecimal representation.
 * For negative integers, two’s complement method is used.
 *
 * All the letters in the answer string should be lowercase characters,
 * and there should not be any leading zeros in the answer except for the zero itself.
 * Note: You are not allowed to use any built-in library method to directly solve this problem.
 *
 *
 *
 * Example 1:
 * Input: num = 26
 * Output: "1a"
 *
 * Example 2:
 * Input: num = -1
 * Output: "ffffffff"
 *
 * Constraints:
 * -231 <= num <= 231 - 1
 */
public class ConvertANumberToHexadecimal {
    public static void main (String[] args) {
        System.out.println(toHex(999999999));
    }
    public static String toHex(int num) {
        String hexDigit = "0123456789abcdef";
        if(num == 0) return "0";
        String ans = "";
        while (num != 0){
            ans = hexDigit.charAt(num & 15) + ans;
            num >>>= 4;
        }
        return ans;
    }
}