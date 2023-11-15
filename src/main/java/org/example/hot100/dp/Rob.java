package org.example.hot100.dp;

/**
 *198. 打家劫舍
 * @author buku.ch
 * @Desc
 * @date 2023/11/15 17:25
 */
public class Rob {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        int maxDp = Math.max(dp[0], dp[1]);
        for (int i = 2; i < nums.length; i++) {
            int tmp = 0;
            for (int j = 0; j < i - 1; j++) {
                if (dp[j] > tmp) {
                    tmp = dp[j];
                }
            }
            dp[i] = tmp + nums[i];
            if (dp[i] > maxDp) {
                maxDp = dp[i];
            }
        }
        return maxDp;
    }

}
