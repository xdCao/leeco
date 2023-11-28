package bytedance.codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.cn/problems/merge-intervals/submissions/
 * @author buku.ch
 * @Desc
 * @date 2023/11/28 14:29
 */
public class Merge {

    public static void main(String[] args) {
        merge(new int[][]{
                {1,3},
                {2, 6},
                {8, 10},
                {15, 18}
        });
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> tmp = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (tmp.isEmpty()) {
                tmp.add(interval);
                continue;
            }
            int[] old = tmp.get(tmp.size() - 1);
            if (interval[0] > old[1]) {
                tmp.add(interval);
                continue;
            }
            old[1] = Math.max(old[1], interval[1]);
            tmp.set(tmp.size() - 1, old);
        }
        int[][] res = new int[tmp.size()][2];
        for (int i = 0; i < tmp.size(); i++) {
            res[i][0] = tmp.get(i)[0];
            res[i][1] = tmp.get(i)[1];
        }
        return res;
    }

}
