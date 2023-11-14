package org.example.hot100.binaryTree;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/14 16:03
 */
public class MaxPathSum {

    private int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        MaxPathSum maxPathSum = new MaxPathSum();
        int i = maxPathSum.maxPathSum(new TreeNode(
                1,
                new TreeNode(
                        2
                ),
                new TreeNode(
                        3
                )
        ));
        System.out.println(i);
    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left < 0) {
            left = 0;
        }
        if (right < 0) {
            right = 0;
        }
        int sum = left + right + root.val;
        if (sum > max) {
            max = sum;
        }
        return Math.max(left, right) + root.val;
    }

}
