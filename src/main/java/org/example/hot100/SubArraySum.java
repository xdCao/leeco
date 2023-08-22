package org.example.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为 K 的子数组
 * https://leetcode.cn/problems/subarray-sum-equals-k/solutions/238572/he-wei-kde-zi-shu-zu-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked
 * 前缀和+哈希表
 */
public class SubArraySum {

    public static void main(String[] args) {
        subarraySum(new int[]{1, -1, 0}, 0);
    }


    public static int subarraySum(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            if (nums[0] == k) {
                return 1;
            } else {
                return 0;
            }
        }
        int[] preSum = new int[nums.length];
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> preCntMap = new HashMap<Integer, Integer>();
        preCntMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            preSum[i] = sum;
            int target = preSum[i] - k;
            if (preCntMap.containsKey(target)) {
                count += preCntMap.get(target);
            }
            if (preCntMap.containsKey(preSum[i])) {
                preCntMap.put(preSum[i], preCntMap.get(preSum[i]) + 1);
            } else {
                preCntMap.put(preSum[i], 1);
            }
        }
        return count;
    }


}
