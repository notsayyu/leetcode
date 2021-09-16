package subjects.medium;

import subjects.TreeNode;

/**
 * @description:
 * @author: dsy
 * @date: 2021/7/9 14:32
 */
public class M114 {
//    public void flatten(TreeNode root) {
//        if(root == null){
//            return;
//        }
//
//        TreeNode newRoot = new TreeNode();
//        genLinkList(root, newRoot);
//        root = newRoot.right;
//    }
//
//    private void genLinkList(TreeNode root, TreeNode newRoot){
//        if (root == null) {
//            return;
//        }
//        genLinkList(root.left, newRoot);
//        newRoot.right = new TreeNode(root.val);
//        genLinkList(root.right, newRoot);
//    }

    public void flatten(TreeNode root) {
        while (root != null) {
            //左子树为 null，直接考虑下一个节点
            if (root.left == null) {
                root = root.right;
            } else {
                // 找左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //将原来的右子树接到左子树的最右边节点
                pre.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                // 考虑下一个节点
                root = root.right;
            }
        }
    }

}