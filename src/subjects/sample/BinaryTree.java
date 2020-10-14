package subjects.sample;

import java.util.LinkedList;

/**
 * @description: 二叉树
 * @author: dsy
 * @date: 2020/4/10 13:22
 */
public class BinaryTree<T> {

    /**
     * 先序创建二叉树 返回根节点
     */
    public TreeNode<T> createTreePre(LinkedList<T> dataList) {
        TreeNode<T> root = null;
        T data = dataList.removeFirst();
        if (data != null) {
            root = new TreeNode<T>(data, null, null);
            root.leftChild = createTreePre(dataList);
            root.rightChild = createTreePre(dataList);
        }
        return root;
    }


    /**
     * 先序遍历二叉树（递归）
     */
    public void printTreePreRecur(TreeNode root) {
        if (root != null) {
            System.out.println(root.data);
            printTreePreRecur(root.leftChild);
            printTreePreRecur(root.rightChild);
        }
    }

    /**
     * 中序遍历（递归）
     */
    public void printTreeMidRecur(TreeNode root) {
        if (root != null) {
            printTreeMidRecur(root.leftChild);
            System.out.println(root.data);
            printTreeMidRecur(root.rightChild);
        }
    }

    /**
     * 后序遍历（递归）
     */
    public void printTreeLastRecur(TreeNode root) {
        if (root != null) {
            printTreeLastRecur(root.leftChild);
            printTreeLastRecur(root.rightChild);
            System.out.println(root.data);
        }
    }

    /**
     * 先序遍历二叉树（非递归）
     */
    public void printTreePreUnrecur(TreeNode root) {
        //p为当前节点
        TreeNode p = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        //栈不为空时，或者p不为空时循环
        while (p != null || !stack.isEmpty()) {

        }

    }


    /**
     * 树节点类
     */
    class TreeNode<T> {
        public T data;
        public TreeNode<T> leftChild;
        public TreeNode<T> rightChild;

        public TreeNode(T data, TreeNode<T> leftChild, TreeNode<T> rightChild) {
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public TreeNode<T> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(TreeNode<T> leftChild) {
            this.leftChild = leftChild;
        }

        public TreeNode<T> getRightChild() {
            return rightChild;
        }

        public void setRightChild(TreeNode<T> rightChild) {
            this.rightChild = rightChild;
        }
    }
}