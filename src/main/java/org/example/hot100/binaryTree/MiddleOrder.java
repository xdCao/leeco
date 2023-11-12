package org.example.hot100.binaryTree;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * @author buku.ch
 * @Desc
 * @date 2023/11/12 21:07
 */
public class MiddleOrder {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        if (root.left != null) {
            res.addAll(inorderTraversal(root.left));
        }
        res.add(root.val);
        if (root.right != null) {
            res.addAll(inorderTraversal(root.right));
        }
        return res;
    }

}
