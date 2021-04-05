package subjects.sample;

/**
 * @description: 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * <p>
 * 1--2-3--4--5--null
 * @author: dsy
 * @date: 2020/4/8 18:39
 */
public class Q206 {
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;

        while (null != cur) {
            //记录当前节点的下一个节点
            next = cur.next;
            //然后将当前节点指向pre
            cur.next = pre;
            //pre和cur节点都前进一位
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = reverseList(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
