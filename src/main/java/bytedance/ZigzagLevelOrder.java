package bytedance;

import org.example.hot100.binaryTree.TreeNode;

import java.util.*;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/18 22:15
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        while (!queue.isEmpty()) {
            List<Integer> single = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    continue;
                }
                queue.add(poll.left);
                queue.add(poll.right);
                single.add(poll.val);
            }
            if (level % 2 == 0) {
                List<Integer> tmp = new ArrayList<>();
                for (int i = single.size() - 1; i >= 0; i--) {
                    tmp.add(single.get(i));
                }
                single = tmp;
            }
            if (!single.isEmpty()) {
                res.add(single);
            }
            level++;
        }
        return res;
    }

}
