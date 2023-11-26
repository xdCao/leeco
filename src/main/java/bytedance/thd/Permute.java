package bytedance.thd;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/26 20:36
 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> single = new ArrayList<>();
            single.add(nums[i]);
            visited.add(i);
            backTrack(nums, visited, res, single);
            visited.remove(i);
        }
        return res;
    }

    private void backTrack(int[] nums, Set<Integer> visited, List<List<Integer>> res, List<Integer> single) {
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
            backTrack(nums, visited, res, tmp);
            visited.remove(i);
        }
    }

}
