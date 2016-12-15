package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:
 * <p>
 * Given a binary tree, flatten it to a linked list in-place.
 * <p>
 * For example,
 * Given
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * The flattened tree should look like:
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 *
 * @Author ewnit
 * @Date 16/12/13.
 */
public class Flatten_Binary_Tree_to_Linked_List_114 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 前序
    public void flatten(TreeNode root) {
        List<TreeNode> tn = preorder(root);
        if (tn.size() > 1) {
            TreeNode pre = root;
            root.left=null;
            for (int i = 1; i < tn.size(); i++) {
                pre.right = tn.get(i);
                pre = pre.right;
            }
        }
    }


    public List<TreeNode> preorder(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        if (root == null) return list;
        TreeNode begin = new TreeNode(root.val);
        list.add(begin);
        if (root.left != null || root.right != null) {
            if (root.left != null) {
                list.addAll(preorder(root.left));
            }
            if (root.right != null) {
                list.addAll(preorder(root.right));
            }
        }
        return list;
    }

    TreeNode prev = null;
    public void flatten1(TreeNode root) {
        if (root == null)
            return;
        flatten1(root.right);
        flatten1(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void main(String[] args) {
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        tn1.left = tn2;
        new Flatten_Binary_Tree_to_Linked_List_114().flatten(tn1);
    }
}
