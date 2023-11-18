package org.example.hot100.binaryTree;

import java.util.*;

/**
 * 236. 二叉树的最近公共祖先
 * @author buku.ch
 * @Desc
 * @date 2023/11/14 14:11
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(1);
        root.right = left;
        left.right = right;

        TreeNode res = lowestCommonAncestor.lowestCommonAncestor(root, left, right);
        System.out.println(res.val);
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       List<TreeNode> path1 = new ArrayList<>();
       List<TreeNode> path2 = new ArrayList<>();
       dfs(root, p, path1);
       dfs(root, q, path2);
       TreeNode cur = null;
        for (int i = 0; i < Math.min(path1.size(), path2.size()); i++) {
            if (path1.get(i) == path2.get(i)) {
                cur = path1.get(i);
            }
        }
        return cur;
    }

    private boolean dfs(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root == target) {
            return true;
        }
        if (dfs(root.left, target, path)) {
            return true;
        }
        if (dfs(root.right, target, path)) {
            return true;
        }
        path.remove(root);
        return false;
    }


}
