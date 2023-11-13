package org.example.hot100.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 114. 二叉树展开为链表
 * @author buku.ch
 * @Desc
 * @date 2023/11/13 21:59
 */
public class Flatten {

    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).left = null;
            if (i != list.size() - 1) {
                list.get(i).right = list.get(i + 1);
            } else {
                list.get(i).right = null;
            }
        }
    }

    private void dfs(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        dfs(root.left, list);
        dfs(root.right, list);
    }

}
