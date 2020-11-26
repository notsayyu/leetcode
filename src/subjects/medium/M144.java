package subjects.medium;

import java.util.*;

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

    public static void main(String[] args) {
//        Map<String,Object> hashMap = new HashMap<>(16);
//        for(int i=0;i<10000;i++){
//            hashMap.put(i+"",i);
//        }
//        for(Map.Entry entry : hashMap.entrySet()){
//            System.out.println("key:"+entry.getKey()+",value:"+entry.getValue());
//        }

        Map<String, Object> linkedHashMap = new LinkedHashMap<>(16);
        for (int i = 0; i < 10; i++) {
            linkedHashMap.put(i + "", i);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
        }

        System.out.println("============================");

        // 使用的是迭代器 ListIterator
        ListIterator<Map.Entry> i = new ArrayList<Map.Entry>(linkedHashMap.entrySet()).listIterator(linkedHashMap.size());
        while (i.hasPrevious()) {
            Map.Entry entry = i.previous();
            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
        }


    }
}
