package org.example.hot100.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/13 07:57
 */
public class IsSymmetric {

    public static void main(String[] args) {
        IsSymmetric isSymmetric = new IsSymmetric();
        isSymmetric.isSymmetric(new TreeNode(
                1,
                new TreeNode(
                        2,
                        new TreeNode(2, null, null),
                        null
                ),
                new TreeNode(
                        2,
                        new TreeNode(2, null, null),
                        null
                )
        ));

    }

    public boolean isSymmetric(TreeNode root) {
        List<Integer> left = new ArrayList<>();
        leftIter(root, left);
        List<Integer> right = new ArrayList<>();
        rightIter(root, right);
        for (int i = 0; i < left.size(); i++) {
            if (!left.get(i).equals(right.get(i))) {
                return false;
            }
        }
        return true;

    }

    private void rightIter(TreeNode root, List<Integer> right) {
        if (root == null) {
            right.add(101);
            return;
        }
        right.add(root.val);
        rightIter(root.right, right);
        rightIter(root.left, right);

    }

    private void leftIter(TreeNode root, List<Integer> left) {
        if (root == null) {
            left.add(101);
            return;
        }
        left.add(root.val);
        leftIter(root.left, left);
        leftIter(root.right, left);
    }

}
