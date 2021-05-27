package LeetCode;

import java.util.Arrays;

/**
 * Given an array nums with n objects colored red, white, or blue,
 * sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 *
 * Example 1:
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 * Example 2:
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 *
 * Example 3:
 * Input: nums = [0]
 * Output: [0]
 *
 * Example 4:
 * Input: nums = [1]
 * Output: [1]
 */
public class SortColors {
    public static void main (String[] args) {
        int [] colors = new int[]{1,0,2,1,2,2,0};
        sortColors(colors);
        for (var color : colors)
            System.out.print(color + " ");
    }
    public static void sortColors(int [] nums){
        int start = 0 , end = nums.length -1, idx = 0;
        while (idx <= end && start < end){
            if (nums[idx] == 0){
                nums[idx++] = nums[start];
                nums[start++] = 0;
            }else if(nums[idx] == 2){
                nums[idx] = nums[end];
                nums[end--] = 2;
            }else{
                ++idx;
            }
        } // end of while
    }
}
