package bytedance.thd;

import org.example.hot100.binaryTree.TreeNode;
import org.example.hot100.listNode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/25 10:31
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        dfs(root, p, path1);
        dfs(root, q, path2);
        TreeNode parent = null;
        for (int i = 0; i < Math.min(path1.size(), path2.size()); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
            parent = path1.get(i);
        }
        return parent;
    }

    private boolean dfs(TreeNode root, TreeNode p, List<TreeNode> path) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root.val == p.val) {
            return true;
        }

        if (root.left != null) {
            boolean left = dfs(root.left, p, path);
            if (left) {
                return left;
            } else {
                path.remove(path.size() - 1);
            }
        }
        if (root.right != null) {
            boolean right = dfs(root.right, p, path);
            if (right) {
                return right;
            } else {
                path.remove(path.size() - 1);
            }
        }
        return false;
    }

}
