package org.example.hot100.binaryTree;

import org.checkerframework.checker.units.qual.A;

import java.util.*;

/**
 * 102. 二叉树的层序遍历
 * @author buku.ch
 * @Desc
 * @date 2023/11/13 20:31
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    continue;
                }
                tmp.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            res.add(tmp);

        }
        return res;
    }

}
