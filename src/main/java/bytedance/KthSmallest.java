package bytedance;

import org.example.hot100.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/19 00:19
 */
public class KthSmallest {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res, k);
        return res.get(k -1);
    }

    private void dfs(TreeNode root, List<Integer> res, int k) {
        if (root == null) {
            return;
        }
        dfs(root.left, res, k);
        res.add(root.val);
        if (res.size() == k) {
            return;
        }
        dfs(root.right, res, k);
    }

}
