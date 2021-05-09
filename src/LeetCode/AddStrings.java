package LeetCode;

/**
 * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
 * Example 1:
 * Input: num1 = "11", num2 = "123"
 * Output: "134"
 * Example 2:
 * Input: num1 = "456", num2 = "77"
 * Output: "533"
 * Example 3:
 * Input: num1 = "0", num2 = "0"
 * Output: "0"
 *
 * Constraints:
 * 1 <= num1.length, num2.length <= 104
 * num1 and num2 consist of only digits.
 * num1 and num2 don't have any leading zeros except for the zero itself.
 *
 * Follow up: Could you solve it without using any built-in BigInteger library or converting the inputs to integer directly?
 *
 */
public class AddStrings {
    public static void main (String[] args) {
        System.out.println(addStrings("99" , "2"));
    }
    public static String addStrings(String num1 , String num2){
        int i = num1.length() -1, j = num2.length() -1, sum = 0;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0){
            int x  = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j--)  - '0' : 0;
            sum += x +y;
            result.append(sum % 10);
            sum /= 10;
        } // end of while
        if (sum != 0) result.append(1);
        return result.reverse().toString();
    }
}
