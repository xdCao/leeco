package bytedance.thd;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/26 14:54
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
            }
        }
        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (dp[i][j]) {
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                }
            }
        }
        int maxLen = 0;
        int begin = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (dp[i][j]) {
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        begin = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(begin, end + 1);
    }

}
