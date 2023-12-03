package bytedance.codetop;

import org.example.hot100.binaryTree.TreeNode;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/12/3 18:17
 */
public class BuildTree {

    public static void main(String[] args) {
        buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder, int preBegin, int preEnd, int inBegin, int inEnd) {
        if (preBegin < 0 || inBegin < 0 || preEnd > preorder.length - 1 || inEnd > inorder.length - 1) {
            return null;
        }
        if (preBegin > preEnd || inBegin > inEnd) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preBegin], null, null);
        int orderRootIndex = findIndex(inorder, inBegin, inEnd, node.val);
        if (orderRootIndex < 0) {
            return null;
        }
        node.left = buildTree(preorder, inorder, preBegin + 1, preBegin + orderRootIndex - inBegin, inBegin, orderRootIndex - 1);
        node.right = buildTree(preorder, inorder, preBegin + orderRootIndex - inBegin + 1, preEnd, orderRootIndex + 1, inEnd);
        return node;
    }

    private static int findIndex(int[] inorder, int inBegin, int inEnd, int val) {
        for (int i = inBegin; i <= inEnd; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }

}
