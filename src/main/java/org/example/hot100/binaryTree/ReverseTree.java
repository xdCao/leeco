package org.example.hot100.binaryTree;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/12 21:17
 */
public class ReverseTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            invertTree(root.left);
        }
        if (root.right != null) {
            invertTree(root.right);
        }
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        return root;
    }

}
