package bytedance.sec;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/21 17:48
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        longestPalindrome("babad");
    }

    public static String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                dp[i - 1][i] = true;
            }
        }

        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = s.length() - 1; j > i; j--) {
                if (dp[i][j]) {
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                }
            }
        }
        int max = 0;
        int finalI = 0;
        int finalJ = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (dp[i][j] && j - i + 1 > max) {
                    max = Math.max(max, j - i + 1);
                    finalI = i;
                    finalJ = j;
                }
            }
        }
        return s.substring(finalI, finalJ + 1);
    }

}
