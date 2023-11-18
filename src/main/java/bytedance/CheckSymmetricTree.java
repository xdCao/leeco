package bytedance;

import org.example.hot100.binaryTree.TreeNode;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/17 22:42
 */
public class CheckSymmetricTree {

    public boolean checkSymmetricTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return checkSym(root.left, root.right);
    }

    private boolean checkSym(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return checkSym(left.left, right.right) && checkSym(left.right, right.left);
    }

}
