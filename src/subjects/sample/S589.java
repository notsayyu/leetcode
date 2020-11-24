package subjects.sample;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: dsy
 * @date: 2020/11/24 13:30
 */
public class S589 {
    public static List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        exec(root, list);
        return list;
    }

    private static void exec(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        for (Node node : root.children) {
            exec(node, list);
        }

    }

    public class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
