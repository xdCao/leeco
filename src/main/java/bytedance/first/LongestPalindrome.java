package bytedance.first;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/18 17:10
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String babad = longestPalindrome.dp("aaaaa");
        System.out.println(babad);
    }

    public String longestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int max = 0;
        String res = null;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int len = j - i + 1;
                if (check(charArray, i, j)) {
                    if (len > max) {
                        res = s.substring(i, j + 1);
                        max = len;
                    }
                }
            }
        }

        return res;
    }

    public String dp(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
            }
            dp[i][i] = true;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (j == i) {
                    continue;
                }
                if (s.charAt(i) == s.charAt(j) && !(dp[i][j])) {
                    dp[i][j] = dp[i + 1][j - 1];
                }
            }
        }
        int maxLen = 0;
        int maxI = 0;
        int maxJ = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (!dp[i][j]) {
                    continue;
                }
                if (j - i + 1 > maxLen) {
                    maxLen = j- i + 1;
                    maxI = i;
                    maxJ = j;
                }
            }
        }
        return s.substring(maxI, maxJ + 1);
    }

    public boolean check(char[] s, int begin, int end) {
        for (int i = begin; i < (begin + end) / 2 + 1; i++) {
            if (s[i] != s[begin + end - i]) {
                return false;
            }
        }
        return true;
    }

}
