package leetcode;

/**
 * 功能描述:
 * Given an unsorted array of integers, find the number of longest increasing subsequence.
 * <p>
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 2
 * Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
 * Example 2:
 * Input: [2,2,2,2,2]
 * Output: 5
 * Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
 * Note: Length of the given array will be not exceed 2000 and the answer is guaranteed to be fit in 32-bit signed int.
 *
 * @Author chen.yiran
 * @Date 17/9/15.
 */
public class Number_of_Longest_Increasing_Subsequence_673 {

    /**
     * 1,3,5,4,7
     * 1,2,3,3,4
     * <p>
     * <p>
     * 1,3,2,5,4,7
     * 1,2,2,3,3,4
     * <p>
     * 1,3,5,7/1,3,4,7/1,2,5,7/1,2,4,7
     * <p>
     * 2,4,3,1,6,5,7,0,-1
     * 1,2,2,1,3,3,4,1,1
     */
    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int[] many = new int[nums.length];
        int max = 0, ans = 0;

        for (int i = 0; i < nums.length; i++) {
            many[i] = dp[i] = 1;
            for (int j = 0; j <= i - 1; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] == dp[j] + 1) {
                        many[i] += many[j];
                    } else if (dp[i] < dp[j] + 1) {
                        many[i] = many[j];
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            if (max == dp[i]) {
                ans += many[i];
            } else if (max < dp[i]) {
                max = dp[i];
                ans = many[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
        System.out.println(new Number_of_Longest_Increasing_Subsequence_673().findNumberOfLIS(nums));

    }
}
