package subjects.medium;

import subjects.ListNode;
import subjects.TreeNode;

import java.util.List;

/**
 * @description:
 * @author: dsy
 * @date: 2021/7/5 16:28
 */
public class M109 {
    public TreeNode sortedListToBST(ListNode head) {
        //有序链表，找中位数作为根节点,然后递归处理左右
        return buildTree(head, null);
    }

    private TreeNode buildTree(ListNode left, ListNode right){
        if(left == right){
            return null;
        }
        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    public ListNode getMedian(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

}