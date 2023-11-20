package bytedance;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/19 17:15
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        // dp含义：到第i天为止可能卖出的最大获利
        int[] dp = new  int[prices.length];
        dp[0] = 0;
        int minCost = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minCost = Math.min(minCost, prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i] - minCost);
        }
        int max = 0;
        for (int i : dp) {
            max = Math.max(i, max);
        }
        return max;
    }

}
