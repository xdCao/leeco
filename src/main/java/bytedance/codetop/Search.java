package bytedance.codetop;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/12/1 11:14
 */
public class Search {

    public static void main(String[] args) {
        Search search = new Search();
        search.search(new int[]{8,9,2,3,4}, -1);
    }

    public int search(int[] nums, int target) {
        int breakIdx = searchBreak(nums, 0, nums.length - 1);
        if (breakIdx < 0) {
            return searchTarget(nums, 0, nums.length - 1, target);
        }
        if (target >= nums[0]) {
            return searchTarget(nums, 0, breakIdx, target);
        } else {
            return searchTarget(nums, breakIdx + 1, nums.length - 1, target);
        }
    }

    private int searchTarget(int[] nums, int begin, int end, int target) {
        if (begin > end || begin < 0 || end > nums.length - 1) {
            return -1;
        }
        int mid = (begin + end) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] > target) {
            return searchTarget(nums, begin, mid - 1, target);
        } else {
            return searchTarget(nums, mid + 1, end, target);
        }
    }

    private int searchBreak(int[] nums, int begin, int end) {
        if (begin > end || begin < 0 || end > nums.length - 1) {
            return -1;
        }
        int mid = (begin + end) / 2;
        if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
            return mid;
        }
        if (nums[mid] >= nums[0]) {
            // 一定在左边
            return searchBreak(nums, mid + 1, end);
        } else {
            return searchBreak(nums, begin, mid - 1);
        }
    }

}
