package org.example.hot100.math;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/2 08:07
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int res = nums[0];
        for(int i = 1;i < nums.length;i++) {
            res = res ^ nums[i];
        }
        return res;
    }

}
