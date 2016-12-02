package leetcode;

/**
 * 功能描述:
 * Given a complete binary tree, count the number of nodes.
 * <p/>
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last,
 * is completely filled, and all nodes in the last level are as far left as possible.
 * It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * @Author ewnit
 * @Date 16/12/2.
 */
public class Count_Complete_Tree_Nodes_222 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 直接递归遍历会TLE
     */
    public int countNodesTLE(TreeNode root) {
        int total = 0;

        if (root == null) return total;
        total++;

        total += countNodesTLE(root.left);
        total += countNodesTLE(root.right);
        return total;
    }

    /**
     * better than 2^n, first get height
     */
    int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }

    public int countNodes(TreeNode root) {
        int nodes = 0, h = height(root);
        while (root != null) {
            if (height(root.right) == h - 1) {
                nodes += 1 << h;
                root = root.right;
            } else {
                nodes += 1 << h - 1;
                root = root.left;
            }
            h--;
        }
        return nodes;
    }

    public static void main(String[] args) {
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(4);
        TreeNode tn5 = new TreeNode(5);
        TreeNode tn6 = new TreeNode(6);
        TreeNode tn7 = new TreeNode(7);
        TreeNode tn8 = new TreeNode(8);

        tn1.left = tn2;
        tn1.right = tn3;
        tn2.left = tn4;
        tn2.right = tn5;
        tn3.left = tn6;
        tn3.right = tn7;
        tn4.left = tn8;

        System.out.println(new Count_Complete_Tree_Nodes_222().countNodes(tn1));

    }

}