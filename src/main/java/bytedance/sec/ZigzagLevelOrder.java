package bytedance.sec;

import org.apache.commons.collections4.CollectionUtils;
import org.example.hot100.binaryTree.TreeNode;

import java.util.*;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/22 13:43
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelCnt = 1;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    continue;
                }
                level.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            if (levelCnt % 2 == 0) {
                level = reverse(level);
            }
            if (!level.isEmpty()) {
                res.add(level);
            }
            levelCnt++;
        }
        return res;
    }

    private List<Integer> reverse(List<Integer> level) {
        List<Integer> res = new ArrayList<>();
        for (int i = level.size() - 1; i >= 0; i--) {
            res.add(level.get(i));
        }
        return res;
    }

}
