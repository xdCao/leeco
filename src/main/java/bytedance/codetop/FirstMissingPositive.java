package bytedance.codetop;

import java.util.HashSet;
import java.util.Set;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/12/3 16:09
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                hashSet.add(num);
            }
        }
        for (int i = 1; i <= nums.length + 1; i++) {
            if (!hashSet.contains(i)) {
                return i;
            }
        }
        return -1;
    }

}
