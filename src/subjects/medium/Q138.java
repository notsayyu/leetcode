package subjects.medium;

import java.util.HashMap;

/**
 * @description: 复制带随机指针的链表
 * @author: dsy
 * @date: 2021/4/3 14:48
 */
public class Q138 {
    private HashMap<Node, Node> MyMap = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (MyMap.containsKey(head)) {
            return MyMap.get(head);
        }
        Node root = new Node(head.val);
        MyMap.put(head, root);
        root.next = copyRandomList(head.next);
        root.random = copyRandomList(head.random);
        return root;
    }


    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            next = null;
            random = null;
        }
    }
}
