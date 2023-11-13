package org.example.hot100.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 98. 验证二叉搜索树
 * @author buku.ch
 * @Desc
 * @date 2023/11/13 21:43
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        for (int i = 1; i < res.size(); i++) {
            if (res.get(i) <= res.get(i -1)) {
                return false;
            }
        }
        return true;
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
