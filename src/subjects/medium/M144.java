package subjects.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 二叉树：
 * 前序：根-左-右
 * 中序：左-根-右
 * 后序：左-右-根
 * @author: dsy
 * @date: 2020/11/24 13:56
 */
public class M144 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        exec(root, list);
        return list;
    }

    private static void exec(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        exec(root.left, list);
        exec(root.right, list);

    }
}
