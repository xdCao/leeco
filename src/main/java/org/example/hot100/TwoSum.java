package org.example.hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
    }


    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueIdxMap = new HashMap();
        int[] res = new int[]{0, 0};
        for(int i = 0; i < nums.length; i++) {
            valueIdxMap.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++) {
            if (valueIdxMap.containsKey(target - nums[i]) && valueIdxMap.get(target - nums[i]) != i) {
                res[0] = i;
                res[1] = valueIdxMap.get(target - nums[i]);
                return res;
            }
        }
        return res;
    }

}
