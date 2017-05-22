package leetcode;

/**
 * 功能描述:
 * <p>
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * @Author chen.yiran
 * @Date 17/5/17.
 */
public class Sort_List_148 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // TLE
    // O(n^2)in worst case
    public ListNode sortListTLE(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        ListNode sortedHead = head;
        while (cur.next != null) {
            ListNode nextNode = cur.next;
            boolean flag = true;
            if (nextNode.val < cur.val) {
                ListNode sortedCur = sortedHead;
                ListNode nnextNode = nextNode.next;
                while (sortedCur.next != null) {
                    if (sortedCur.val >= nextNode.val) {
                        sortedHead = nextNode;
                        nextNode.next = sortedCur;
                        cur.next = nnextNode;
                        flag = false;
                        break;
                    }
                    if (sortedCur.val < nextNode.val && sortedCur.next.val >= nextNode.val) {
                        nextNode.next = sortedCur.next;
                        sortedCur.next = nextNode;
                        cur.next = nnextNode;
                        flag = false;
                        break;
                    }
                    sortedCur = sortedCur.next;
                }
            }
            if (flag) cur = cur.next;
        }
        return sortedHead;
    }


    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // step 1. cut the list to two halves
        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        // step 2. sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // step 3. merge l1 and l2
        return merge(l1, l2);
    }

    ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), p = l;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null)
            p.next = l1;

        if (l2 != null)
            p.next = l2;

        return l.next;
    }



    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(19);
        ListNode n3 = new ListNode(14);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(-3);
        ListNode n6 = new ListNode(1);
        ListNode n7 = new ListNode(8);
        ListNode n8 = new ListNode(5);
        ListNode n9 = new ListNode(11);
        ListNode n10 = new ListNode(15);
        //[4,19,14,5,-3,1,8,5,11,15]

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        System.out.println(new Sort_List_148().sortList(n1));
    }

}
