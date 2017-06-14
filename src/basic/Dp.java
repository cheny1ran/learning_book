package basic;

import leetcode.*;

/**
 * 功能描述:
 * dp 关键在于问题切分和状态转移
 *
 * @Author ewnit
 * @Date 16/11/12.
 */
public class Dp {

    // 1、凑硬币 有2、3、5面值硬币，用最少的硬币凑到所给值。O(val*availCoins.length)
    public int culMinCoins(int val, int[] availCoins) {
        int[] dp = new int[val + 1];
        dp[0] = 0;
        for (int i = 1; i <= val; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < availCoins.length; j++) {
                if (availCoins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - availCoins[j]] + 1);
                }
            }
            if (dp[i] == Integer.MAX_VALUE) dp[i] = 0;
        }
        return dp[val];
    }

    // LIS 最长递增子序列 O(n^2)
    public int LIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[j] + (nums[i] >= nums[j] ? 1 : 0), dp[i]);
            }
        }
        return dp[nums.length - 1];
    }


    // 列出所有dp相关的题目
    public static void main(String[] args) {

        Dp dp = new Dp();
        int[] avail = {1, 3, 5};
        System.out.println(dp.culMinCoins(5, avail));

        int[] nums = {5, 3, 4, 8, 6, 7};
        System.out.println(dp.LIS(nums));

        new Best_Time_to_Buy_and_Sell_Stock_with_Cooldown_309();
        new Decode_Ways_91();
        new Maximal_Square_221();
        new Coin_Change_322();
        new Palindrome_Partitioning_II_132();
        new Wildcard_Matching_44();
        new Word_Break_139();

    }
}
