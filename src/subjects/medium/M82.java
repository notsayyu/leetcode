package subjects.medium;

import subjects.ListNode;

/**
 * @description:
 * @author: dsy
 * @date: 2021/7/2 17:40
 */
public class M82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode father = new ListNode();
        father.next = head;

        ListNode cur = father;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return father.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode father = new ListNode();
        father.next = head;

        ListNode cur = father;
       while (cur.next != null && cur.next.next != null){
           if(cur.next.val == cur.next.next.val){
               int x = cur.next.val;
               while (cur.next != null && cur.next.val == x){
                   cur.next = cur.next.next;
               }
           }else {
               cur = cur.next;
           }
       }

        return father.next;
    }
}