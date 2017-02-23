package leetcode;

/**
 * 功能描述:
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * <p>
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.
 * <p>
 * Your algorithm should run in O(n2) complexity.
 * <p>
 * Follow up: Could you improve it to O(n log n) time complexity?
 *
 * @Author chen.yiran
 * @Date 17/2/17.
 */
public class Longest_Increasing_Subsequence_300 {

    /**
     * 9 10 2 100 102
     * 10,9,2,5,3,4
     * 4,10,4,3,8,9
     * 1,2,3,3,1,3
     * 局部最优不等于全局最优
     * dp[i]=nums[i]>nums[i-1]?dp[i-1]+1:dp[i-1];
     *
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] ans = new int[nums.length];
        ans[nums.length-1] = 1;
        int max = 0;
        for (int i = nums.length-1; i >=0; i--) {
            ans[i] = 1;
            for (int j = nums.length-1; j >=i; j--) {
                ans[i] = Math.max(ans[i], nums[j] > nums[i] ? ans[j] + 1 : ans[i]);
                max = Math.max(max, ans[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {4, 10, 4, 3, 8, 9};
        System.out.println(new Longest_Increasing_Subsequence_300().lengthOfLIS(nums));
    }
}
