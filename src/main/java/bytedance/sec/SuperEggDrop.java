package bytedance.sec;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/22 19:43
 */
public class SuperEggDrop {

    public static void main(String[] args) {
        int i = superEggDrop(2, 6);
        System.out.println(i);
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
                    min = Math.min(Math.max(1 + dp[i - 1][l - 1], 1 + dp[i][j - l]), min);
                }
                dp[i][j] = min;
            }
        }
        return dp[k][n];
    }

}
