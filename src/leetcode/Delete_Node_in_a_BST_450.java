package leetcode;

/**
 * 功能描述:
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 * <p>
 * Basically, the deletion can be divided into two stages:
 * <p>
 * Search for a node to remove.
 * If the node is found, delete the node.
 * <p>
 * Note: Time complexity should be O(height of tree).
 * <p>
 * Example:
 * <p>
 * root = [5,3,6,2,4,null,7]
 * key = 3
 * <p>
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Given key to delete is 3. So we find the node with value 3 and delete it.
 * <p>
 * One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
 * <p>
 * 5
 * / \
 * 4   6
 * /     \
 * 2       7
 * <p>
 * Another valid answer is [5,2,6,null,4,null,7].
 * <p>
 * 5
 * / \
 * 2   6
 * \   \
 * 4   7
 *
 * @Author chen.yiran
 * @Date 17/1/13.
 */
public class Delete_Node_in_a_BST_450 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode node = root;
        TreeNode parent = null;
        while (node != null && node.val != key) {
            parent = node;
            if (key > node.val) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        if (node != null) {
            if (node.left != null) {
                TreeNode inset = node.right;
                if (inset == null) {
                    node.right = node.left.right;
                } else {
                    while (inset.left != null) inset = inset.left;
                    inset.left = node.left.right;
                }
                node.left.right = node.right;
                if (parent == null) {
                    root = node.left;
                } else {
                    if (parent.val > node.val)
                        parent.left = node.left;
                    else parent.right = node.left;
                }
            } else {
                if (parent == null) {
                    root = node.right;
                } else {
                    if (parent.val > node.val)
                        parent.left = node.right;
                    else parent.right = node.right;
                }
            }
        }
        return root;
    }


}
