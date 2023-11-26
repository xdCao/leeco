package bytedance.thd;

import java.util.ArrayList;
import java.util.List;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/26 21:07
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
    }

    public Node treeToDoublyList(Node root) {
        List<Node> list = new ArrayList<>();
        if (root == null) {
            return null;
        }
        dfs(root, list);
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                list.get(i).left = list.get(list.size() - 1);
            } else {
                list.get(i).left = list.get(i - 1);
            }
            if (i == list.size() - 1) {
                list.get(i).right = list.get(0);
            } else {
                list.get(i).right = list.get(i + 1);
            }
        }
        return list.get(0);
    }

    private void dfs(Node root, List<Node> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root);
        dfs(root.right, list);
    }

}
