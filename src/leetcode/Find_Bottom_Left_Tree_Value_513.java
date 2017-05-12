package leetcode;


import java.util.LinkedList;

/**
 * 功能描述:
 * <p>
 * <p>
 * Given a binary tree, find the leftmost value in the last row of the tree.
 * <p>
 * Example 1:
 * Input:
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * Output:
 * 1
 * Example 2:
 * Input:
 * <p>
 * 1
 * / \
 * 2   3
 * /   / \
 * 4   5   6
 * /
 * 7
 * <p>
 * Output:
 * 7
 * Note: You may assume the tree (i.e., the given root node) is not NULL.
 *
 * @Author chen.yiran
 * @Date 17/5/3.
 */
public class Find_Bottom_Left_Tree_Value_513 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * left first
     * use stack push right one first
     */

    public int findBottomLeftValue(TreeNode root) {

        LinkedList<TreeNode> list = new LinkedList<>();
        list.push(root);
        while (!list.isEmpty()) {
            int leftmost = list.peek().val;
            LinkedList<TreeNode> ll = new LinkedList<>();
            while (!list.isEmpty()) {
                TreeNode tn = list.pop();
                if (tn.left != null) {
                    ll.add(tn.left);
                }

                if (tn.right != null) {
                    ll.add(tn.right);
                }
            }
            if (ll.isEmpty()) {
                return leftmost;
            }
            list.addAll(ll);
        }
        return root.val;
    }

    public static void main(String[] args) {
        Find_Bottom_Left_Tree_Value_513 clz = new Find_Bottom_Left_Tree_Value_513();
        Find_Bottom_Left_Tree_Value_513.TreeNode tn1 = new Find_Bottom_Left_Tree_Value_513.TreeNode(1);
        Find_Bottom_Left_Tree_Value_513.TreeNode tn2 = new Find_Bottom_Left_Tree_Value_513.TreeNode(2);
        Find_Bottom_Left_Tree_Value_513.TreeNode tn3 = new Find_Bottom_Left_Tree_Value_513.TreeNode(3);
        Find_Bottom_Left_Tree_Value_513.TreeNode tn4 = new Find_Bottom_Left_Tree_Value_513.TreeNode(4);
        Find_Bottom_Left_Tree_Value_513.TreeNode tn5 = new Find_Bottom_Left_Tree_Value_513.TreeNode(5);
        Find_Bottom_Left_Tree_Value_513.TreeNode tn6 = new Find_Bottom_Left_Tree_Value_513.TreeNode(6);
        Find_Bottom_Left_Tree_Value_513.TreeNode tn7 = new Find_Bottom_Left_Tree_Value_513.TreeNode(7);

        tn1.left = tn2;
        tn1.right = tn3;
        tn2.left = tn4;
        tn3.left = tn5;
        tn3.right = tn6;
        tn5.right = tn7;

        System.out.println(clz.findBottomLeftValue(tn1));

    }

}
