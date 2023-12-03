package bytedance.codetop;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/12/3 15:57
 */
public class CanJump {

    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[nums.length - 1];
    }

}
