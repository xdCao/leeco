package org.example.hot100.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * 199. 二叉树的右视图
 * @author buku.ch
 * @Desc
 * @date 2023/11/13 21:51
 */
public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode poll = queue.poll();
                if (poll != null) {
                    tmp.add(poll.val);
                    if (poll.left != null) {
                        queue.add(poll.left);
                    }
                    if (poll.right != null) {
                        queue.add(poll.right);
                    }
                }
            }
            if (!tmp.isEmpty()) {
                levels.add(tmp);
            }
        }
        return levels.stream().map(level -> level.get(level.size() - 1)).collect(Collectors.toList());
    }

}
