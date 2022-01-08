package datastructure.jianzhioffer;

import subjects.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * @description:
 * @author: dsy
 * @date: 2022/1/8 12:13
 */
public class JZ6 {

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(list);
        return list;
    }

    static ArrayList<Integer> list = new ArrayList<>();

    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if (listNode != null) {
            // 递归到最后一个链表结点
            printListFromTailToHead2(listNode.next);
            // 依次将链表结点元素存入列表
            list.add(listNode.val);
        }
        return list;
    }

    public static ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        return list;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        System.out.println(printListFromTailToHead3(listNode));
    }
}