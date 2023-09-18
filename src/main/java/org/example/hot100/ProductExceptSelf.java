package org.example.hot100;

/**
 * 除自身以外数组的乘积
 * https://leetcode.cn/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-100-liked
 * @author buku.ch
 * @Desc
 * @date 2023/9/18 13:35
 */
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        if (nums == null) {
            return null;
        }
        if (nums.length == 1) {
            return new int[]{nums[0]};
        }
        if (nums.length == 2) {
            return new int[]{nums[1], nums[0]};
        }
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        // 先填充左边的元素乘积
        leftProduct[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            leftProduct[i] = nums[i - 1] * leftProduct[i - 1];
        }

        // 再填充右边元素的乘积
        rightProduct[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            rightProduct[i] = rightProduct[i + 1] * nums[i + 1];
        }

        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            answer[i] = leftProduct[i] * rightProduct[i];
        }
        return answer;
    }

}
