package org.example.hot100.backTrack;

import java.util.*;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/10/30 22:37
 */
public class Permute {

    public static void main(String[] args) {
        Permute permute = new Permute();
        List<List<Integer>> permute1 = permute.permute2(new int[]{1, 2, 3});
        System.out.println(permute1);
    }

    public List<List<Integer>> permute2(int[] nums) {
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
        Set<Integer> visited = new HashSet<>();
        backTrack(nums, visited, res, new ArrayList<>());
        return res;
    }

    private void backTrack(int[] nums, Set<Integer> visited, List<List<Integer>> res, List<Integer> list) {
        if (list.size() == nums.length) {
            List<Integer> copy = new ArrayList<>();
            copy.addAll(list);
            res.add(copy);
        }
        for (int num : nums) {
            if (visited.contains(num)) {
                continue;
            }
            visited.add(num);
            list.add(num);
            backTrack(nums, visited, res, list);
            visited.remove(num);
            list.removeIf(ele -> ele.equals(num));
        }

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
