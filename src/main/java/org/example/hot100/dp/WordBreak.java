package org.example.hot100.dp;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/15 22:39
 */
public class WordBreak {

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        boolean b = wordBreak.wordBreak("aaaaaaa", Lists.newArrayList("aaaa", "aaa"));
        System.out.println(b);
    }

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
