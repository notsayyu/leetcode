package subjects.medium;


import subjects.ListNode;

import java.util.Objects;

/**
 * @description:
 * @author: dsy
 * @date: 2021/7/2 15:52
 */
public class M24 {
    public static ListNode swapPairs(ListNode head) {
        if(Objects.isNull(head)){
            return null;
        }
        ListNode father = new ListNode();
        father.next = head;
        ListNode node = father;
        ListNode first = head;
        ListNode next = head.next;
        ListNode nn = null;
        while (Objects.nonNull(first)){
            if(Objects.isNull(next)){
                break;
            }
            nn = next.next;

            father.next = next;
            next.next = first;
            first.next = nn;
            father = first;
            first = nn;
            if(Objects.nonNull(first)){
                next = first.next;
            }

        }
        return node.next;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        head = swapPairs(head);

        while (Objects.nonNull(head)){
            System.out.println(head.val);
            head = head.next;
        }
    }
}