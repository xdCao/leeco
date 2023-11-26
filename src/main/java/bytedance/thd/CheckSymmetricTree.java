package bytedance.thd;

import org.example.hot100.binaryTree.TreeNode;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/26 14:49
 */
public class CheckSymmetricTree {

    public boolean checkSymmetricTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return check(left.left, right.right) && check(left.right, right.left);
    }

}
