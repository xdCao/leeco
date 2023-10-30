package org.example.hot100;

import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/10/30 22:37
 */
public class Permute {

    public static void main(String[] args) {
        Permute permute = new Permute();
        List<List<Integer>> permute1 = permute.permute(new int[]{1});
        System.out.println(permute1);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        if (nums.length == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            res.add(list);
            return res;
        }

        for (Integer integer : nums) {
            Set<Integer> set = getSet(nums);
            List<List<Integer>> merge = mergeNext(integer, set);
            res.addAll(merge);
        }
        return res;
    }

    private static Set<Integer> getSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set;
    }

    private List<List<Integer>> mergeNext(Integer integer, Set<Integer> set) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> tmp = new HashSet<>(set);
        tmp.remove(integer);
        if (tmp.size() == 0) {
            List<Integer> list = new ArrayList<>();
            list.add(integer);
            res.add(list);
            return res;
        }
        Iterator<Integer> iterator = tmp.iterator();
        while (iterator.hasNext()) {
            List<List<Integer>> merge = mergeNext(iterator.next(), tmp);
            for (List<Integer> nextRes : merge) {
                nextRes.add(integer);
                res.add(nextRes);
            }
        }
        return res;
    }

}
