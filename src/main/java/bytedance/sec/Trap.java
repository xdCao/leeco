package bytedance.sec;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/22 14:05
 */
public class Trap {

    public int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        maxLeft[0] = 0;
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        maxRight[height.length - 1] = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            sum += Math.max(Math.min(maxLeft[i], maxRight[i]) - height[i], 0);
        }
        return sum;
    }
}
