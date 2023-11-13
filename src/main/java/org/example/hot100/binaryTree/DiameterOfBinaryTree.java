package org.example.hot100.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/13 20:08
 */
public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
        diameterOfBinaryTree.diameterOfBinaryTree(new TreeNode(
                2,
                new TreeNode(
                        3,
                        new TreeNode(1),
                        null
                ),
                null
        ));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        List<Integer> maxDia = new ArrayList<>();
        maxDia.add(0);
        getDia(root, maxDia);
        return maxDia.get(0);
    }

    private void getDia(TreeNode root, List<Integer> maxDiameter) {
        if (root == null) {
            return;
        }
        getDia(root.left, maxDiameter);
        getDia(root.right, maxDiameter);
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (left + right > maxDiameter.get(0)) {
            maxDiameter.set(0, left + right);
        }
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

}
