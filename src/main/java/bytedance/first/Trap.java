package bytedance.first;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/19 11:19
 */
public class Trap {

    public static void main(String[] args) {
        Trap trap = new Trap();
        int trap1 = trap.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(trap1);
    }

    public int dp(int[] height) {
        int[] leftDp = new int[height.length];
        leftDp[0] = 0;
        for (int i = 1; i < height.length; i++) {
            leftDp[i] = Math.max(leftDp[i - 1], height[i - 1]);
        }

        int[] rightDp = new int[height.length];
        rightDp[height.length - 1] = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            rightDp[i] = Math.max(rightDp[i + 1], height[i + 1]);
        }

        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            sum += Math.max(Math.min(leftDp[i], rightDp[i]) - height[i], 0);
        }
        return sum;
    }


    public int trap(int[] height) {
        int maxH = 0;
        for (int i : height) {
            maxH = Math.max(i, maxH);
        }
        int sum = 0;
        for (int i = 1; i <= maxH; i++) {
            // 计算每一层的水
            sum += countLevel(i, height, 0);
        }
        return sum;
    }

    private int countLevel(int level, int[] height, int start) {
        int sum = 0;
        int cur = start;
        if (start >= height.length - 1) {
            return 0;
        }
        int beginIndex = -1;
        int endIndex = -1;
        while (cur < height.length) {
            if (beginIndex >= 0 && endIndex >= 0) {
                break;
            }
            if (height[cur] >= level && beginIndex < 0) {
                beginIndex = cur;
                cur++;
                continue;
            }
            if (height[cur] >= level && endIndex < 0) {
                endIndex = cur;
                cur++;
                continue;
            }
            cur++;
        }
        if (beginIndex >= 0 && endIndex >= 0) {
            sum += endIndex - beginIndex - 1;
            sum += countLevel(level, height, endIndex);
        }
        return sum;
    }

}
