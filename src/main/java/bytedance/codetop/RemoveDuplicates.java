package bytedance.codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/28 15:10
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        removeDuplicates(new int[]{1, 1, 2});
    }

    public static int removeDuplicates(int[] nums) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, nums[0]);
        int idx = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                cache.put(idx, nums[i]);
                idx++;
            }
        }
        for (int i = 0; i < idx; i++) {
            nums[i] = cache.get(i);
        }
        return idx;
    }

}
