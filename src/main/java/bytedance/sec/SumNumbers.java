package bytedance.sec;

import org.example.hot100.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/23 10:44
 */
public class SumNumbers {

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, paths, path);
        int sum = 0;
        for (List<Integer> list : paths) {
            sum += getSum(list);
        }
        return sum;
    }

    private int getSum(List<Integer> list) {
        int sum = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            sum += list.get(i) * Math.pow(10, list.size() - 1 - i);
        }
        return sum;
    }

    private void dfs(TreeNode node, List<List<Integer>> paths, List<Integer> path) {
        path.add(node.val);
        if (node.left == null && node.right == null) {
            paths.add(path);
            return;
        }
        if (node.left != null) {
            dfs(node.left, paths, new ArrayList<>(path));
        }
        if (node.right != null) {
            dfs(node.right, paths, new ArrayList<>(path));
        }
    }

}
