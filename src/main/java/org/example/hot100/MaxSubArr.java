package org.example.hot100;

/**
 * 最大子序和
 * https://leetcode.cn/problems/maximum-subarray/solutions/228009/zui-da-zi-xu-he-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked
 * @author buku.ch
 * @Desc
 * @date 2023/9/4 23:25
 */
public class MaxSubArr {

    /**
     * 贪心解法
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int max = Integer.MIN_VALUE;
        int curSum = 0;
        // 每次前面的和小于0，就重新计算
        for (int i = 0; i < nums.length; i++) {
            if (curSum < 0) {
                curSum = 0;
            }
            curSum += nums[i];
            if (curSum > max) {
                max = curSum;
            }
        }
        return max;
    }

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // 如果前面的值大于0，加到当前值上
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

}
