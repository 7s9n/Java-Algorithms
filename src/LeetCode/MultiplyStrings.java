package LeetCode;

/**
 * Given two non-negative integers num1 and num2 represented as strings,
 * return the product of num1 and num2, also represented as a string.
 *
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 *
 *
 * Example 1:
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 *
 * Example 2:
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 *
 * Constraints:
 *
 * 1 <= num1.length, num2.length <= 200
 * num1 and num2 consist of digits only.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 */
public class MultiplyStrings {
    public static void main (String[] args) {
        assert multiply("123" , "4").equals("492");
    }
    public static String multiply(String a , String b){
        if (a.equals("0") || b.equals("0"))
            return "0";
        int aLen = a.length();
        int bLen = b.length();
        int[] digits = new int[aLen + bLen];
        for (int i = aLen - 1; i >= 0; --i) {
            for (int j = bLen -1; j >= 0 ; --j) {
                int mul = (a.charAt(i) - '0') * (b.charAt(j) - '0');
                int sum = digits[i + j + 1] + mul;
                digits[i + j] += sum / 10; // this is the cary digit
                digits[i + j + 1] = sum % 10; // the target digit in our column
            }
        }
        StringBuilder result = new StringBuilder();
        for (int digit : digits)
            result.append(digit);
        // remove leading zeros
        while (result.charAt(0) == '0')
            result.deleteCharAt(0);
        return result.toString();
    }
}
