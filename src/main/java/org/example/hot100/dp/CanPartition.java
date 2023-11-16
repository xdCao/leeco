package org.example.hot100.dp;

import java.util.Arrays;

/**
 * 416. 分割等和子集  0-1背包
 * @author buku.ch
 * @Desc
 * @date 2023/11/16 11:14
 */
public class CanPartition {

    public static void main(String[] args) {
        CanPartition canPartition = new CanPartition();
        boolean b = canPartition.canPartition(new int[]{1, 5, 11, 5});
        System.out.println(b);
    }

    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total % 2 == 1) {
            return false;
        }
        int target = total / 2;
        int[][] dp = new int[nums.length][target + 1];
        for (int i = 0; i <= target; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= target ; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - nums[i]] + nums[i]);
                }
            }
        }
        return dp[nums.length - 1][target] == target;
    }

}
