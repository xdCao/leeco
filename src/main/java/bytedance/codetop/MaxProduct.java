package bytedance.codetop;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/30 22:09
 */
public class MaxProduct {

    public int maxProduct(int[] nums) {
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = Math.max(Math.max(nums[i] * dpMax[i - 1], nums[i]), nums[i] * dpMin[i - 1]);
            dpMin[i] = Math.min(Math.min(nums[i], nums[i] * dpMin[i - 1]), dpMax[i - 1] * nums[i]);
        }
        int max = dpMax[0];
        for (int i = 0; i < dpMax.length; i++) {
            max = Math.max(max, dpMax[i]);
        }
        return max;
    }

}
