package leetcode;

import java.util.Stack;

/**
 * 功能描述:
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 *
 * @Author chen.yiran
 * @Date 16/12/16.
 */
public class Palindrome_Linked_List_234 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 利用栈先进后出的特性
     */
    public boolean isPalindrome1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.add(node);
            node = node.next;
        }
        int len = stack.size();
        node = head;
        if (len > 0) {
            for (int i = 0; i <= len / 2; i++) {
                if (stack.pop().val != node.val) return false;
                node = node.next;
            }
        }
        return true;
    }

    /**
     * time O(n) & space O(1)?
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = reverse(slow.next);
        slow = slow.next;
        while (slow != null) {
            if (slow.val != head.val) return false;
            slow = slow.next;
            head = head.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = null;
        while (head != null) {
            cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }
        return pre;
    }

}
