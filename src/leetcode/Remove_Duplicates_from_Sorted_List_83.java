package leetcode;

/**
 * 功能描述:Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p/>
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 *
 * @Author ewnit
 * @Date 16/10/31.
 */
public class Remove_Duplicates_from_Sorted_List_83 {


    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode crt = head;
        while (crt.next != null) {
            ListNode next = crt.next;
            if (next.val == crt.val) {
                crt.next = next.next;
            }else {
                crt = next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(1);
        listNode.next = listNode1;
        ListNode listNode2 = new ListNode(1);
        listNode1.next = listNode2;

        new Remove_Duplicates_from_Sorted_List_83().deleteDuplicates(listNode);
    }

}
