package leetcode;

/**
 * 功能描述:
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p/>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p/>
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 *
 * @Author ewnit
 * @Date 16/11/1.
 */
public class Partition_List_86 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode newHead = null;
        ListNode newHead1 = null;
        ListNode cur = null;
        ListNode cur1 = null;
        ListNode node = head;
        while (node != null) {
            if (node.val < x) {
                if (newHead == null) {
                    newHead = new ListNode(node.val);
                    cur = newHead;
                } else {
                    ListNode n = new ListNode(node.val);
                    cur.next = n;
                    cur = cur.next;
                }
            } else {
                if (newHead1 == null) {
                    newHead1 = new ListNode(node.val);
                    cur1 = newHead1;
                } else {
                    ListNode n = new ListNode(node.val);
                    cur1.next = n;
                    cur1 = cur1.next;
                }
            }
            node=node.next;
        }
        if(cur!=null) {
            cur.next = newHead1;
        }else if(cur1!=null){
            newHead=newHead1;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        node.next=node1;
        node1.next=node2;
        node2.next=node3;
        new Partition_List_86().partition(node, 2);
    }
}
