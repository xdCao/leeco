package bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/19 11:02
 */
public class TreeToDoublyList {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        List<Node> nodes = new ArrayList<>();
        dfs(root, nodes);
        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            if (i == 0) {
                node.left = nodes.get(nodes.size() - 1);
            } else {
                node.left = nodes.get(i - 1);
            }
            if (i == nodes.size() - 1) {
                node.right = nodes.get(0);
            } else {
                node.right = nodes.get(i + 1);
            }
        }
        return nodes.get(0);
    }

    private void dfs(Node root, List<Node> nodes) {
        if (root == null) {
            return;
        }
        dfs(root.left, nodes);
        nodes.add(root);
        dfs(root.right, nodes);
    }

}
