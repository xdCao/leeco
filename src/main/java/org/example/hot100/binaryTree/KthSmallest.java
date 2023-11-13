package org.example.hot100.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 230. 二叉搜索树中第K小的元素
 * @author buku.ch
 * @Desc
 * @date 2023/11/13 21:47
 */
public class KthSmallest {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res.get(k - 1);
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            dfs(root.left, res);
        }
        res.add(root.val);
        if (root.right != null) {
            dfs(root.right, res);
        }
    }

}
