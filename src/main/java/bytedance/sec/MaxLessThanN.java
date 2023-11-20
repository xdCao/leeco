package bytedance.sec;

import java.util.ArrayList;
import java.util.List;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/20 15:06
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

    private int count(int[] nums, int target) {
        int numCnt = 0;
        int tmp = 1;
        while (tmp < target) {
            tmp = tmp * 10;
            numCnt++;
        }
        for (int i = numCnt; i > 0; i--) {
            Integer res = getRes(nums, target, i);
            if (res != null) {
                System.out.println(res);
                return res;
            }
        };
        return 0;
    }

    private Integer getRes(int[] nums, int target, int numCnt) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(nums[i]);
            backTrack(res, tmp, numCnt, target, nums);
        }
        if (!res.isEmpty()) {
            int max = 0;
            for (Integer re : res) {
                max = Math.max(re, max);
            }
            return max;
        }
        return null;
    }

    private void backTrack(List<Integer> res, List<Integer> input, int numCnt, int target, int[] nums) {
        if (input.size() == numCnt) {
            int sum = getSum(input);
            if (sum < target) {
                res.add(sum);
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            List<Integer> tmp = new ArrayList<>(input);
            tmp.add(nums[i]);
            backTrack(res, tmp, numCnt, target, nums);
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
