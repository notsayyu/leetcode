package datastructure.jianzhioffer;

import subjects.ListNode;

/**
 * @description:
 * @author: dsy
 * @date: 2022/2/3 11:03
 */
public class JZ24 {
    public static ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        // pre <--1(pre)<--2(pre)<--3(pre)-->4(cur)-->null(next)
        ListNode curNode = head;
        ListNode nextNode = curNode.next;
        ListNode pre = null;
        while (nextNode != null) {
            curNode.next = pre;
            pre = curNode;
            curNode = nextNode;
            nextNode = nextNode.next;
        }
        curNode.next = pre;
        return curNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode cur = ReverseList(head);
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}