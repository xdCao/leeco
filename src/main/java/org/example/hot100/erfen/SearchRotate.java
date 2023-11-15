package org.example.hot100.erfen;

/**
 * 33. 搜索旋转排序数组
 * @author buku.ch
 * @Desc
 * @date 2023/11/15 15:26
 */
public class SearchRotate {

    public int search(int[] nums, int target) {
        int k = searchK(nums,0, nums.length - 1);
        if (nums[nums.length - 1] >= target) {
            return searchTarget(nums, target, k + 1, nums.length);
        } else {
            return searchTarget(nums, target, 0, k);
        }
    }

    private int searchTarget(int[] nums, int target, int begin, int end) {
        if (begin > end) {
            return -1;
        }
        int mid = (begin + end) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] > target) {
            return searchTarget(nums, target, begin, mid - 1);
        }
        return searchTarget(nums, target, mid + 1, end);
    }

    private int searchK(int[] nums, int begin, int end) {
        if (begin > end) {
            return -1;
        }
        int mid = (begin + end) / 2;
        if (mid >= 1 && nums[mid] < nums[mid - 1]) {
            return mid - 1;
        }
        if (nums[mid] > nums[end]) {
            return searchK(nums, mid + 1, end);
        }
        return searchK(nums, begin, mid - 1);

    }

}
