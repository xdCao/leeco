package bytedance.first;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/19 16:46
 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> single = new ArrayList<>();
            visited.add(i);
            single.add(nums[i]);
            backTrack(nums, single, res, visited);
            visited.remove(i);
        }
        return res;
    }

    private void backTrack(int[] nums, List<Integer> single, List<List<Integer>> res, Set<Integer> visited) {
        if (single.size() == nums.length) {
            res.add(single);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited.contains(i)) {
                continue;
            }
            List<Integer> tmp = new ArrayList<>(single);
            tmp.add(nums[i]);
            visited.add(i);
            backTrack(nums, tmp, res, visited);
            visited.remove(i);
        }
    }

}
