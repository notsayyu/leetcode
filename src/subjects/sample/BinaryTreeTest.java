package subjects.sample;

import java.util.LinkedList;

/**
 * @description: 二叉树测试方法类
 * @author: dsy
 * @date: 2020/4/10 14:24
 */
public class BinaryTreeTest {

    public static void main(String[] args) {
        BinaryTree<String> binaryTree = new BinaryTree<>();

        //输入ABDH##I##E##CF#J##G##（#用null代替）
        LinkedList<String> tree = new LinkedList<>();
        tree.add("A");
        tree.add("B");
        tree.add("D");
        tree.add("G");
        tree.add(null);
        tree.add(null);
        tree.add("H");
        tree.add(null);
        tree.add(null);
        tree.add(null);
        tree.add("C");
        tree.add("E");
        tree.add(null);
        tree.add("I");
        tree.add(null);
        tree.add(null);
        tree.add("F");
        tree.add(null);
        tree.add(null);

        BinaryTree<String>.TreeNode<String> root = binaryTree.createTreePre(tree);
        System.out.println(root.data);
        System.out.println("========");

        binaryTree.printTreePreRecur(root);
        System.out.println("========");

        binaryTree.printTreeMidRecur(root);
        System.out.println("========");

        binaryTree.printTreeLastRecur(root);
        System.out.println("========");
    }
}
