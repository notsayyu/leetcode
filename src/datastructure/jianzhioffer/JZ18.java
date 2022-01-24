package datastructure.jianzhioffer;

import subjects.ListNode;

/**
 * @description:
 * @author: dsy
 * @date: 2022/1/24 18:46
 */
public class JZ18 {
    public static ListNode deleteNode(ListNode head, int val) {
        // write code here
        if (head.val == val) {
            return head.next;
        }
        ListNode pre = head;
        ListNode next = pre.next;
        while (next != null) {
            if (next.val == val) {
                pre.next = next.next;
                return head;
            }
            pre = next;
            next = next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);
        ListNode result = deleteNode(head, 9);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}