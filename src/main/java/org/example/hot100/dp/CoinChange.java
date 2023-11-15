package org.example.hot100.dp;

/**
 * 322. 零钱兑换
 * @author buku.ch
 * @Desc
 * @date 2023/11/15 20:58
 */
public class CoinChange {

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int i = coinChange.coinChange(new int[]{1,2}, 2);
        System.out.println(i);
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = -1;
        }
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                dp[coins[i]] = 1;
            }
        }
        for (int i = 0; i <= amount; i++) {
            if (dp[i] == 1) {
                continue;
            }
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] > 0) {
                    min = Math.min(min, dp[i - coins[j]]);
                }
            }
            if (min != Integer.MAX_VALUE) {
                dp[i] = min + 1;
            }
        }
        return dp[amount];
    }

}
