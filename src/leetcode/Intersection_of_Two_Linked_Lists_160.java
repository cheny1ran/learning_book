package leetcode;

/**
 * 功能描述:
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * <p/>
 * <p/>
 * For example, the following two linked lists:
 * <p/>
 * A:          a1 → a2
 * :                   ↘
 * :                    c1 → c2 → c3
 * :                   ↗
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 * <p/>
 * <p/>
 * Notes:
 * <p/>
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 *
 * @Author ewnit
 * @Date 16/12/2.
 */
public class Intersection_of_Two_Linked_Lists_160 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // first iterator two list find the length of both
    // 2nd time the longer one goes first long.length-short.length steps
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null) return null;
        int lenA = 0, lenB = 0;
        ListNode ha = headA, hb = headB;
        while (ha != null || hb != null) {
            if (ha != null) {
                lenA++;
                ha = ha.next;
            }
            if (hb != null) {
                lenB++;
                hb = hb.next;
            }
        }
        //ha=longer list,hb=shorter list
        ha = lenA >= lenB ? headA : headB;
        hb = lenA >= lenB ? headB : headA;
        int l = lenA >= lenB ? lenA : lenB;
        int s = lenA >= lenB ? lenB : lenA;
        if (l != s) {
            for (int i = 0; i < l - s; i++) {
                ha = ha.next;
            }
        }
        while (ha != hb) {
            ha = ha.next;
            hb = hb.next;
        }

        return ha;
    }

}
