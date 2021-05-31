package LeetCode;

import java.util.Arrays;

/**
 * Given an integer array nums, move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 *
 * Follow up: Could you minimize the total number of operations done?
 */
public class MoveZeroes {
    public static void main (String[] args) {
        int[] nums = new int[]{0,1,2,0,3,0,4,5,0};
        moveZeroesV2(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void moveZeroes(int[] nums) {
        int lastNonZeroFoundAt = 0 , len = nums.length;
        // If the current element is not 0, then we need to
        // append it just in front of last non 0 element we found.
        for (int i = 0; i < len ; i++) {
            if (nums[i] != 0)
                nums[lastNonZeroFoundAt++] = nums[i];
        }
        // After we have finished processing new elements,
        // all the non-zero elements are already at beginning of array.
        // We just need to fill remaining array with 0's.
        while (lastNonZeroFoundAt < len)
            nums[lastNonZeroFoundAt++] = 0;
    }
    public static void moveZeroesV2(int[] nums) {
        int len = nums.length;
        // If the current element is not 0, then we need to
        // append it just in front of last non 0 element we found.
        for (int lastNonZeroFoundAt = 0, cur = 0; cur < len ; cur++) {
            if (nums[cur] != 0){
                int t = nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt++] = nums[cur];
                nums[cur] = t;
            }
        }
    }
}
