package subjects.medium;

import subjects.ListNode;

import java.util.Objects;

/**
 * @description:
 * @author: dsy
 * @date: 2021/7/3 10:10
 */
public class M86 {
    public static ListNode partition(ListNode head, int x) {
        if(Objects.isNull(head)){
            return head;
        }
        ListNode smallCur = new ListNode();
        ListNode small = smallCur;
        ListNode bigCur = new ListNode();
        ListNode big = bigCur;
        while (Objects.nonNull(head)){
            if(head.val < x){
                smallCur.next = new ListNode(head.val);
                smallCur = smallCur.next;
            }else {
                bigCur.next = new ListNode(head.val);
                bigCur = bigCur.next;
            }
            head = head.next;
        }
        smallCur.next = big.next;
        return small.next;
    }

    /**
     * 找到第一个大于等于x的节点 往它前面按顺序塞后面碰到的小于x的节点
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition2(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mark = new ListNode(0, head);
        ListNode cur1 = mark;
        while (cur1.next != null && cur1.next.val < x) {
            cur1 = cur1.next;
        }
        ListNode firstMaxOrNull = cur1.next;
        ListNode cur2 = cur1;
        while (cur2 != null && cur2.next != null) {
            if (cur2.next.val >= x) {
                cur2 = cur2.next;
            } else {
                cur1.next = cur2.next;
                cur2.next = cur2.next.next;
                cur1 = cur1.next;
//                cur1.next = null;
            }
        }
        cur1.next = firstMaxOrNull;
        return mark.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        head = partition2(head, 3);
        while (Objects.nonNull(head)){
            System.out.println(head.val);
            head = head.next;
        }

    }
}