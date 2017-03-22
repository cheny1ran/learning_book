package leetcode;

/**
 * 功能描述:
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 * <p>
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 * <p>
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 *
 * @Author chen.yiran
 * @Date 17/3/2.
 */
public class Coin_Change_322 {

    // 背包问题

    /**
     * greedy to make big amount money much
     *
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = max;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        int[] coins = {2};
        System.out.println(new Coin_Change_322().coinChange(coins, 3));
    }
}
