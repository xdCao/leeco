package bytedance.sec;

import org.example.hot100.binaryTree.TreeNode;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/20 16:10
 */
public class IsSubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null) {
            return false;
        }
        if (A.val == B.val) {
            boolean check = check(A, B);
            if (check) {
                return true;
            }
        }
        if (isSubStructure(A.left, B)) {
            return true;
        }
        return isSubStructure(A.right, B);
    }

    private boolean check(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null) {
            return false;
        }
        if (b == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        boolean left = true;
        if (b.left != null) {
            left = check(a.left, b.left);
        }
        boolean right = true;
        if (b.right != null) {
            right = check(a.right, b.right);
        }
        return left && right;
    }

}
