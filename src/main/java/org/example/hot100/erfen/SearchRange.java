package org.example.hot100.erfen;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * @author buku.ch
 * @Desc
 * @date 2023/11/15 15:01
 */
public class SearchRange {

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        int[] ints = searchRange.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(ints);
    }

    public int[] searchRange(int[] nums, int target) {
        int begin = searchBegin(nums, target, 0, nums.length - 1);
        int end = searchEnd(nums, target, 0, nums.length - 1);
        return new int[]{begin, end};
    }

    private int searchBegin(int[] nums, int target, int begin, int end) {
        if (begin > end) {
            return -1;
        }
        int mid = (begin + end) / 2;
        if (nums[mid] == target) {
            if (mid == 0 || nums[mid - 1] != target) {
                return mid;
            }
        }

        if (nums[mid] >= target) {
            return searchBegin(nums, target, begin, mid - 1);
        }
        return searchBegin(nums, target, mid + 1, end);
    }


    private int searchEnd(int[] nums, int target, int begin, int end) {
        if (begin > end) {
            return -1;
        }
        int mid = (begin + end) / 2;
        if (nums[mid] == target) {
            if (mid == (nums.length - 1) || nums[mid + 1] != target) {
                return mid;
            }
        }

        if (nums[mid] <= target) {
            return searchEnd(nums, target, mid + 1, end);
        }
        return searchEnd(nums, target, begin, mid - 1);
    }
}
