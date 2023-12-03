package bytedance.codetop;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/12/3 15:24
 */
public class Jump {

    public static void main(String[] args) {
        int jump = jump(new int[]{2, 3, 1, 1, 4});
        System.out.println(jump);
    }

    public static int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    min = Math.min(dp[j], min);
                }
            }
            dp[i] = min + 1;
        }
        return dp[nums.length - 1];
    }

}
