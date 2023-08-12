package org.example.hot100;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,3,12};
        bestSolution(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bestSolution(int[] nums) {
        if (nums == null) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                for (int j = i; j >= index + 1; j--) {
                    int tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                }
                index++;
            }
        }
        for (int i = index + 1; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }
        int i = 0;
        while (true) {
            if (i == nums.length - 1) {
                break;
            }
            if (nums[i] != 0) {
                i++;
                continue;
            }
            int cnt = 0;
            for (int j = i; j < nums.length; j++) {
                cnt += nums[j];
            }
            if (cnt == 0) {
                break;
            }

            // 把当前的0挪到最后
            for (int j = i; j < nums.length - 1; j++) {
                int tmp = nums[j];
                nums[j] = nums[j + 1];
                nums[j + 1] = tmp;
            }
            if (nums[i] != 0) {
                i++;
            }
        }
    }

}
