package datastructure;

/**
 * @description:
 * @author: dsy
 * @date: 2021/4/30 14:35
 */
public class BinaryTree {
    //根节点数据
    int data;
    //左子树
    BinaryTree left;
    //右子树
    BinaryTree right;

    //实例化二叉树类
    public BinaryTree(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    /**
     * 插入节点
     */
    public void insert(BinaryTree root, int data) {
        //判断data与root的数据的大小，小的在左，大的在右
        if (data < root.data) {
            if (root.left == null) {
                //没有就创建
                root.left = new BinaryTree(data);
            } else {
                //有则把左节点作为根节点再进行比较判断
                insert(root.left, data);
            }
        } else {
            if (root.right == null) {
                //没有就创建
                root.right = new BinaryTree(data);
            } else {
                //有则把右节点作为根节点再进行比较判断
                insert(root.right, data);
            }
        }

    }

}
