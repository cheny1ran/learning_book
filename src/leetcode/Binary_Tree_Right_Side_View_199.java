package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * <p>
 * For example:
 * Given the following binary tree,
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 * You should return [1, 3, 4].
 *
 * @Author chen.yiran
 * @Date 17/3/22.
 */
public class Binary_Tree_Right_Side_View_199 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * if there is a sibling use the right one.
     * <p>
     * recursive get left array and right array
     * if left one is longer than right
     * return the whole right + left.concat(right.length)
     * else return the right one
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        ans.add(root.val);
        if (root.left == null && root.right == null) return ans;

        List<Integer> leftList = rightSideView(root.left);
        List<Integer> rightList = rightSideView(root.right);


        if (leftList.size() > rightList.size()) {
            ans.addAll(rightList);
            for (int i = rightList.size(); i < leftList.size(); i++) {
                ans.add(leftList.get(i));
            }
        }else{
            ans.addAll(rightList);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode node1 = new Binary_Tree_Right_Side_View_199.TreeNode(1);
        TreeNode node2 = new Binary_Tree_Right_Side_View_199.TreeNode(2);
        TreeNode node3 = new Binary_Tree_Right_Side_View_199.TreeNode(3);
        TreeNode node4 = new Binary_Tree_Right_Side_View_199.TreeNode(4);
        TreeNode node5 = new Binary_Tree_Right_Side_View_199.TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node5;
        node3.left = node4;

        List<Integer> list = new Binary_Tree_Right_Side_View_199().rightSideView(node1);
        for (Integer i : list) {
            System.out.print(i + " ");
        }

    }

}
