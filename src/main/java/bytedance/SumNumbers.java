package bytedance;

import org.example.hot100.binaryTree.TreeNode;

import java.util.*;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/19 00:23
 */
public class SumNumbers {

    public static void main(String[] args) {
        int i = sumNumbers(new TreeNode(
                1,
                new TreeNode(2),
                new TreeNode(3)
        ));
        System.out.println(i);
    }

    public static int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> single = new Stack<>();
        dfs(root, res, single);
        int sum = 0;
        for (List<Integer> re : res) {
            sum+=count(re);
        }
        return sum;
    }

    private static int count(List<Integer> re) {
        int sum = 0;
        for (int i = re.size() - 1; i >= 0; i--) {
            sum += Math.pow(10, re.size() - 1 -i) * re.get(i);
        }
        return sum;
    }

    private static void dfs(TreeNode root, List<List<Integer>> res, Stack<Integer> single) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            List<Integer> tmp = new ArrayList<>(single);
            tmp.add(root.val);
            res.add(tmp);
            return;
        }
        single.push(root.val);
        dfs(root.left, res, single);
        dfs(root.right, res, single);
        single.pop();
    }

}
