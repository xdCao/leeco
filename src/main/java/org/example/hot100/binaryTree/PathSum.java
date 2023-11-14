package org.example.hot100.binaryTree;

import java.util.List;

/**
 * 437. 路径总和 III
 * @author buku.ch
 * @Desc
 * @date 2023/11/14 08:13
 */
public class PathSum {

    public static void main(String[] args) {
        PathSum pathSum = new PathSum();
        int i = pathSum.pathSum(new TreeNode(
                1000000000,
                new TreeNode(
                        1000000000,
                        new TreeNode(
                                294967296,
                                new TreeNode(
                                        1000000000,
                                        new TreeNode(
                                                1000000000,
                                                new TreeNode(
                                                        1000000000
                                                ),
                                                null
                                        ),
                                        null
                                ),
                                null
                        ),
                        null
                ),
                null
        ), 0);
        System.out.println(i);
    }

    public int pathSum(TreeNode root, int targetSum) {
        int cnt = 0;
        if (root == null) {
            return 0;
        }
        cnt += getSingleNodeSum(root, targetSum);
        cnt += pathSum(root.left, targetSum);
        cnt += pathSum(root.right, targetSum);
        return cnt;
    }

    private int getSingleNodeSum(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }
        int cnt = 0;
        if (root.val == targetSum) {
            cnt++;
        }
        cnt += getSingleNodeSum(root.left, targetSum - root.val);
        cnt += getSingleNodeSum(root.right, targetSum - root.val);
        return cnt;
    }


}
