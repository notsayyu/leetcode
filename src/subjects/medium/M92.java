package subjects.medium;

import javafx.scene.transform.Shear;
import subjects.ListNode;

import java.util.Objects;

/**
 * @description:
 * @author: dsy
 * @date: 2021/7/4 14:07
 */
public class M92 {
//    public ListNode reverseBetween(ListNode head, int left, int right) {
//        int num = 0;
//        ListNode father = new ListNode(0, head);
//        ListNode cur = father;
//        ListNode pre = father;
//        ListNode su = father;
//        while (Objects.nonNull(cur.next)){
//            num +=1;
//            if(num == left - 1){
//                //记录翻转的前一个位置
//                pre = cur.next;
//            }
//            if(num == right){
//                //翻转的后一个位置，可能为null
//                su = cur.next.next;
//            }
//            if(num >= left && num < right){
//                //在翻转范围内时
//                if(Objects.nonNull(cur.next.next)){
//                    cur.next.next.next = cur.next;
//                }
//            }
//        }
//    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
        // 建议写在 for 循环里，语义清晰
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 第 3 步：切断出一个子链表（截取链表）
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        // 注意：切断链接
        pre.next = null;
        rightNode.next = null;

        // 第 4 步：同第 206 题，反转链表的子区间
        reverseLinkedList(leftNode);

        // 第 5 步：接回到原来的链表中
        pre.next = rightNode;
        leftNode.next = curr;
        return dummyNode.next;
    }

    private void reverseLinkedList(ListNode head) {
        // 也可以使用递归反转一个链表
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }

    public static ListNode reverseBetween2(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }

    public static ListNode reverseBetween3(ListNode head, int left, int right) {
        ListNode father = new ListNode(-1, head);
        //找到left-1位置
        ListNode leftNode = father;
        for (int i = 0; i < left -1; i ++){
            leftNode = leftNode.next;
        }
        ListNode pre = leftNode;
        leftNode = leftNode.next;
        //找到right
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i ++){
            rightNode = rightNode.next;
        }

        //记住right的下一个节点
        ListNode next = rightNode.next;
        //切断leftNode
        pre.next = null;
        rightNode.next = null;
        //翻转leftNode
        reverse(leftNode);

        //组合前后
        pre.next = rightNode;
        leftNode.next = next;
        return father.next;
    }

    /**
     * 头插法
     */
    public static ListNode reverseBetween4(ListNode head, int left, int right) {
        ListNode father = new ListNode(-1, head);
        //找到left-1位置
        ListNode pre = father;
        for (int i = 0; i < left -1; i ++){
            pre = pre.next;
        }

        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i ++){
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return father.next;
    }


        private static ListNode reverse(ListNode node){
        ListNode pre = null;
        ListNode cur = node;
        ListNode next = cur;
        while (Objects.nonNull(cur)){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

        public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        head = reverseBetween4(head, 2,4);
//        head = reverse(head);
        while (Objects.nonNull(head)){
            System.out.println(head.val);
            head = head.next;
        }
    }

}