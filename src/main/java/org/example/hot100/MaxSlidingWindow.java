package org.example.hot100;

import java.util.*;

/**
 * 239. 滑动窗口最大值
 * 重点题目
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k == 0 || k > nums.length) {
            return new int[]{};
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<Integer>();

        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(nums[i]);
        }
        res[0] = queue.peekFirst();
        for (int i = k; i < nums.length; i++) {
            if (queue.peekFirst() == nums[i - k]) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(nums[i]);
            res[i - k + 1] = queue.peekFirst();
        }
        return res;
    }

}
