package bytedance.codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/12/3 08:33
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        lengthOfLongestSubstring("abba");
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = 0;
        while (right <= s.length() - 1) {
            if (!map.containsKey(s.charAt(right)) || map.get(s.charAt(right)) < left) {
                map.put(s.charAt(right), right);
                max = Math.max(right - left + 1, max);
                right++;
                continue;
            }
            left = map.get(s.charAt(right)) + 1;
            map.remove(s.charAt(right));
        }
        return max;
    }

}
