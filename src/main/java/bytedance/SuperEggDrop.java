package bytedance;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/19 20:42
 */
public class SuperEggDrop {

    public static void main(String[] args) {
        int i = superEggDrop(10, 10000);
        System.out.println(i);
    }

    public static int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            dp[1][i] = i;
        }
        for (int i = 1; i < k + 1; i++) {
            dp[i][1] = 1;
        }
        for (int i = 2; i < k + 1; i++) {
            for (int j = 2; j < n + 1; j++) {
                int min = Integer.MAX_VALUE;
                for (int l = 1; l <= j; l++) {
                    min = Math.min(min, Math.max(dp[i - 1][l - 1], dp[i][j - l]) + 1);
                }
                dp[i][j] = min;
            }
        }
        return dp[k][n];
    }

}
