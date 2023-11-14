package org.example.hot100.math;

/**
 * 75. 颜色分类
 * @author buku.ch
 * @Desc
 * @date 2023/11/14 21:55
 */
public class SortColors {

    public void sortColors(int[] nums) {
        int ptr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, i, ptr);
                ptr++;
            }
        }
        for (int i = ptr; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, i, ptr);
                ptr++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}
