package leetcode;

/**
 * 功能描述:
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p/>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times).
 * However, you may not engage in multiple transactions at the same time
 * (ie, you must sell the stock before you buy again).
 *
 * @Author ewnit
 * @Date 16/12/2.
 */
public class Best_Time_to_Buy_and_Sell_Stock_II_122 {

    /**
     * dp
     * <p/>
     * sell before buy & buy before sell?
     * <p/>
     * 局部最优=全局最优???
     */
    public int maxProfit(int[] prices) {
        int sell = 0, prev_buy, buy = Integer.MIN_VALUE;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(sell - price, prev_buy);
            sell = Math.max(prev_buy + price, sell);
        }
        return sell;
    }

    /**
     * simple greedy
     */
    public int maxProfit1(int[] prices) {
        int total = 0;
        for (int i=0; i< prices.length-1; i++) {
            if (prices[i+1]>prices[i]) total += prices[i+1]-prices[i];
        }

        return total;
    }

    public static void main(String[] args) {
        int[] p = {2, 1, 2, 0, 1};
        System.out.println(new Best_Time_to_Buy_and_Sell_Stock_II_122().maxProfit(p));
    }
}
