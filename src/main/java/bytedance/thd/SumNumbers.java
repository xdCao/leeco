package bytedance.thd;

import org.example.hot100.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/27 11:03
 */
public class SumNumbers {

    public int sumNumbers(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        dfs(root, res, tmp);
        int sum = 0;
        for (List<Integer> re : res) {
            sum += getSum(re);
        }
        return sum;

    }

    private int getSum(List<Integer> re) {
        int sum = 0;
        for (int i = re.size() - 1; i >= 0; i--) {
            sum += re.get(i) * Math.pow(10, re.size() - 1 - i);
        }
        return sum;
    }

    private void dfs(TreeNode root, List<List<Integer>> res, List<Integer> input) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            List<Integer> tmp = new ArrayList<>(input);
            tmp.add(root.val);
            res.add(tmp);
            return;
        }
        input.add(root.val);
        dfs(root.left, res, input);
        dfs(root.right, res, input);
        input.remove(input.size() - 1);
    }

}
