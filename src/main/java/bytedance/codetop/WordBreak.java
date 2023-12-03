package bytedance.codetop;

import java.util.List;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/12/3 15:42
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String delta = s.substring(j, i);
                if (wordDict.contains(delta) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }



}
