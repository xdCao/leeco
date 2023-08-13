package org.example.hot100;

import java.util.Arrays;

public class MaxWater {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,5,25,24,5};
        System.out.println(maxArea(arr));
    }

    public static int maxArea(int[] height) {
        if (height == null || height.length == 1) {
            return 0;
        }
        int maxArea = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }


}
