package subjects.difficulty;

/**
 * @description: 25. K 个一组翻转链表
 * @author: dsy
 * @date: 2021/4/1 15:57
 */
public class Q25 {
    public ListNode reverseKGroup1(ListNode head, int k) {
        int n = k;
        //前一个节点指针
        ListNode preNode = null;
        //当前节点指针
        ListNode curNode = head;
        //下一个节点指针
        ListNode nextNode = null;
        //第二轮开始的pre节点
        ListNode nextPre = head;
        //遍历查看距离
        ListNode stepNode = head;


        while (stepNode != null) {
            //最外层是遍历整个链表
            if (n == 0) {
                //此时当前节点不是null，并且到达反转步数，对当前这段进行反转
                int x = k;
                while (k > 0) {
                    if (x == k) {
                        nextPre = head;
                    }
                    //nextNode 指向下一个节点
                    nextNode = curNode.next;
                    //将当前节点next域指向前一个节点
                    curNode.next = preNode;
                    //preNode 指针向后移动
                    preNode = curNode;
                    //curNode指针向后移动
                    curNode = nextNode;
                    k--;
                }


            }

            n--;

        }
        return null;
    }

    /**
     * 反转链表,反转前n个
     *
     * @param head
     * @return
     */
    public static ListNode reverseListNode(ListNode head) {
        //单链表为空或只有一个节点，直接返回原单链表
        if (head == null || head.next == null) {
            return head;
        }
        //前一个节点指针
        ListNode preNode = null;
        //当前节点指针
        ListNode curNode = head;
        //下一个节点指针
        ListNode nextNode = null;

        while (curNode != null) {
            //nextNode 指向下一个节点
            nextNode = curNode.next;
            //将当前节点next域指向前一个节点
            curNode.next = preNode;
            //preNode 指针向后移动
            preNode = curNode;
            //curNode指针向后移动
            curNode = nextNode;
        }

        return preNode;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        //定义一个假的节点。
        ListNode dummy = new ListNode(0);
        //假节点的next指向head。
        // dummy->1->2->3->4->5
        dummy.next = head;
        //初始化pre和end都指向dummy。pre指每次要翻转的链表的头结点的上一个节点。end指每次要翻转的链表的尾节点
        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            //循环k次，找到需要翻转的链表的结尾,这里每次循环要判断end是否等于空,因为如果为空，end.next会报空指针异常。
            //dummy->1->2->3->4->5 若k为2，循环2次，end指向2
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            //如果end==null，即需要翻转的链表的节点数小于k，不执行翻转。
            if (end == null) {
                break;
            }
            //先记录下end.next,方便后面链接链表
            ListNode next = end.next;
            //然后断开链表
            end.next = null;
            //记录下要翻转链表的头节点
            ListNode start = pre.next;
            //翻转链表,pre.next指向翻转后的链表。1->2 变成2->1。 dummy->2->1
            pre.next = reverse(start);
            //翻转后头节点变到最后。通过.next把断开的链表重新链接。
            start.next = next;
            //将pre换成下次要翻转的链表的头结点的上一个节点。即start
            pre = start;
            //翻转结束，将end置为下次要翻转的链表的头结点的上一个节点。即start
            end = start;
        }
        return dummy.next;


    }

    //链表翻转
    // 例子：   head： 1->2->3->4
    public ListNode reverse(ListNode head) {
        //单链表为空或只有一个节点，直接返回原单链表
        if (head == null || head.next == null) {
            return head;
        }
        //前一个节点指针
        ListNode preNode = null;
        //当前节点指针
        ListNode curNode = head;
        //下一个节点指针
        ListNode nextNode = null;
        while (curNode != null) {
            //nextNode 指向下一个节点,保存当前节点后面的链表。
            nextNode = curNode.next;
            //将当前节点next域指向前一个节点   null<-1<-2<-3<-4
            curNode.next = preNode;
            //preNode 指针向后移动。preNode指向当前节点。
            preNode = curNode;
            //curNode指针向后移动。下一个节点变成当前节点
            curNode = nextNode;
        }
        return preNode;

    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);


        ListNode result = reverseListNode(head);
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
