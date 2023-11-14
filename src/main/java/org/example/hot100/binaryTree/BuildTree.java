package org.example.hot100.binaryTree;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * @author buku.ch
 * @Desc
 * @date 2023/11/13 22:20
 */
public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return buildTree(preorder, inorder, 0, n-1, 0, n-1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = findRoot(inorder, preorder[preStart]);

        int leftSize = rootIndex - inStart;
        root.left = buildTree(preorder, inorder, preStart + 1, preStart + leftSize, inStart, rootIndex -1);
        root.right = buildTree(preorder, inorder, preStart + leftSize + 1, preEnd, rootIndex + 1, inEnd);
        return root;
    }

    private int findRoot(int[] inorder, int target) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }
        return -1;
    }

}
