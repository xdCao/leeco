package bytedance.first;

import org.example.hot100.binaryTree.TreeNode;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/17 16:32
 */
public class IsSubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }
        return dfs(A, B);
    }

    private boolean dfs(TreeNode a, TreeNode b) {
        if (a == null) {
            return false;
        }
        if (a.val == b.val) {
            boolean judge = judge(a, b);
            if (judge) {
                return judge;
            }
        }
        if (dfs(a.left, b)) {
            return true;
        }
        return dfs(a.right, b);
    }

    private boolean judge(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        if (b.left == null) {
            return judge(a.right, b.right);
        }
        if (b.right == null) {
            return judge(a.left, b.left);
        }
        return judge(a.left, b.left) && judge(a.right, b.right);
    }

}
