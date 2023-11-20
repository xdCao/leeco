package bytedance.first;

import java.util.HashMap;
import java.util.Map;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/17 09:19
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        lengthOfLongestSubstring.lengthOfLongestSubstring("abba");
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        int maxLength = 0;
        int begin = 0;
        int cur = 0;
        while (cur < charArray.length && begin <= cur) {
            char curChar = charArray[cur];
            if (map.containsKey(curChar)) {
                maxLength = Math.max(maxLength, cur - begin);
                begin = Math.max(begin, map.get(curChar) + 1);
                map.remove(curChar);
                continue;
            }
            map.put(curChar, cur);
            maxLength = Math.max(maxLength, cur - begin + 1);
            cur++;
        }
        return maxLength;
    }

}
