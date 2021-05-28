package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 *
 *
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 *
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 *
 *
 * Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */
public class TwoSum {
    public static void main (String[] args) {
        int [] nums = new int[]{1,2,3,4,5};
        var ans = twoSum(nums , 3);
        var ans2 = twoSum2(nums , 3);
        System.out.println(ans[0] + " : " + ans[1]);
        System.out.println(ans2[0] + " : " + ans2[1]);
    }
    /**
     * Approach 1: Brute Force
     * The brute force approach is simple.
     * Loop through each element x and find if there is another value that equals to target - x .
     * @param nums array of ints
     * @param target number
     * @return indices of the two numbers such that they add up to target.
     */
    public static int[] twoSum2(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; ++i){
            for (int j = i + 1; j < len; j++) {
                if (nums[j] == target - nums[i])
                    return new int[]{i , j};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    /**
     * Approach 2: One-pass Hash Table
     * It turns out we can do it in one-pass.
     * While we iterate and inserting elements into the table,
     * we also look back to check if current element's complement already exists in the table.
     * If it exists, we have found a solution and return immediately.
     * @param nums array of ints
     * @param target number
     * @return indices of the two numbers such that they add up to target.
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer , Integer> map = new HashMap<>();
        for (int i = 0 , len = nums.length; i < len; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement))
                return new int[]{map.get(complement) , i};
            map.put(nums[i] , i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
