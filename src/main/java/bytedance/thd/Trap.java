package bytedance.thd;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/26 21:13
 */
public class Trap {

    public int trap(int[] height) {

        int[] leftMax = new int[height.length];
        leftMax[0] = 0;
        int[] rightMax = new int[height.length];
        rightMax[height.length - 1] = 0;

        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }

        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            sum += Math.max(Math.min(leftMax[i], rightMax[i]) - height[i], 0);
        }
        return sum;
    }

}
