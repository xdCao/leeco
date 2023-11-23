package bytedance.sec;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/23 11:09
 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(nums[i]);
            visited.add(i);
            backTrack(nums, tmp, res, visited);
            visited.remove(i);
        }
        return res;
    }

    private void backTrack(int[] nums, List<Integer> input, List<List<Integer>> res, Set<Integer> visited) {
        if (input.size() == nums.length) {
            res.add(input);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited.contains(i)) {
                continue;
            }
            List<Integer> tmp = new ArrayList<>(input);
            tmp.add(nums[i]);
            visited.add(i);
            backTrack(nums, tmp, res, visited);
            visited.remove(i);
        }
    }

}
