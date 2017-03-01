package leetcode;

/**
 * 功能描述:
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * @Author chen.yiran
 * @Date 17/3/1.
 */
public class Two_Sum_1 {

    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            ans[0] = i;
            int sub = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == sub) {
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }
}
