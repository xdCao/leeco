package bytedance.sec;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/22 18:58
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1] + prices[i] - prices[i - 1], 0);
            max = Math.max(dp[i], max);
        }
        return max;
    }

}
