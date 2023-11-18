package bytedance;

import org.example.hot100.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/18 19:19
 */
public class WidthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        root.val = 1;
        int maxLen = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int beginIndex = 0;
            int endIndex = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    continue;
                }
                if (i == 0) {
                    beginIndex = poll.val;
                }
                if (i == size - 1) {
                    endIndex = poll.val;
                }
                if (poll.left != null) {
                    poll.left.val = 2 * poll.val;
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    poll.right.val = 2 * poll.val + 1;
                    queue.add(poll.right);
                }
            }
            int len = endIndex - beginIndex + 1;
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }

}
