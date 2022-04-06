package datastructure.jianzhioffer;

import subjects.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: dsy
 * @date: 2022/2/4 13:50
 */
public class JZ26 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return isSame(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    public boolean HasSubtree2(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (isSame(cur, root2)) {
                return true;
            } else {
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return false;
    }


    public boolean isSame(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        return root1.val == root2.val
                && isSame(root1.left, root2.left)
                && isSame(root1.right, root2.right);
    }
}