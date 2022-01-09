package datastructure.jianzhioffer;

import subjects.TreeNode;

import java.util.Arrays;
import java.util.HashMap;

public class JZ7 {
    public TreeNode reConstructBinaryTree(int [] pre, int [] vin) {
        // 判断特殊情况
        if (pre == null || pre.length == 0 || vin == null || vin.length == 0) {
            return null;
        }
        // key ： 中序遍历元素的值；
        // value ： 中序遍历元素的值 对应的 下标
        // 可以以O(1)的时间复杂度找到元素在中序遍历中对应的下标
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < vin.length; i++) {
            map.put(vin[i], i);
        }

        // 返回在 pre[0...pre.length-1] , in[0, in.length-1] 范围上建立二叉树的根节点
        return process(pre, 0, pre.length - 1,
                0, vin.length - 1,
                map);
    }

    /**
     * @param pre 前序遍历的数组
     * @param pL  使用到的 前序遍历的数组 的左边界，闭区间
     * @param pR  使用到的 前序遍历的数组 的右边界，闭区间
     * @param inL 使用到的 中序遍历的数组 的左边界，闭区间
     * @param inR 使用到的 中序遍历的数组 的右边界，闭区间
     * @param map 方便找到元素在中序遍历中对应的下标 需要的 数据结构
     * @return 在使用到的 前序遍历数组、中序遍历数组中；生成该范围内的二叉树，返回这个二叉树的 根节点
     */
    public TreeNode process(int[] pre, int pL, int pR,
                            int inL, int inR,
                            HashMap<Integer, Integer> map) {
        // 越界情况，没有二叉树存在，直接返回 null
        if (pL > pR || inL > inR) {
            return null;
        }
        // 只有一个元素，就是根节点，直接返回
        if (pL == pR || inL == inR) {
            return new TreeNode(pre[pL]);
        }
        // 前序遍历的第一个元素就是 根节点
        TreeNode root = new TreeNode(pre[pL]);
        // 找到 根节点在 中序遍历数组里的 下标
        int inIndex = map.get(pre[pL]);
        // 在有效的中序遍历范围里， 根节点左边的元素 都是属于 根节点的左子树
        int leftTreeSize = inIndex - inL;
        // 在左子树的有效范围里，生成左子树
        // 前序遍历为：[8，3，6，7，9] ， 中序遍历为：[3，6，8，9，7]

        root.left = process(pre, pL + 1, pL + leftTreeSize,
                inL, inIndex - 1,
                map);
        // 在右子树的有效范围里，生成右子树
        root.right = process(pre, pL + leftTreeSize + 1, pR,
                inIndex + 1, inR,
                map);
        return root;
    }

    public TreeNode reConstructBinaryTree2(int [] pre,int [] vin) {
        if (pre.length == 0 || vin.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        // 在中序中找到前序的根
        for (int i = 0; i < vin.length; i++) {
            //前序遍历为：[8，3，6，7，9] ， 中序遍历为：[3，6，8，9，7]
            if (vin[i] == pre[0]) {
                // 左子树，注意 copyOfRange 函数，左闭右开
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(vin, 0, i));
                // 右子树，注意 copyOfRange 函数，左闭右开
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(vin, i + 1, vin.length));
                break;
            }
        }
        return root;
    }

}
