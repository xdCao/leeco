package bytedance.sec;


import java.util.ArrayList;
import java.util.List;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/22 15:53
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
        List<Node> list = new ArrayList<>();
        if (root == null) {
            return null;
        }
        dfs(root, list);
        if (list.size() == 1) {
            root.left = root;
            root.right = root;
            return root;
        }

        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            if (i == 0) {
                node.left = list.get(list.size() - 1);
                node.right = list.get(i + 1);
            } else if (i == list.size() - 1) {
                node.left = list.get(i - 1);
                node.right = list.get(0);
            } else {
                node.left = list.get(i - 1);
                node.right = list.get(i + 1);
            }
        }
        return list.get(0);
    }

    private void dfs(Node node, List<Node> list) {
        if (node == null) {
            return;
        }
        dfs(node.left, list);
        list.add(node);
        dfs(node.right, list);
    }

}
