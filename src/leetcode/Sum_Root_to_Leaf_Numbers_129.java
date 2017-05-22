package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * <p>
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * <p>
 * Find the total sum of all root-to-leaf numbers.
 * <p>
 * For example,
 * <p>
 * 1
 * / \
 * 2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * <p>
 * Return the sum = 12 + 13 = 25.
 *
 * @Author chen.yiran
 * @Date 17/5/19.
 */
public class Sum_Root_to_Leaf_Numbers_129 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //深度优先遍历
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;

        int ans = 0;
        List<String> nums = DFS(root);
        for (String str : nums) {
            Integer num = new Integer(str);
            ans += num;
        }

        return ans;
    }

    public List<String> DFS(TreeNode node) {
        List<String> list = new ArrayList<>();
        if (node == null) return list;
        String str = Integer.toString(node.val);
        if (node.left == null && node.right == null) {
            list.add(str);
            return list;
        }

        List<String> left = DFS(node.left);
        List<String> right = DFS(node.right);
        for (String leftStr : left) {
            String tem = str + leftStr;
            list.add(tem);
        }

        for (String rightStr : right) {
            String tem = str + rightStr;
            list.add(tem);
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);

        node.right = n1;

        new Sum_Root_to_Leaf_Numbers_129().sumNumbers(node);
    }

}
