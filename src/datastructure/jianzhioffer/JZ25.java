package datastructure.jianzhioffer;

import subjects.ListNode;

/**
 * @description:
 * @author: dsy
 * @date: 2022/2/4 10:31
 */
public class JZ25 {
    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else {
            return list1.val < list2.val ? insert(list1, list2) : insert(list2, list1);
        }
    }

    private static ListNode insert(ListNode head, ListNode list) {
        ListNode headNext = head.next;
        ListNode curHead = head;
        while (list != null && headNext != null) {
            if (list.val < headNext.val) {
                //往head里面插入
                curHead.next = list;
                list = list.next;
                curHead.next.next = headNext;
                curHead = curHead.next;
            } else {
                curHead = curHead.next;
                headNext = headNext.next;
            }
        }
        //如果head走完了，list还有，则直接跟在后面
        if (list != null) {
            curHead.next = list;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(3);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        ListNode head = Merge(list1, list2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}