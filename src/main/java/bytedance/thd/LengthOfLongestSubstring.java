package bytedance.thd;

import java.util.HashMap;
import java.util.Map;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/25 11:25
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        int i = lengthOfLongestSubstring("abba");
        System.out.println(i);
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int beginIdx = 0;
        int endIdx = 0;
        while (endIdx < charArray.length) {
            if (!map.containsKey(charArray[endIdx]) || map.get(charArray[endIdx]) < beginIdx) {
                map.put(charArray[endIdx], endIdx);
                maxLen = Math.max(maxLen, endIdx - beginIdx + 1);
                endIdx++;
                continue;
            }
            beginIdx = map.get(charArray[endIdx]) + 1;
            map.remove(charArray[endIdx]);
        }
        return maxLen;
    }

}
