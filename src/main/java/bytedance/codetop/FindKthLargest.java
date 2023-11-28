package bytedance.codetop;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/28 16:25
 */
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        int target = queue.peek();
        for (int i = 0; i < k; i++) {
            target = queue.poll();
        }
        return target;
    }

}
