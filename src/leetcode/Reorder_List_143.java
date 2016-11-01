package leetcode;

import java.util.ArrayList;

/**
 * 功能描述:
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p/>
 * You must do this in-place without altering the nodes' values.
 * <p/>
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 *
 * @Author ewnit
 * @Date 16/11/1.
 */
public class Reorder_List_143 {


    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null) return;
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            ListNode next = node.next;
            //这里存的时候不把next置为null的话有可能会循环指向
            node.next = null;
            list.add(node);
            node = next;
        }
        ListNode crt = head;
        int h = 1, p = list.size() - 1;
        while (h < p) {
            crt.next = list.get(p);
            crt = crt.next;
            crt.next = list.get(h);
            crt = crt.next;
            p--;
            h++;
        }
        if (h == p) {
            crt.next = list.get(h);
        }
    }

    /**
     * 快慢指针
     * src: https://discuss.leetcode.com/topic/62110/simple-java-solution
     */
    public void reorderList1(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //分割前后两段
        ListNode curr = slow.next;
        slow.next = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = slow.next;
            slow.next = curr;
            curr = next;
        }

        ListNode tmp = slow.next;
        while (true) {
            if (head == slow) {
                head.next = tmp;
                break;
            }

            ListNode headNext = head.next;
            ListNode tmpNext = tmp.next;
            head.next = tmp;
            tmp.next = headNext;
            head = headNext;
            tmp = tmpNext;

        }
    }

    public static void main(String[] args) {
        Reorder_List_143.ListNode ln = new ListNode(1);
        Reorder_List_143.ListNode ln1 = new ListNode(2);
        Reorder_List_143.ListNode ln2 = new ListNode(3);
        Reorder_List_143.ListNode ln3 = new ListNode(4);
        ln.next = ln1;
        ln1.next = ln2;
//        ln2.next = ln3;

        new Reorder_List_143().reorderList(ln);
        while (ln != null) {
            System.out.print(ln.val + " ");
            ln = ln.next;
        }
        System.out.println();

    }

}
