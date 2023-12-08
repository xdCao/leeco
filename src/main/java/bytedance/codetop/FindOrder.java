package bytedance.codetop;

import java.util.*;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/12/4 10:32
 */
public class FindOrder {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
        }
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (true) {
            Integer poll = queue.poll();
            if (poll == null) {
                break;
            }
            res.add(poll);
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == poll) {
                    inDegree[prerequisite[0]]--;
                    if (inDegree[prerequisite[0]] == 0) {
                        queue.add(prerequisite[0]);
                    }
                }
            }
        }
        if (res.size() != numCourses) {
            return new int[0];
        }
        int[] re = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            re[i] = res.get(i);
        }
        return re;
    }

}
