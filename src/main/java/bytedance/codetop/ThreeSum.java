package bytedance.codetop;

import java.util.*;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/12/3 16:17
 */
public class ThreeSum {

    public static void main(String[] args) {
        threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Set<String> used = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int begin = i + 1;
            int end = nums.length - 1;
            while (begin < end) {
                int tmp = nums[begin] + nums[end];
                if (tmp < -nums[i]) {
                    begin++;
                } else if (tmp > -nums[i]) {
                    end--;
                } else {
                    String key = nums[i] + " " + nums[begin] + " " + nums[end];
                    if (!used.contains(key)) {
                        List<Integer> single = new ArrayList<>();
                        single.add(nums[i]);
                        single.add(nums[begin]);
                        single.add(nums[end]);
                        result.add(single);
                        used.add(key);
                    }
                    begin++;
                }
            }
        }
        return result;
    }

}
