package bytedance.sec;

import org.example.hot100.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/23 09:55
 */
public class KthSmallest {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root, k);
        return res.get(k - 1);
    }

    private void dfs(List<Integer> res, TreeNode root, int k) {
        if (root == null) {
            return;
        }
        if (res.size() == k) {
            return;
        }
        dfs(res, root.left, k);
        res.add(root.val);
        dfs(res, root.right, k);
    }

}
