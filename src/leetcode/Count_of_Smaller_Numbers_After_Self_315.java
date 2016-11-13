package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * 功能描述:
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 * <p/>
 * Example:
 * <p/>
 * Given nums = [5, 2, 6, 1]
 * <p/>
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * Return the array [2, 1, 1, 0].
 *
 * @Author ewnit
 * @Date 16/11/12.
 */
public class Count_of_Smaller_Numbers_After_Self_315 {

    //从右往左,一旦碰到right<left的count[left]+=count[right]+1;
    //要找到比self小又要在right数组中最大的数
    //右边边统计边排序
    //还是TLE

//    public List<Integer> countSmaller(int[] nums) {
//        List<Integer> list = new ArrayList<>();
//        if (nums.length == 0) {
//            return list;
//        } else if (nums.length == 1) {
//            list.add(0);
//            return list;
//        }
//        Node head = buildTree(nums);
//        Node crt = head;
//        while (crt != null) {
//            list.add(crt.less);
//            if (crt.left != null) {
//                crt = crt.left;
//            } else {
//                crt = crt.right;
//            }
//        }
//
//        return list;
//    }
//
//
//    public Node buildTree(int[] a) {
//        if (a.length == 0) return null;
//        Node head = new Node(a[0]);
//        if (a.length > 1) {
//            Node crt = head, pre = null;
//            for (int i = 1; i < a.length; i++) {
//                Node node = new Node(a[i]);
//                pre = crt;
//                while (pre != null) {
//                    if (pre.val > a[i]) pre.less++;
//                    pre = pre.parent;
//                }
//                if (a[i] < crt.val) {
//                    crt.left = node;
//                } else {
//                    crt.right = node;
//                }
//                node.parent = crt;
//                crt = node;
//            }
//        }
//        return head;
//    }

    class Node {
        int val;
        Node left;
        Node right;
        int less = 0;

        Node(int less, int val) {
            this.val = val;
            this.less = less;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        Node root = null;
        Integer[] ret = new Integer[nums.length];
        if (nums == null || nums.length == 0) return Arrays.asList(ret);
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(root, nums[i], ret, i, 0);
        }
        return Arrays.asList(ret);
    }

    public Node insert(Node root, int val, Integer[] ans, int index, int preSum) {
        if (root == null) {
            root = new Node(0, val);
            ans[index] = preSum;
        } else if (root.val > val) {
            root.less++;
            root.left = insert(root.left, val, ans, index, preSum);
        } else {
            root.right = insert(root.right, val, ans, index, root.less + preSum + (root.val < val ? 1 : 0));
            //only adding 1 on preSum if root.val is only smaller than val
        }
        return root;
    }


    public static void main(String[] args) {
        int[] nums = {1, 9, 7, 8, 5};
        new Count_of_Smaller_Numbers_After_Self_315().countSmaller(nums);
    }
}
