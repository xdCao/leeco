package bytedance.codetop;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/12/2 19:09
 */
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        Set<Integer> cache = new HashSet<>();
        for (int num : nums) {
            cache.add(num);
        }
        int maxLen = 0;
        for (int num : nums) {
            if (cache.contains(num - 1)) {
                continue;
            }
            int tmpLen = 0;
            while (true) {
                if (cache.contains(num)) {
                    tmpLen++;
                    num++;
                } else {
                    break;
                }
            }
            maxLen = Math.max(tmpLen, maxLen);
        }
        return maxLen;
    }

}
