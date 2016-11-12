package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * <p/>
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * <p/>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 *
 * @Author ewnit
 * @Date 16/11/10.
 */
public class Unique_Binary_Search_Trees_II_95 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    // dfs 像213这种会重复两次
//    public List<TreeNode> generateTrees(int n) {
//
//        if (n > 0) {
//            for (int i = 1; i <= n; i++) {
//                int use = 1;
//                int[] used = new int[n];
//                used[i - 1] = 1;
//                dfs(used, n, use, new TreeNode(i));
//            }
//        }
//        return list;
//    }
//
//    public void dfs(int[] used, int n, int use, TreeNode root) {
//        if (use == n) {
//            list.add(root);
//            return;
//        }
//        for (int i = 1; i <= n; i++) {
//            TreeNode rt = root;
//            if (use == 1) {
//                rt = new TreeNode(root.val);
//            }
//            if (used[i - 1] != 1) {
//                used[i - 1] = 1;
//                TreeNode crt = rt;
//                while (crt != null) {
//                    if (i > crt.val) {
//                        if (crt.right == null) {
//                            break;
//                        } else {
//                            crt = crt.right;
//                        }
//                    } else {
//                        if (crt.left == null) {
//                            break;
//                        } else {
//                            crt = crt.left;
//                        }
//                    }
//                }
//                TreeNode node = new TreeNode(i);
//                if (i > crt.val && crt.right == null) {
//                    crt.right = node;
//                } else if (i < crt.val && crt.left == null) {
//                    crt.left = node;
//                }
//                dfs(used, n, use + 1, rt);
//                used[i - 1] = 0;
//            }
//        }
//
//    }

    // 直接递归

    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<>();
        return func(1, n);
    }

    public List<TreeNode> func(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start == end) {
            list.add(new TreeNode(start));
        } else if (start < end) {
            for (int i = start; i <= end; i++) {
                List<TreeNode> leftTree = func(start, i - 1);
                List<TreeNode> rightTree = func(i + 1, end);
                for (TreeNode left : leftTree) {
                    for (TreeNode right : rightTree) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        list.add(root);
                    }
                }
            }
        } else {
            list.add(null);
        }
        return list;
    }

    // dp 储存1~n的TreeNode List到数组list
    // i ->1~n
    // dp[n]=根节点n+左子树dp[i]+右子树[n-i-1]
    // 右子树还是要递归

    public static void main(String[] args) {
        List<TreeNode> nodes = new Unique_Binary_Search_Trees_II_95().generateTrees(3);
    }


}
