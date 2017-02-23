package leetcode;

/**
 * 功能描述:
 * Invert a binary tree.
 * <p>
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * to
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * @Author chen.yiran
 * @Date 17/2/17.
 */
public class Invert_Binary_Tree_226 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return root;
        }
        TreeNode right=invertTree(root.left);
        TreeNode left=invertTree(root.right);
        root.right = right;
        root.left = left;
        return root;
    }


}
