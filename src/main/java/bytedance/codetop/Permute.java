package bytedance.codetop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/12/2 18:48
 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> input = new ArrayList<>();
            input.add(nums[i]);
            visited.add(i);
            backTrack(nums, visited, input, result);
            visited.remove(i);
        }
        return result;
    }

    private void backTrack(int[] nums, Set<Integer> visited, List<Integer> input, List<List<Integer>> result) {
        if (input.size() == nums.length) {
            result.add(new ArrayList<>(input));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited.contains(i)) {
                continue;
            }
            input.add(nums[i]);
            visited.add(i);
            backTrack(nums, visited, input, result);
            input.remove(input.size() - 1);
            visited.remove(i);
        }
    }

}
