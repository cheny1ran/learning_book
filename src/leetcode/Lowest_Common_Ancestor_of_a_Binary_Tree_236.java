package leetcode;

/**
 * 功能描述:
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * _______3______
 * /              \
 * ___5__          ___1__
 * /      \        /      \
 * 6      _2       0       8
 * /  \
 * 7   4
 * For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * <p>
 * 在图论和计算机科学中，最近公共祖先是指在一个树或者有向无环图中同时拥有v和w作为后代的最深的节点。
 * 在这里，我们定义一个节点也是其自己的后代，因此如果v是w的后代，那么w就是v和w的最近公共祖先。
 * 最近公共祖先是两个节点所有公共祖先中离根节点最远的，计算最近公共祖先和根节点的长度往往是有用的。
 * 比如为了计算树中两个节点v和w之间的距离，可以使用以下方法：
 * 分别计算由v到根节点和w到根节点的距离，两者之和减去最近公共祖先到根节点的距离的两倍即可得到v到w的距离。
 *
 * @Author ewnit
 * @Date 16/12/13.
 */
public class Lowest_Common_Ancestor_of_a_Binary_Tree_236 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 再找到这个元素的过程中记下所有祖先
     * 排序后比较
     */

//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        List<TreeNode> pl = getAncestor(root, p);
//        List<TreeNode> ql = getAncestor(root, q);
//
//        List<TreeNode> s,l;
//        if (pl.size() == ql.size()) {
//            return pl.get(0);
//        } else if (pl.size() < ql.size()) {
//            s=pl;
//            l=ql;
//        }else{
//            s=ql;
//            l=pl;
//        }
//        int st = s.size() - 1, lt = l.size() - 1;
//
//        while (st != lt) {
//            lt--;
//        }
//        while (!s.get(st).equals(l.get(lt))) {
//            st--;
//            lt--;
//        }
//        return s.get(st);
//    }
//
//    public List<TreeNode> getAncestor(TreeNode root, TreeNode p) {
//        List<TreeNode> anc = new ArrayList<>();
//        if(!root.equals(p)) anc.add(root);
//        if(root.left!=null) anc.addAll(getAncestor(root.left, p));
//        if(root.right!=null) anc.addAll(getAncestor(root.right, p));
//        return anc;
//    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.equals(p) || root.equals(q)) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left == null ? right : left;
    }
}
