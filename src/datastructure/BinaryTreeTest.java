package datastructure;

/**
 * @description: 二叉树遍历
 * @author: dsy
 * @date: 2021/4/27 23:30
 */
public class BinaryTreeTest {

    public static void main(String[] args) {
        int[] array = {12, 76, 35, 22, 16, 48, 90, 46, 9, 40};
        BinaryTree root;   //创建二叉树
        root = new BinaryTree(array[0]);
        for (int i = 1; i < array.length; i++) {
            //向二叉树中插入数据
            root.insert(root, array[i]);
        }

//        preOrder(root);
        postOrder(root);
    }


    /**
     * 先序遍历 若二叉树为空，则空操作，否则先访问根节点，再先序遍历左子树，最后先序遍历右子树
     */
    public static void preOrder(BinaryTree root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data);
        System.out.print(" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历，若二叉树为空，则空操作，否则先中序遍历左子树，再访问根节点，最后中序遍历右子树。
     */
    public static void inOrder(BinaryTree root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data);
        System.out.print(" ");
        inOrder(root.right);
    }

    /**
     * 后序遍历 若二叉树为空，则空操作，否则先后序遍历左子树访问根节点，再后序遍历右子树，最后访问根节点。
     */
    public static void postOrder(BinaryTree root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data);
        System.out.print(" ");
    }


}
