package structure;

/**
 * 功能描述:
 * 树:
 * 1.Trie(prefix tree) 单词查找树/字典树
 * 典型应用于统计,排序和保存大量字符串,利用字符串的公共前缀来减少查询时间,最大限度地减少无谓字符串的比较,查询效率优于Hash树
 * 基本性质:
 * 根节点不包含字符 除根节点外每个节点都只包含一个字符
 * 从根节点到叶子节点,路径上经过的字符连起来为该节点对应的字符串
 * 每个节点的所有子节点包含的字符都不同
 *
 * @Author ewnit
 * @Date 16/11/1.
 */
public class Tree {

    /**
     * 二叉树节点结构
     */
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }

    /**
     * 二叉树通用方法:遍历
     * 1.前序遍历 self->left->right
     * 2.中序遍历 left->self->right
     * 3.后序遍历 left->right->self
     */
    // 前序遍历
    public void pre_order_traversal(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        pre_order_traversal(root.left);
        pre_order_traversal(root.right);
    }

    // 中序遍历
    public void in_order_traversal(TreeNode root) {
        if (root == null) return;
        in_order_traversal(root.left);
        System.out.println(root.val);
        in_order_traversal(root.right);
    }

    // 后序遍历
    public void post_order_traversal(TreeNode root) {
        if (root == null) return;
        post_order_traversal(root.left);
        post_order_traversal(root.right);
        System.out.println(root.val);

    }


    /**
     * 字典树
     * 根的值为空
     * http://blog.csdn.net/beiyetengqing/article/details/7856113
     */
    class TrieNode {
        TrieNode[] childNode = new TrieNode[26];
        //if 非null 则表示已成词
        String word;
    }

    class Trie {
        // 创建树
        public TrieNode buildTrie(String[] words) {
            TrieNode root = new TrieNode();
            for (String w : words) {
                TrieNode p = root;
                for (char c : w.toCharArray()) {
                    int i = c - 'a';
                    if (p.childNode[i] == null) p.childNode[i] = new TrieNode();
                    p = p.childNode[i];
                }
                p.word = w;
            }
            return root;
        }

    }

    /**
     * Binary Search Tree(BST) 二叉搜索树
     * 特征:
     * left < self < right
     */
    class BST {

        public void buildBST(int[] a) {

        }

    }
}
