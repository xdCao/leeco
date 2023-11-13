package org.example.hot100.binaryTree;

/**
 * 108. 将有序数组转换为二叉搜索树
 * @author buku.ch
 * @Desc
 * @date 2023/11/13 21:09
 */
public class SortedArrayToBST {

    public static void main(String[] args) {
        SortedArrayToBST sortedArrayToBST = new SortedArrayToBST();
        sortedArrayToBST.sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        TreeNode root = getTree(nums, 0, nums.length - 1);
        return root;
    }

    private TreeNode getTree(int[] nums, int begin, int end) {
        if (begin > end) {
            return null;
        }
        TreeNode node = new TreeNode(nums[(begin + end) / 2]);
        node.left = getTree(nums, begin, (begin + end) / 2 -1);
        node.right = getTree(nums, (begin + end) / 2 + 1, end);
        return node;
    }

}
