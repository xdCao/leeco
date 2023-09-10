package org.example.hot100;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 56. 合并区间
 * https://leetcode.cn/problems/merge-intervals/description/?envType=study-plan-v2&envId=top-100-liked
 * @author buku.ch
 * @Desc
 * @date 2023/9/10 23:46
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= merged.get(merged.size() - 1)[1]) {
                if (intervals[i][1] > merged.get(merged.size() - 1)[1]) {
                    merged.get(merged.size() - 1)[1] = intervals[i][1];
                }
            } else {
                merged.add(intervals[i]);
            }
        }
        return merged.toArray(new int[][]{});
    }

}
