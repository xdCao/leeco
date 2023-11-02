package org.example.hot100.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 * @author buku.ch
 * @Desc
 * @date 2023/11/2 22:49
 */
public class MajorElement {

    public int majorityElement(int[] nums) {
        int cur = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (cur == nums[i]) {
                cnt++;
                continue;
            }
            cnt--;
            if (cnt == 0) {
                cur = nums[i];
                cnt = 1;
            }
        }
        return cur;
    }

}
