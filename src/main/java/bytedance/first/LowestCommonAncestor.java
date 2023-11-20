package bytedance.first;

import org.example.hot100.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/17 09:42
 */
public class LowestCommonAncestor {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            // 两边各找到一个
            return root;
        }
        if (left != null) {
            // 只在左边找到，并且先找到的肯定是祖先
            return left;
        }
        return right;
    }


    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new ArrayList<>();
        dfs(root, p, path1);

        List<TreeNode> path2 = new ArrayList<>();
        dfs(root, q, path2);

        TreeNode res = root;
        for (int i = 0; i < Math.min(path1.size(), path2.size()); i++) {
            if (path1.get(i) == path2.get(i)) {
                res = path1.get(i);
                continue;
            }
            break;
        }
        return res;
    }

    private boolean dfs(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root == target) {
            return true;
        }
        boolean left = dfs(root.left, target, path);
        if (left) {
            return true;
        }
        boolean right = dfs(root.right, target, path);
        if (right) {
            return true;
        }
        path.remove(root);
        return false;
    }


}
