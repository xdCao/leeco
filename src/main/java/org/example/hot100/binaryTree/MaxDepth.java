package org.example.hot100.binaryTree;

/**
 * 104. 二叉树的最大深度
 * @author buku.ch
 * @Desc
 * @date 2023/11/12 21:14
 */
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        int cnt = 0;
        if (root == null) {
            return cnt;
        }
        int leftCnt = 0;
        int rightCnt = 0;
        if (root.left != null) {
            leftCnt = maxDepth(root.left);
        }
        if (root.right != null) {
            rightCnt = maxDepth(root.right);
        }
        return Math.max(leftCnt, rightCnt) + 1;
    }

}
