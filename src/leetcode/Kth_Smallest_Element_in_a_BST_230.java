package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * <p/>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * <p/>
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 * <p/>
 * Show Hint
 *
 * @Author ewnit
 * @Date 16/11/4.
 */
public class Kth_Smallest_Element_in_a_BST_230 {

    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // BST left<self<right
    // 前序遍历存数组

    List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        mid_traverse(root);
        return list.get(k-1);
    }

    public void mid_traverse(TreeNode root) {
        if(root==null) return;
        if (root.left != null) {
            mid_traverse(root.left);
        }
        list.add(root.val);
        mid_traverse(root.right);
    }

}
