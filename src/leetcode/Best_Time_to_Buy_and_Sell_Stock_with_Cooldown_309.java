package leetcode;

/**
 * 功能描述:
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p/>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 * <p/>
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example:
 * <p/>
 * prices = [1, 2, 3, 0, 2]
 * maxProfit = 3
 * transactions = [buy, sell, cooldown, buy, sell]
 *
 * @Author ewnit
 * @Date 16/11/26.
 */
public class Best_Time_to_Buy_and_Sell_Stock_with_Cooldown_309 {

    /**
     * dp+贪心
     * 局部最优并不是全局最优 因为有状态 持有/不持有
     *
     * 用一个位置表示状态量?
     * dp[i][0]=max(dp[i][0],dp[i][1]+prices[day-1]-in)
     *
     * https://discuss.leetcode.com/topic/30421/share-my-thinking-process
     *
     * 直接分开跑三个状态
     *
     * buy[day]=buy[
     *
     * dfs?
     * <p/>
     * int operation={0,1,2} //buy cooldown sell
     * int have=0; //1=have 0=not have
     * dfs(int prices[],int have,int profit,int day, boolean cooldown){
     * if(day>=prices.length){
     * Math.max(max,profit);
     * return;
     * }
     * if(cooldown){
     * dfs(prices,have,profit,day+1,false);
     * }
     * if(have==1){
     * //sell
     * dfs(prices,0,profit+prices[day-1],day+1,true);
     * }else{
     * //buy
     * dfs(prices,1,profit-prices[day-1],day+1,false);
     * }
     * //cooldown
     * dfs(prices,have,profit,day+1,false);
     * }
     */

    public int maxProfit(int[] prices) {
        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;
    }
    /**
     * @Description

    dfs会超时


    int max = 0;

    public int maxProfit(int[] prices) {
        dfs(prices, 0, 0, 1, false, 0);
        return max;
    }

    public void dfs(int prices[], int have, int profit, int day, boolean cooldown, int money) {
        if (day > prices.length) {
            max = Math.max(max, profit);
            return;
        }
        if (cooldown) {
            dfs(prices, have, profit, day + 1, false, money);
            return;
        }
        if (have == 1) {
            //sell
            if (money < prices[day - 1])
                dfs(prices, 0, profit + prices[day - 1] - money, day + 1, true, 0);
        } else {
            //buy
            dfs(prices, 1, profit, day + 1, false, prices[day - 1]);
        }
        //cooldown
        dfs(prices, have, profit, day + 1, false, money);
    }
     */



    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(new Best_Time_to_Buy_and_Sell_Stock_with_Cooldown_309().maxProfit(prices));
    }

}
