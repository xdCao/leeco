package bytedance.thd;

import org.example.hot100.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/26 15:38
 */
public class WidthOfBinaryTree {

    class Wrapper {
        int idx;
        TreeNode node;

        public Wrapper(int idx, TreeNode node) {
            this.idx = idx;
            this.node = node;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<Wrapper> queue = new LinkedList<>();
        queue.add(new Wrapper(1, root));
        int max = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int beginIdx = 0;
            int endIdx = 0;
            for (int i = 0; i < size; i++) {
                Wrapper poll = queue.poll();
                if (poll == null) {
                    continue;
                }
                if (i == 0) {
                    beginIdx = poll.idx;
                }
                if (i == size - 1) {
                    endIdx = poll.idx;
                }
                if (poll.node.left != null) {
                    queue.add(new Wrapper(poll.idx * 2, poll.node.left));
                }
                if (poll.node.right != null) {
                    queue.add(new Wrapper(poll.idx * 2 + 1, poll.node.right));
                }
            }
            max = Math.max(max, endIdx - beginIdx + 1);
        }
        return max;
    }


}
