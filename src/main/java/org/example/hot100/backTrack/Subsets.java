package org.example.hot100.backTrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 78. 子集
 * @author buku.ch
 * @Desc
 * @date 2023/11/16 14:17
 */
public class Subsets {

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        List<List<Integer>> subsets1 = subsets.subsets(new int[]{1, 2, 3});
        System.out.println(subsets1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            List<Integer> single = new ArrayList<>();
            single.add(nums[i]);
            backTrack(res, single, nums, i);
        }
        return res;
    }

    private void backTrack(List<List<Integer>> res, List<Integer> single, int[] nums, int i) {
        if (i >= nums.length) {
            return;
        }
        res.add(single);
        for (int j = i + 1; j < nums.length; j++) {
            List<Integer> tmp = new ArrayList<>(single);
            tmp.add(nums[j]);
            backTrack(res, tmp, nums, j);
        }
    }


}
