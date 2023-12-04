package bytedance.codetop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/12/4 10:12
 */
public class CanFinish {

    public static void main(String[] args) {
        canFinish(2, new int[][]{{1, 0}});
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree =  new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
        }
        Queue<Integer> zeroDegree = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                zeroDegree.add(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (true) {
            Integer poll = zeroDegree.poll();
            if (poll == null) {
                break;
            }
            result.add(poll);
            for (int[] prerequisite : prerequisites) {
                if (poll.equals(prerequisite[1])) {
                    inDegree[prerequisite[0]]--;
                    if (inDegree[prerequisite[0]] == 0) {
                        zeroDegree.add(prerequisite[0]);
                    }
                }
            }
        }
        return result.size() == numCourses;
    }

}
