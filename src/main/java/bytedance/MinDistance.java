package bytedance;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/19 21:53
 */
public class MinDistance {

    public static void main(String[] args) {
        int i = minDistance("intention", "execution");
        System.out.println(i);
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int lastCorner = dp[i - 1][j - 1];
                int up = dp[i - 1][j] + 1;
                int left = dp[i][j - 1] + 1;
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    lastCorner++;
                }
                dp[i][j] = Math.min(lastCorner, Math.min(left, up));
            }
        }
        return dp[m][n];
    }

}
