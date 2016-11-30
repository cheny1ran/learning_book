package leetcode;

/**
 * 功能描述:
 *
 * @Author ewnit
 * @Date 16/11/29.
 */
public class Linked_List_Cycle_II_142 {

    //      Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 要返回入口
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                int len = 1;
                fast = fast.next;
                while (slow != fast) {
                    len++;
                    fast = fast.next;
                }
                slow = head;
                fast = head;
                for (int i = 0; i < len; i++) {
                    fast = fast.next;
                }
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
