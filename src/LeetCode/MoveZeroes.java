package LeetCode;

import java.util.Arrays;

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
