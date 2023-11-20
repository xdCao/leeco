package bytedance.sec;

import org.example.hot100.binaryTree.TreeNode;
import org.example.hot100.listNode.ListNode;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/20 14:22
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(1);
        root.right = left;
        left.right = right;

        TreeNode res = lowestCommonAncestor(root, left, right);
        System.out.println(res.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        dfs(path1, root, p);
        dfs(path2, root, q);
        TreeNode parent = root;
        for (int i = 0; i < Math.min(path1.size(), path2.size()); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
            parent = path1.get(i);
        }
        return parent;
    }

    private static boolean dfs(List<TreeNode> path, TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root == p) {
            return true;
        }
        if (dfs(path, root.left, p)) {
            return true;
        }
        if (dfs(path, root.right, p)) {
            return true;
        }
        path.remove(root);
        return false;
    }

}
