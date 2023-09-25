package org.example.hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 41. 缺失的第一个正数
 * https://leetcode.cn/problems/first-missing-positive/description/?envType=study-plan-v2&envId=top-100-liked
 * @author buku.ch
 * @Desc
 * @date 2023/9/25 08:02
 */
public class FirstMissingPositive {

    public static void main(String[] args) {
        firstMissingPositive(new int[]{1, 2, 0});
    }

    public static int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>(5 * 100000);
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }
        int cur = 1;
        while (true) {
            if (set.contains(cur)) {
                cur++;
                continue;
            }
            break;
        }
        return cur;
    }

}
