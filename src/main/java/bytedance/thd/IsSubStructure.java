package bytedance.thd;

import org.example.hot100.binaryTree.TreeNode;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/25 10:03
 */
public class IsSubStructure {

    public static void main(String[] args) {
        IsSubStructure isSubStructure = new IsSubStructure();
        isSubStructure.isSubStructure(new TreeNode(
                        4,
                        new TreeNode(
                                2,
                                new TreeNode(
                                        4,
                                        new TreeNode(8),
                                        new TreeNode(9)
                                ),
                                null
                        ),
                        null
                ),
                new TreeNode(
                        4,
                        new TreeNode(8),
                        new TreeNode(9)
                )
        );
    }

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
        boolean res = check(a, b);
        if (res) {
            return true;
        }
        return dfs(a.left, b) || dfs(a.right, b);
    }

    private boolean check(TreeNode a, TreeNode b) {
        if (a == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        boolean res = true;
        if (b.left != null) {
            res &= check(a.left, b.left);
        }
        if (b.right != null) {
            res &= check(a.right, b.right);
        }
        return res;
    }

}
