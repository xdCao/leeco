package bytedance.codetop;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/12/3 09:36
 */
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = 1;
        for (int i = 0; i < nums.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    int tmp = dp[j] + 1;
                    max = Math.max(tmp, max);
                }
            }
            dp[i] = max;
            result = Math.max(max, result);
        }
        return result;
    }

}
