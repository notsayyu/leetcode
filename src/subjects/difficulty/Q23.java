package subjects.difficulty;

import java.util.*;

/**
 * @description: 合并K个升序链表
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * @author: dsy
 * @date: 2021/4/13 22:44
 */
public class Q23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; ++i) {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;

    }

    /**
     * 合并两个链表
     *
     * @param a
     * @param b
     * @return
     */
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
//
//        ListNode listNode1 = new ListNode(1);
//        listNode1.next = new ListNode(2);
//        listNode1.next.next = new ListNode(3);
//        listNode1.next.next.next = new ListNode(4);
//
//        ListNode[] lists = new ListNode[]{listNode, listNode1};
//
//        ListNode head = mergeKLists3(lists);

        ListNode reversal = reversal(listNode);

        Map<String, String> map = new HashMap();
        map.put("name", "小明");
        System.out.println(map);


        while (reversal != null) {
            System.out.println(reversal.val);
            reversal = reversal.next;
        }
    }

    /**
     * 一、K 指针：K 个指针分别指向 K 条链表
     * 1. 每次 O(K)O(K) 比较 K个指针求 min, 时间复杂度：O(NK)O(NK)
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists2(ListNode[] lists) {
        int k = lists.length;
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (true) {
            ListNode minNode = null;
            int minPointer = -1;
            for (int i = 0; i < k; i++) {
                if (lists[i] == null) {
                    continue;
                }
                if (minNode == null || lists[i].val < minNode.val) {
                    minNode = lists[i];
                    minPointer = i;
                }
            }
            if (minPointer == -1) {
                break;
            }
            tail.next = minNode;
            tail = tail.next;
            lists[minPointer] = lists[minPointer].next;
        }
        return dummyHead.next;
    }

    public static ListNode mergeKLists3(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v.val));
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            tail.next = minNode;
            tail = minNode;
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }

        return dummyHead.next;
    }

    public ListNode merge2List(ListNode node1, ListNode node2) {
        if (node1 == null || node2 == null) {
            return node1 == null ? node2 : node1;
        }
        ListNode result = new ListNode(0);
        ListNode tail = result;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                tail.next = node1;
                node1 = node1.next;
            } else {
                tail.next = node2;
                node2 = node2.next;
            }
            tail = tail.next;
        }
        tail.next = node1 == null ? node2 : node1;

        return result.next;
    }

    /**
     * 反转链表
     *
     * @param listNode
     * @return
     */
    public static ListNode reversal(ListNode listNode) {
        if (null == listNode) {
            return listNode;
        }
        ListNode pre = null;
        ListNode cur = listNode;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;

    }


    public static class ListNode {
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
