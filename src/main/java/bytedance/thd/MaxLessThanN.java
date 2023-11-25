package bytedance.thd;

import java.util.ArrayList;
import java.util.List;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/25 11:38
 */
public class MaxLessThanN {

    public static void main(String[] args) {
        MaxLessThanN maxLessThanN = new MaxLessThanN();
        maxLessThanN.count(new int[]{1, 2, 9, 4}, 2533);
        maxLessThanN.count(new int[]{1, 2, 5, 4}, 2543);
        maxLessThanN.count(new int[]{1, 2, 5, 4}, 2541);
        maxLessThanN.count(new int[]{1, 2, 9, 4}, 2111);
        maxLessThanN.count(new int[]{5, 9}, 5555);
    }

    public int count(int[] nums, int target) {
        int numCnt = 0;
        while (true) {
            if (Math.pow(10, numCnt) > target) {
                break;
            }
            numCnt++;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> single = new ArrayList<>();
            single.add(nums[i]);
            backTrack(res, single, numCnt, nums, target);
        }
        int max = 0;
        for (Integer re : res) {
            max = Math.max(re, max);
        }
        System.out.println(max);
        return max;
    }

    private void backTrack(List<Integer> res, List<Integer> input, int numCnt, int[] nums, int target) {
        if (input.size() > numCnt) {
            return;
        }
        if (input.size() >= numCnt - 1) {
            int sum = getSum(input);
            if (sum < target) {
                res.add(sum);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            input.add(nums[i]);
            backTrack(res, input, numCnt, nums, target);
            input.remove(input.size() - 1);
        }
    }

    private int getSum(List<Integer> input) {
        int sum = 0;
        for (int i = input.size() - 1; i >= 0; i--) {
            sum += input.get(i) * Math.pow(10, input.size() - 1 - i);
        }
        return sum;
    }

}
