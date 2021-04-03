package subjects.medium;

/**
 * @description: 旋转列表
 * @author: dsy
 * @date: 2021/4/2 13:53
 */
public class Q61 {

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        //记录下首节点
        ListNode first = head;
        //最后的链表的头节点
        ListNode result;
        int num = 1;
        while (head != null) {
            if (head.next == null) {
                head.next = first;
                break;
            }
            num++;
            head = head.next;
        }
        int step = num - k % num - 1;
        //需要走k - step -1 步找到最后结果的上一个节点，然后result指向结果，上个节点断开

        while (step > 0) {
            first = first.next;
            step--;
        }

        result = first.next;
        first.next = null;
        return result;
    }

    /**
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight2(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        // 计算有效的 k 值：对于与链表长度成整数倍的「旋转」都是没有意义的（旋转前后链表不变）
        int tot = 0;
        ListNode tmp = head;
        while (tmp != null && ++tot > 0) {
            tmp = tmp.next;
        }
        k %= tot;
        if (k == 0) {
            return head;
        }

        // 使用「快慢指针」找到倒数第 k 个节点（新头结点）：slow 会停在「新头结点」的「前一位」，也就是「新尾结点」
        ListNode slow = head, fast = head;
        while (k-- > 0) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // 保存新头结点，并将新尾结点的 next 指针置空
        ListNode nHead = slow.next;
        slow.next = null;
        // 将新链表的前半部分（原链表的后半部分）与原链表的头结点链接上
        fast.next = head;
        return nHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);


        ListNode result = rotateRight2(head, 2);
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
