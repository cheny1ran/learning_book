package leetcode;

import java.util.Arrays;

/**
 * 功能描述:
 * <p>
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * <p>
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * <p>
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 *
 * @Author chen.yiran
 * @Date 17/5/3.
 */
public class Missing_Number_268 {

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i - 1] + 1) != nums[i]) return nums[i - 1] + 1;
        }
        return nums[0] == 0 ? nums[nums.length - 1] + 1 : nums[0] - 1;
    }
}
