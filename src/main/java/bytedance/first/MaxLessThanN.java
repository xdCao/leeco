package bytedance.first;

import java.util.ArrayList;
import java.util.List;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/17 10:59
 */
public class MaxLessThanN {

    public static void main(String[] args) {
        MaxLessThanN maxLessThanN = new MaxLessThanN();
        int res = maxLessThanN.count(new int[]{1, 2, 9, 4}, 2533);
        System.out.println(res);
    }

    private int count(int[] nums, int target) {
        List<List<Integer>> all = new ArrayList<>();
        int maxLength = String.valueOf(target).length();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> single = new ArrayList<>();
            single.add(nums[i]);
            backTrack(single, maxLength, all, nums);
        }
        int max = 0;
        for (List<Integer> list : all) {
            int sum = sumList(list);
            if (sum < target) {
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    private int sumList(List<Integer> list) {
        int size = list.size();
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += Math.pow(10, size - 1 - i) * list.get(i);
        }
        return sum;
    }

    private void backTrack(List<Integer> single, int maxLength, List<List<Integer>> all, int[] nums) {
        if (single.size() > maxLength) {
            return;
        }
        all.add(single);
        for (int num : nums) {
            List<Integer> tmp = new ArrayList<>(single);
            tmp.add(num);
            backTrack(tmp, maxLength, all, nums);
        }
    }

}
