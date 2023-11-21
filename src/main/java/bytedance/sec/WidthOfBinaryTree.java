package bytedance.sec;

import jdk.internal.util.xml.impl.Pair;
import org.example.hot100.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/21 15:31
 */
public class WidthOfBinaryTree {

    class Pair {

        TreeNode node;
        Integer index;

        public Pair(TreeNode node, Integer index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 1));
        int max = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int beginIdx = 0;
            int endIdx = 0;
            for (int i = 0; i < size; i++) {
                Pair poll = queue.poll();
                if (i == 0) {
                    beginIdx = poll.index;
                }
                if (i == size - 1) {
                    endIdx = poll.index;
                }
                if (poll.node.left != null) {
                    queue.add(new Pair(poll.node.left, poll.index * 2));
                }
                if (poll.node.right != null) {
                    queue.add(new Pair(poll.node.right, poll.index * 2 + 1));
                }
            }
            max = Math.max(max, endIdx - beginIdx + 1);
        }
        return max;
    }

}
