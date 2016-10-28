package leetcode;

/**
 * 功能描述:
 *
 * @Author ewnit
 * @Date 16/10/28.
 */
public class Minimum_Depth_of_Binary_Tree_111 {

    //    Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // have to end in leaf
    // if  1
    //        2
    // then the ans is 2 not 1!
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
    }


}
