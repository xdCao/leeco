package org.example.hot100.dp;

/**
 * 279. 完全平方数
 * @author buku.ch
 * @Desc
 * @date 2023/11/15 20:32
 */
public class NumSquares {

    public static void main(String[] args) {
        NumSquares numSquares = new NumSquares();
        int i = numSquares.numSquares(12);
        System.out.println(i);
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(dp[i - j * j], min);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }

}
