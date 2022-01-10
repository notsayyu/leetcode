package datastructure.jianzhioffer;

import subjects.TreeLinkNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @description:
 * @author: dsy
 * @date: 2022/1/10 13:13
 */
public class JZ8 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        //先找出根节点
        TreeLinkNode root = pNode;
        while (root.next != null) {
            root = root.next;
        }
        //中序输出值到集合
        List<TreeLinkNode> list = new ArrayList<>();
        inOrder(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) == pNode) {
                return list.get(i + 1);
            }
        }
        return null;
    }

    private void inOrder(TreeLinkNode root, List<TreeLinkNode> list) {
        if (Objects.isNull(root)) {
            return;
        }
        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);
    }

    /**
     * 假设中序遍历为1234567
     * 1 => 2 // 显然下一结点是 1 的父亲结点
     * 2 => 3 // 下一节点是当前结点右孩子的左孩子结点，其实你也应该想到了，应该是一直到左孩子为空的那个结点
     * 3 => 4 // 跟 2 的情况相似，当前结点右孩子结点的左孩子为空的那个结点
     * 4 => 5 // 5 是父亲结点 3 的父亲结点，发现和1有点像，因为 1，3,同样是父亲结点的左孩子
     * 5 => 6 // 跟 4=>5 一样的道理
     * 6 => 7 // 跟 3=>4 一样的道理
     * 7 => null // 因为属于最尾结点
     */
    public TreeLinkNode GetNext2(TreeLinkNode pNode) {
        if (Objects.isNull(pNode)) {
            return null;
        }
        //属于2、3、6类
        if (Objects.nonNull(pNode.right)) {
            pNode = pNode.right;
            while (Objects.nonNull(pNode.left)) {
                pNode = pNode.left;
            }
            return pNode;
        }

        //属于1、4、5
        while (Objects.nonNull(pNode.next)) {
            TreeLinkNode root = pNode.next;
            if (root.left == pNode) {
                return root;
            }
            pNode = pNode.next;
        }
        return null;
    }
}