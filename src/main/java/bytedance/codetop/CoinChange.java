package bytedance.codetop;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/12/1 11:03
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int coin : coins) {
            if (coin <= amount) {
                dp[coin] = 1;
            }
        }
        for (int i = 1; i <= amount; i++) {
            if (dp[i] != 0) {
                continue;
            }
            int tmpMin = amount + 1;
            for (int coin : coins) {
                if (i >= coin) {
                    tmpMin = Math.min(dp[i - coin], tmpMin);
                }
            }
            dp[i] = tmpMin + 1;
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
