package bytedance.fourth;

import java.util.ArrayList;
import java.util.List;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/12/7 10:00
 */
public class MaxLessN {

    public static void main(String[] args) {
        MaxLessN maxLessThanN = new MaxLessN();
        maxLessThanN.maxLessN(new int[]{1, 2, 9, 4}, 2533);
        maxLessThanN.maxLessN(new int[]{1, 2, 5, 4}, 2543);
        maxLessThanN.maxLessN(new int[]{1, 2, 5, 4}, 2541);
        maxLessThanN.maxLessN(new int[]{1, 2, 9, 4}, 2111);
        maxLessThanN.maxLessN(new int[]{5, 9}, 5555);
    }

    public int maxLessN(int[] nums, int target) {
        int cnt = 0;
        int tmp = 1;
        while (tmp < target) {
            tmp = tmp * 10;
            cnt++;
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> single = new ArrayList<>();
            single.add(nums[i]);
            backTrack(single, result, nums, cnt);
        }
        int max = 0;
        for (List<Integer> list : result) {
            int sum = getSum(list);
            if (sum < target) {
                max = Math.max(max, sum);
            }
        }
        System.out.println(max);
        return max;
    }

    private void backTrack(List<Integer> single, List<List<Integer>> result, int[] nums, int cnt) {
        if (single.size() > cnt) {
            return;
        }
        if (single.size() == cnt || single.size() == cnt - 1) {
            result.add(single);
        }
        for (int i = 0; i < nums.length; i++) {
            List<Integer> tmp = new ArrayList<>(single);
            tmp.add(nums[i]);
            backTrack(tmp, result, nums, cnt);
        }
    }

    private int getSum(List<Integer> list) {
        int sum = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            sum += list.get(i) * Math.pow(10, list.size() - 1 - i);
        }
        return sum;
    }

}
