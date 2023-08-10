package org.example.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续子序列
 * 参考题解动画
 * https://leetcode.cn/problems/longest-consecutive-sequence/solutions/276931/zui-chang-lian-xu-xu-lie-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked
 */
public class LongestConsecutive {

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        int maxCnt = 1;
        for (Integer target : set) {
            if (set.contains(target - 1)) {
                continue;
            }
            int cnt = 1;
            int next = target + 1;
            while (set.contains(next)) {
                cnt++;
                next++;
            }
            if (cnt > maxCnt) {
                maxCnt = cnt;
            }
        }
        return maxCnt;
    }

}
