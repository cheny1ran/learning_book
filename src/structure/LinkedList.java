package structure;

/**
 * 功能描述:
 *
 * @Author ewnit
 * @Date 16/11/10.
 */
public class LinkedList {

    /**
     * 单向链表
     * 基本数据结构
     */
    class ListNode {
        ListNode next;
        int val;
    }

    /**
     * 判断是否成环与寻找环入口点
     * 1.判断节点是否重复出现
     * 可以用Set集合来完成,耗费空间的做法
     * 2.快慢指针法
     * 快指针每次走两步，慢指针每次走一步，如果快慢指针相遇则有环，否则快指针会一直走到NULL为止退出循环，返回false.
     * 首先我们来分析下在链表有环时都能推出哪些特性：
     * <p/>
     * 在知道链表内有环后，求环长是一件非常简单的事情，只要从刚才那个相遇点开始，固定P2，继续移动P1，直到P1与P2再次相遇，所经过的步数就是环长。
     * 怎么求环前面那段子链的长度呢？很简单，让P1和P2都回到链表起点，然后让P2先往前走L（表示一圈）次（每次往前走一步），然后P1和P2再同时往前走，当它们再次相遇时，P1所走的步数就是环前面的子链长度。
     */
    public ListNode hasRing(ListNode head) {
        ListNode p1 = head, p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            // 有环
            if (p1 == p2) {
                // 环长
                int len = 1;
                p2 = p2.next;
                while (p2 != p1) {
                    len++;
                    p2 = p2.next;
                }
                int dis = 0;
                p1 = head;
                p2 = head;
                for (int i = 0; i < len; i++) {
                    p1 = p1.next;
                }
                while (p1 != p2) {
                    dis++;
                    p1 = p1.next;
                    p2 = p2.next;
                }
                System.out.println("存在环, 环长 " + len + " 入口点距 head 节点 " + dis + " 步长");
                return p1;
            }
        }
        System.out.println("不存在环");
        return null;
    }
    /**
     * 仅遍历一次链表找出链表的中间元素(第k个元素)。
     */

    /**
     * 链表反转
     */

    /**
     * 判断两个无环链表是否相交，如果有，求相交点。
     */

    /**
     * 判断两个可能有环的链表是否相交，如果有，求相交点.
     */
}
