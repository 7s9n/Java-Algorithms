package LeetCode;

/**
 * Given a non-empty array of decimal digits representing a non-negative integer,increment one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list,
 * and each element in the array contains a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 *
 * Example 2:
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 *
 * Example 3:
 * Input: digits = [0]
 * Output: [1]
 *
 * Constraints:
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 */
public class PlusOne {
    public static void main (String[] args) {
        for (var num : plusOne(new int[]{1,9}))
            System.out.print(num + " ");
    }
    public static int[] plusOne(int[] digits) {
        int idx = digits.length - 1;
        while (idx >= 0){
            if (digits[idx] == 9)
                digits[idx--] = 0;
            else{
                digits[idx]++;
                return digits;
            }
        } // end of while.
        int[] res = new  int[digits.length + 1];
        res[0] = 1;
        return digits;
    }
}
