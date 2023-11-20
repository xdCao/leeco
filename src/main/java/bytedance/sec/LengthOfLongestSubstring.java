package bytedance.sec;

import java.util.HashSet;
import java.util.Set;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/20 14:11
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        int i = lengthOfLongestSubstring("pwwkew");
        System.out.println(i);
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        int begin = 0;
        int end = 0;
        int max = 0;
        Set<Character> visited = new HashSet<>();
        while (begin <= end && end <= charArray.length - 1) {
            if (visited.contains(charArray[end])) {
                visited.remove(charArray[begin]);
                begin++;
            } else {
                visited.add(charArray[end]);
                max = Math.max(end - begin + 1, max);
                end++;
            }
        }
        return max;
    }

}
