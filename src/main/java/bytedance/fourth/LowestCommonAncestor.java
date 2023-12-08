package bytedance.fourth;

import org.example.hot100.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/12/5 17:31
 */
public class LowestCommonAncestor {

//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null || root == p || root == q) {
//            return root;
//        }
//        TreeNode left = lowestCommonAncestor(root.left, p, q);
//        TreeNode right = lowestCommonAncestor(root.right, p, q);
//        if (left == null && right == null) {
//            return null;
//        }
//        if (left == null) {
//            return right;
//        }
//        if (right == null) {
//            return left;
//        }
//        return root;
//    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2= new ArrayList<>();
        dfs(root, path1, p);
        dfs(root, path2, q);
        TreeNode res = root;
        for (int i = 0; i < Math.min(path1.size(), path2.size()); i++) {
            if (path1.get(i) == path2.get(i)) {
                res = path1.get(i);
            }
        }
        return res;

    }

    private boolean dfs(TreeNode root, List<TreeNode> path, TreeNode p) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root == p) {
            return true;
        }
        if (root.left != null) {
            boolean left = dfs(root.left, path, p);
            if (!left) {
                path.remove(path.size() - 1);
            } else {
                return left;
            }
        }
        if (root.right != null) {
            boolean right = dfs(root.right, path, p);
            if (!right) {
                path.remove(path.size() - 1);
            }else {
                return right;
            }
        }
        return false;

    }

}
