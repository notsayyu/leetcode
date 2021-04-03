package subjects.medium;

/**
 * @description: 删除链表的倒数第 N 个结点
 * @author: dsy
 * @date: 2021/4/1 12:18
 */
public class Q19 {

    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        if (null == head) {
            return head;
        }
        if (null == head.next) {
            return null;
        }
        ListNode result = head;
        ListNode l1 = head;
        ListNode l2 = head;
        int step = 0;

        while (head != null) {
            if (step < n) {
                l2 = head.next;
                step++;
            } else {
                l1 = l1.next;
                l2 = head.next;
            }
            head = head.next;
            if (null == l2.next) {
                //走到头了，删除l1,判断是不是首尾
                if (n == step + 1) {
                    //队首
                    return result.next;
                } else if (n == 1) {
                    l1.next = null;
                    return result;
                } else {
                    l1.next = l1.next.next;
                    return result;
                }
            }

        }
        return result;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre, end = pre;
        while (n != 0) {
            start = start.next;
            n--;
        }
        while (start.next != null) {
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);


        ListNode result = removeNthFromEnd2(head, 7);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    //Definition for singly-linked list.
    private static class ListNode {
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
