package org.example.hot100.dp;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/1 07:36
 */
public class LengthOfLIS {

    public static void main(String[] args) {
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        int i = lengthOfLIS.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3});
        System.out.println(i);
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                } else {
                    dp[i] = Math.max(dp[i], 1);
                }
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

}
