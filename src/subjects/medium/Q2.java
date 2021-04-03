package subjects.medium;

/**
 * @description: 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 * @author: dsy
 * @date: 2021/3/31 21:54
 */
public class Q2 {
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int next = 0;
        int val = l1.val + l2.val;
        ListNode result = new ListNode();
        result.val = val % 10;
        next = val / 10;
        result.next = add(l1.next, l2.next, next, result.next);
        return result;
    }

    //计算下一个节点
    private static ListNode add(ListNode l1, ListNode l2, int next, ListNode result) {
        int val;
        if (null == l1 && null != l2) {
            val = l2.val + next;
            l2.val = val % 10;
            result = l2;
            next = val / 10;
            result.next = add(l1, l2.next, next, result.next);
        } else if (null != l1 && null == l2) {
            val = l1.val + next;
            l1.val = val % 10;
            result = l1;
            next = val / 10;
            result.next = add(l1.next, l2, next, result.next);
        } else if (null == l1 && null == l2) {
            if (next > 0) {
                result = new ListNode(next);
            } else {
                result = null;
            }
        } else {
            val = l1.val + l2.val + next;
            l1.val = val % 10;
            result = l1;
            next = val / 10;
            result.next = add(l1.next, l2.next, next, result.next);
        }

        return result;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);


        ListNode result = addTwoNumbers1(l1, l2);
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
