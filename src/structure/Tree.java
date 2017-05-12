package structure;

import leetcode.Delete_Node_in_a_BST_450;

/**
 * 功能描述:
 * 树
 *
 * @Author cheny1ran
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
     * Trie(prefix tree) 单词查找树/字典树
     * 典型应用于统计,排序和保存大量字符串,利用字符串的公共前缀来减少查询时间,最大限度地减少无谓字符串的比较,查询效率优于Hash树
     * <特征>:
     * 根的值为空 根节点不包含字符 除根节点外每个节点都只包含一个字符
     * 从根节点到叶子节点,路径上经过的字符连起来为该节点对应的字符串
     * 每个节点的所有子节点包含的字符都不同
     * http://blog.csdn.net/beiyetengqing/article/details/7856113
     */
    class Trie {
        class TrieNode {
            TrieNode[] childNode = new TrieNode[26];
            String word; //if 非null 则表示已成词
        }

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
     * <特征>:
     * left < self < right
     */
    class BST {

        public void buildBST(int[] a) {

        }

        public void deleteBSTNode() {
            new Delete_Node_in_a_BST_450();
        }

    }

    /**
     * Balanced Tree(B-Tree) 平衡多路查找树
     * 减少树的深度以提高查找效率
     * <p>
     * <特征>:
     * 每个非叶子节点由n-1个key和n个指针组成，其中d<=n<=2d。(d为树的度)
     * 每个叶子节点最少包含一个key和两个指针，最多包含2d-1个key和2d个指针，叶节点的指针均为null。
     * key和指针互相间隔，节点两端是指针。
     * 一个节点中的key从左到右非递减排列。
     * 如果某个指针在节点node的左右相邻key分别是key1和key2且不为null，则其指向节点的所有key小于v(key2)且大于v(key1)。
     */
    class BTree {

        final int D = 3; //度
        final int KEY_MAX = 2 * D - 1; //节点包含key最大个数
        final int KEY_MIN = D - 1; //节点包含key最小个数
        final int CHILD_MAX = KEY_MAX + 1; //可拥有的最大子节点
        final int CHILD_MIN = KEY_MIN + 1; //可拥有的最小子节点

        class BTreeNode {
            boolean isLeaf = true;
            int keyNum = 0;
            BTreeNode parent = null;
            BTreeNode[] childNode = new BTreeNode[CHILD_MAX + 1];   //多一个位置方便插入操作
            int[] key = new int[KEY_MAX + 1];
            int[] val = new int[KEY_MAX + 1];
        }

        // 插入节点
        // 如果叶子结点空间足够，即该结点的关键字数小于D-1，则直接插入在叶子结点的左边或右边
        // 如果空间满了以致没有足够的空间去添加新的元素，即该结点的关键字数已经有了D个，则需要将该结点进行“向上分裂”，
        //      将一半数量的关键字元素分裂到新的其相邻右结点中，中间关键字元素上移到父结点中，而且当结点中关键元素向右移动了，相关的指针也需要向右移。
        // 插入总是往叶子节点插 再向上分裂
        public boolean insert(BTreeNode root, int key, int value) {
            // 根节点为空
            if (root == null) {
                root = new BTreeNode();
                root.keyNum = 1;
                root.key[0] = key;
                root.val[0] = value;
                return true;
            } else if (findValue(root, key) != -1) return false;

            BTreeNode cur = root;
            while (!cur.isLeaf) {
                boolean flag = true;
                for (int i = 0; i < cur.keyNum; i++) {
                    if (cur.key[i] > key) {
                        cur = cur.childNode[i];
                        flag = false;
                        break;
                    }
                }
                if (flag) cur = cur.childNode[cur.keyNum];
            }
            // 叶子节点 childNode 都为 null
            // 要插入的节点未满 直接插入
            if (cur.keyNum != KEY_MAX) {
                if (cur.key[cur.keyNum - 1] < key) {
                    cur.key[cur.keyNum] = key;
                    cur.val[cur.keyNum] = value;

                } else {
                    for (int i = 0; i < cur.keyNum; i++) {
                        if (cur.key[i] > key) {
                            // 插入时移动数组
                            for (int j = cur.keyNum - 1; j > i; j--) {
                                cur.key[j] = cur.key[j - 1];
                                cur.val[j] = cur.val[j - 1];
                            }
                            cur.key[i] = key;
                            cur.val[i] = value;
                            break;
                        }
                    }
                }
                cur.keyNum++;
            } else {
                // 插入节点已满 要向上分裂
                // 1.找到插入位置 找到要向上分裂的节点
                // 2.分裂子节点
                BTreeNode prt = cur;
                int upPos = (KEY_MAX + 1) / 2;
                int upKey, upValue;
                while (prt != null && prt.keyNum == KEY_MAX) {
                    // 先插入
                    int newPos = prt.keyNum;
                    for (int i = 0; i < prt.keyNum; i++) {
                        if (prt.key[i] > key) {
                            newPos = i;
                            break;
                        }
                    }
                    for (int j = prt.keyNum; j > newPos; j--) {
                        prt.key[j] = prt.key[j - 1];
                        prt.val[j] = prt.val[j - 1];
                    }
                    prt.key[newPos] = key;
                    prt.val[newPos] = value;

                    // 分裂子节点
                    BTreeNode node = new BTreeNode();
                    node.keyNum = upPos;
                    for (int i = 0; i < node.keyNum; i++) {
                        node.key[i] = prt.key[upPos + i + 1];
                        node.val[i] = prt.key[upPos + i + 1];
                        node.childNode[i] = prt.childNode[upPos + i + 1];
                        prt.key[upPos + i + 1] = 0;
                        prt.val[upPos + i + 1] = 0;
                        prt.childNode[upPos + i + 1] = null;
                    }
                    node.childNode[node.keyNum] = prt.childNode[upPos + node.keyNum + 1];
                    prt.childNode[upPos + node.keyNum + 1] = null;
                    prt.key[upPos] = 0;
                    prt.val[upPos] = 0;
                    prt.childNode[upPos + 1] = null;

                    if (node.parent == null) {
                        BTreeNode parent = new BTreeNode();
                        parent.isLeaf = false;
                        parent.childNode[0] = node;
                        parent.childNode[1] = cur;
                        parent.keyNum = 1;
                        parent.key[0] = cur.key[upPos];
                        parent.val[0] = cur.key[upPos];
                    }

                    cur = prt;
                    prt = cur.parent;
                }
            }

            return true;
        }


        // 检索数据
        public int findValue(BTreeNode root, int key) {
            if (root == null) return -1;

            BTreeNode[] child = root.childNode;
            int[] keys = root.key;
            int[] val = root.val;
            // 此处可使用 binarySearch 提高效率
            for (int i = 0; i < root.keyNum; i++) {
                if (keys[i] == key) return val[i];
                if (keys[i] > key) {
                    return findValue(child[i], key);
                }
            }
            return findValue(child[root.keyNum], key);
        }

        // 删除数据
        public BTreeNode delete(BTreeNode root, int key) {
            if (findValue(root, key) == -1) return null;

            for (int i = 0; i < root.keyNum; i++) {
                if (root.key[i] == key) {
                    // 删除数据要调整root中的数组 并合并子树
                    mergeChildNode(root.childNode[i + 1], root.childNode[i]);
                    moveArray(root, i);
                }
                if (root.key[i] > key) {
                    return delete(root.childNode[i], key);
                }
            }
            return delete(root.childNode[root.keyNum], key);
        }

        private void moveArray(BTreeNode root, int index) {
            for (int i = index; i < root.keyNum - 1; i++) {
                root.key[i] = root.key[i + 1];
                root.val[i] = root.val[i + 1];
                root.childNode[i] = root.childNode[i + 1];
            }
            root.key[root.keyNum - 1] = 0;
            root.val[root.keyNum - 1] = 0;
            root.childNode[root.keyNum] = null;
            root.keyNum--;
        }

        private void mergeChildNode(BTreeNode root, BTreeNode merge) {

        }
    }

    /**
     * 红黑树
     * 因为一棵由n个结点随机构造的二叉查找树的高度为lgn，所以顺理成章，二叉查找树的一般操作的执行时间为O(lgn)。
     * 但二叉查找树若退化成了一棵具有n个结点的线性链后，则这些操作最坏情况运行时间为O(n)。
     * <p>
     * 红黑树虽然本质上是一棵二叉查找树，但它在二叉查找树的基础上增加了着色和相关的性质使得红黑树相对平衡，
     * 从而保证了红黑树的查找、插入、删除的时间复杂度最坏为O(log n)。
     * <p>
     * 若任意节点的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
     * 若任意节点的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
     * 任意节点的左、右子树也分别为二叉查找树。
     * 没有键值相等的节点（no duplicate nodes）。
     * <p>
     * <特征>:
     * <p>
     * 每个结点要么是红的要么是黑的。
     * 根结点是黑的。
     * 每个叶结点（叶结点即指树尾端NIL指针或NULL结点）都是黑的。
     * 如果一个结点是红的，那么它的两个儿子都是黑的。
     * 对于任意结点而言，其到叶结点树尾端NIL指针的每条路径都包含相同数目的黑结点。
     */
    class RedBlackTree {

    }
}
