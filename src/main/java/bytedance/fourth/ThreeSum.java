package bytedance.fourth;

import java.util.*;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/12/7 14:17
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Set<String> used = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> single = new ArrayList<>();
            single.add(nums[i]);
            getRest(i + 1, single, -nums[i], result, nums, used);
        }
        return result;
    }

    private void getRest(int begin, List<Integer> single, int target, List<List<Integer>> result, int[] nums, Set<String> used) {
        int left = begin;
        int end = nums.length - 1;
        while (left < end) {
            if (nums[left] + nums[end] == target) {
                List<Integer> tmp = new ArrayList<>(single);
                tmp.add(nums[left]);
                tmp.add(nums[end]);
                String key = tmp.get(0) + "," + tmp.get(1) + "," + tmp.get(2);
                if (!used.contains(key)) {
                    result.add(tmp);
                    used.add(key);
                }
                left++;
                continue;
            }
            if (nums[left] + nums[end] < target) {
                left++;
                continue;
            }
            if (nums[left] + nums[end] > target) {
                end--;
                continue;
            }
        }
    }

}
