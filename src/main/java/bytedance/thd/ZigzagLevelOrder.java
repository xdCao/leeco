package bytedance.thd;

import org.example.hot100.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/26 14:44
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelCnt = 1;
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    continue;
                }
                levelList.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            if (levelCnt % 2 == 0) {
                // reverse
                levelList = reverse(levelList);
            }
            result.add(levelList);
            levelCnt++;
        }
        return result;
    }

    private List<Integer> reverse(List<Integer> levelList) {
        List<Integer> res = new ArrayList<>();
        for (int i = levelList.size() - 1; i >= 0; i--) {
            res.add(levelList.get(i));
        }
        return res;
    }

}
