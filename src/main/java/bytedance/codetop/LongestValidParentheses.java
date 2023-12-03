package bytedance.codetop;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/12/3 19:15
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        longestValidParentheses("(()())");
    }

    public static int longestValidParentheses(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 0;
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
                dp[i] = dp[i - 1] + 2;
                if (i >= 2) {
                    dp[i] = Math.max(dp[i], dp[i - 2] + 2);
                }
            }
            if (s.charAt(i) == ')' && s.charAt(i - 1) == ')') {
                int lastMatchIdx = i - dp[i - 1] - 1;
                if (lastMatchIdx >= 0 && s.charAt(lastMatchIdx) == '(') {
                    if (lastMatchIdx == 0) {
                        dp[i] = dp[i - 1] + 2;
                    } else {
                        dp[i] = dp[lastMatchIdx - 1] + dp[i - 1] + 2;
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
