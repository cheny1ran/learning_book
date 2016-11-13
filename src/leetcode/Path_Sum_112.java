package leetcode;

/**
 * 功能描述:
 * <p/>
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * <p/>
 * For example:
 * Given the below binary tree and sum = 22,
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 *
 * @Author ewnit
 * @Date 16/11/13.
 */
public class Path_Sum_112 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, sum, 0);
    }

    public boolean dfs(TreeNode root, int sum, int tem) {
        if(root==null) return false;
        if (root.left == null && root.right == null) {
            if (root.val + tem == sum) {
                return true;
            } else {
                return false;
            }
        }
        boolean l = false, r = false;
        if (root.left != null) l = dfs(root.left, sum, tem + root.val);
        if (root.right != null) r = dfs(root.right, sum, tem + root.val);
        if (!l && !r) return false;
        return true;
    }

}
