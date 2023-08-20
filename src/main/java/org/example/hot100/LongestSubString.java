package org.example.hot100;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubString {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] charArray = s.toCharArray();
        int maxCnt = 0;
        for (int i = 0; i < charArray.length; i++) {
            int cnt = 0;
            Set<Character> dupSet = new HashSet<Character>();
            for (int j = i; j < charArray.length; j++) {
                if (!dupSet.contains(charArray[j])) {
                    cnt++;
                    dupSet.add(charArray[j]);
                } else {
                    break;
                }
            }
            if (cnt > maxCnt) {
                maxCnt = cnt;
            }
        }
        return maxCnt;
    }

}
