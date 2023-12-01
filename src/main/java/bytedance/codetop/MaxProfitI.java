package bytedance.codetop;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/12/1 14:04
 */
public class MaxProfitI {

    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int max = dp[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1] + prices[i] - prices[i - 1], prices[i] - prices[i - 1]);
            max = Math.max(dp[i], max);
        }
        return max;
    }

}
