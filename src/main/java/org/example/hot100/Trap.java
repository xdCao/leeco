package org.example.hot100;

/**
 * 接雨水
 */
public class Trap {

    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        int total = 0;
        for (int i = 1; i < height.length - 1; i++) {
            // 求每一列的水
            // 求左边最高的列
            int maxLeft = 0;
            for (int j = 0; j < i; j++) {
                if (height[j] > maxLeft) {
                    maxLeft = height[j];
                }
            }
            // 求右边最高的列
            int maxRight = 0;
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > maxRight) {
                    maxRight = height[j];
                }
            }
            int min = Math.min(maxLeft, maxRight);
            if (min <= height[i]) {
                continue;
            }
            total += min - height[i];
        }
        return total;
    }

}
