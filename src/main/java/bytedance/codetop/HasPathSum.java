package bytedance.codetop;

import org.example.hot100.binaryTree.TreeNode;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/30 08:30
 */
public class HasPathSum {

    public static void main(String[] args) {
        HasPathSum hasPathSum = new HasPathSum();
        hasPathSum.hasPathSum(new TreeNode(1, new TreeNode(2, null, null), null), 0);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum);
    }

    private boolean dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.val == targetSum && root.left == null && root.right == null) {
            return true;
        }
        return dfs(root.left, targetSum - root.val) || dfs(root.right, targetSum - root.val);
    }

}
