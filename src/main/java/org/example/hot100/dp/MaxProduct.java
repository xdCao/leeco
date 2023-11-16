package org.example.hot100.dp;

/**
 * 152. 乘积最大子数组
 * @author buku.ch
 * @Desc
 * @date 2023/11/16 10:36
 */
public class MaxProduct {

    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();
        int i = maxProduct.maxProduct(new int[]{2, -1, 1, 1});
        System.out.println(i);
    }

    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int max = dpMax[0];
        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = Math.max(dpMax[i - 1] * nums[i], Math.max(nums[i], dpMin[i - 1] * nums[i]));
            dpMin[i] = Math.min(Math.min(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]), nums[i]);
            max = Math.max(dpMax[i], max);
        }
        return max;
    }

}
