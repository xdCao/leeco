package bytedance.thd;

import org.example.hot100.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/26 21:04
 */
public class KthSmallest {

    public int kthSmallest(TreeNode root, int k) {
        List<TreeNode> res = new ArrayList<>();
        dfs(res, root, k);
        return res.get(k - 1).val;
    }

    private void dfs(List<TreeNode> res, TreeNode root, int k) {
        if (root == null || res.size() == k) {
            return;
        }
        dfs(res, root.left, k);
        res.add(root);
        dfs(res, root.right, k);
    }

}
