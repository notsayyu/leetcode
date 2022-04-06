package datastructure.jianzhioffer;

import subjects.ListNode;

/**
 * @description:
 * @author: dsy
 * @date: 2022/2/3 09:27
 */
public class JZ23 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return pHead;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast != null && fast.next != null) {
            // 先使用快慢指针找到相遇的点，就是slow指针移动了[环的节点个数]
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // slow指针先移动了[环的节点个数]，此时slow2再从头节点出发
                // slow和slow2以相同的慢速度移动，相遇时就是环的入口点
                ListNode slow2 = pHead;
                while (slow2 != slow) {
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}