package datastructure.jianzhioffer;

import subjects.ListNode;

/**
 * @description:
 * @author: dsy
 * @date: 2022/2/3 09:03
 */
public class JZ22 {
    public static ListNode FindKthToTail(ListNode pHead, int k) {
        // write code here
        int kNum = 0;
        int curNum = 0;
        ListNode kNode = pHead;
        while (pHead != null) {
            if ((curNum - kNum) >= k) {
                kNum++;
                kNode = kNode.next;
            }
            curNum++;
            pHead = pHead.next;
        }
        if ((curNum - kNum) < k) {
            return null;
        } else {
            return kNode;
        }
    }

    public static ListNode FindKthToTail2(ListNode pHead, int k) {
        // write code here
        if (pHead == null) {
            return pHead;
        }
        ListNode first = pHead;
        ListNode second = pHead;
        //第一个指针先走k步
        while (k-- > 0) {
            if (first == null) {
                return null;
            }
            first = first.next;
        }
        //然后两个指针在同时前进
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode kNode = FindKthToTail(head, 1);
        while (kNode != null) {
            System.out.println(kNode.val);
            kNode = kNode.next;
        }
    }
}