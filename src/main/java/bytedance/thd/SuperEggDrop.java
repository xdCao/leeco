package bytedance.thd;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/26 19:46
 */
public class SuperEggDrop {

    public static void main(String[] args) {
        superEggDrop(2, 6);
    }

    public static int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[1][i] = i;
        }
        for (int i = 1; i <= k; i++) {
            dp[i][1] = 1;
        }
        for (int i = 2; i <= k; i++) {
            for (int j = 2; j <= n; j++) {
                int min = Integer.MAX_VALUE;
                for (int l = 1; l <= j; l++) {
                    int tmp = Math.max(dp[i - 1][l - 1], dp[i][j - l]) + 1;
                    min = Math.min(min, tmp);
                }
                dp[i][j] = min;
            }
        }
        return dp[k][n];
    }

}
