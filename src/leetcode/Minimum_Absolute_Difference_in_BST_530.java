package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/**
 * 功能描述:
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 1
 * \
 * 3
 * /
 * 2
 * <p>
 * Output:
 * 1
 * <p>
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 *
 * @Author chen.yiran
 * @Date 17/5/26.
 */
public class Minimum_Absolute_Difference_in_BST_530 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = getArray(root);
        Collections.sort(list);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(list.get(i) - list.get(i - 1), min);
        }
        return min;
    }

    public List<Integer> getArray(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        if (root.left == null && root.right == null) {
            return list;
        }
        if (root.left != null) list.addAll(getArray(root.left));
        if (root.right != null) list.addAll(getArray(root.right));
        return list;
    }

    static TreeSet set = new TreeSet();

    public static void main(String[] args) {
        set.floor(1);
    }
}
