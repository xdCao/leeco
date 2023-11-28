package bytedance.codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/28 15:39
 */
public class TriangleNumber {

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int singleCnt = 0;
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] > nums[k]) {
                        singleCnt = Math.max(singleCnt, k - j);
                    }
                }
                cnt += singleCnt;
            }
        }
        return cnt;
    }


}
