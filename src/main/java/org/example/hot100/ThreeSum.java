package org.example.hot100;

import org.checkerframework.checker.units.qual.A;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {

    public static void main(String[] args) {
        threeSum(new int[]{-1,0,1,2,-1,-4});
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> res= new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int first = nums[i];
            if (first > 0) {
                break;
            }
            for (int j = i + 1, k = nums.length - 1; j < k;) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                if (nums[j] + nums[k] > -first) {
                    k--;
                } else if (nums[j] + nums[k] < -first) {
                    j++;
                } else {
                    List<Integer> single = new ArrayList<Integer>();
                    single.add(nums[i]);
                    single.add(nums[j]);
                    single.add(nums[k]);
                    res.add(single);
                    j++;
                }
            }
        }
        return res;
    }

}
