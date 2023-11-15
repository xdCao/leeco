package org.example.hot100.erfen;

/**
 * 35. 搜索插入位置
 * @author buku.ch
 * @Desc
 * @date 2023/11/15 14:20
 */
public class SearchInsert {

    public static void main(String[] args) {
        SearchInsert searchInsert = new SearchInsert();
        searchInsert.searchInsert(new int[]{1, 3, 5, 6}, 7);
    }

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return search(nums, 0, nums.length - 1, target);
    }

    public int search(int[] nums, int begin, int end, int target) {
        if (begin >= end) {
            return nums[end] >= target ? end : end + 1;
        }
        int mid = (begin + end) / 2;
        int midNum = nums[mid];
        if (midNum == target) {
            return mid;
        }

        if (midNum < target) {
            if (mid < nums.length -1 && nums[mid + 1] > target) {
                return mid + 1;
            }
            if (mid == end) {
                return mid + 1;
            }
            return search(nums, mid + 1, end, target);
        }
        if (mid >= 1 && nums[mid - 1] < target) {
            return mid;
        }
        if (mid == begin) {
            return mid;
        }
        return search(nums, begin, mid - 1, target);
    }

}
