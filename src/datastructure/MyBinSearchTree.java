package datastructure;

/**
 * @description: 二叉搜素树
 * @author: dsy
 * @date: 2021/5/11 14:25
 */
public class MyBinSearchTree<E extends Comparable<E>> {
    // 根
    private TreeNode<E> root;

    // 默认构造函数
    public MyBinSearchTree() {
    }

    //二叉查找树的搜索
    public boolean search(E e) {
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }

    //二叉树的插入
    public boolean insert(E e) {
        //如果root是null，则作为根节点
        if (null == root) {
            root = createNewNode(e);
        } else {
            //从根节点遍历，先记录父节点，最后再比较大小
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (null != current) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else {
                    return false;
                }
            }
            //找到父节点之后，根据值与父节点的大小比较进行设置
            if (e.compareTo(parent.element) < 0) {
                parent.left = createNewNode(e);
            } else {
                parent.right = createNewNode(e);
            }

        }
        return true;
    }

    //删除节点1
    public boolean delete1(E e) {
        //一共3种情况 一、只有没有子节点；二、只有一个节点（左或者右）；三、两个子节点
        //两个子节点的情况可以通过与左子树最大值或者右子树最小值替换转化为前两种情况
        //parent-要删除的节点的父节点/替换后要删除的节点的父节点  delNode-要删除的节点
        TreeNode<E> parent = null;
        TreeNode<E> delNode = root;
        //先找到所在的位置
        while (null != delNode) {
            if (e.compareTo(delNode.element) < 0) {
                parent = delNode;
                delNode = delNode.left;
            } else if (e.compareTo(delNode.element) > 0) {
                parent = delNode;
                delNode = delNode.right;
            } else {
                break;
            }
        }
        //先是第三种情况
        if (delNode.left != null && delNode.right != null) {
            TreeNode<E> replaceNode = getReplaceNode(delNode);
            parent = getReplaceNodeParent(root, delNode);
            if (replaceNode == null) {
                throw new IllegalArgumentException("param error");
            }
            delNode.element = replaceNode.element;
            delNode = replaceNode;
        }
        //现在转化为删除最下面的节点了，有一个子节点或者没有子节点
        TreeNode<E> child;
        if (delNode.left != null) {
            child = delNode.left;
        } else {
            child = delNode.right;
        }
        if (parent == null) {
            //根节点设置为子节点
            //按照前面逻辑，根只有一个或者没有节点，所以直接赋值 child 即可
            root = child;
        } else if (true) {

        }

        return false;
    }

    //删除节点2

    /**
     * 要在二叉查找树中删除一个元素，首先需要定位包含该元素的节点，以及它的父节点。假设current指向二叉查找树中包含该元素的节点，而parent指向current节点的父节点，
     * current节点可能是parent节点的左孩子，也可能是右孩子。这里需要考虑两种情况：
     * <p>
     * current节点没有左孩子，那么只需要将patent节点和current节点的右孩子相连。
     * current节点有一个左孩子，假设rightMost指向包含current节点的左子树中最大元素的节点，而parentOfRightMost指向rightMost节点的父节点。
     * 那么先使用rightMost节点中的元素值替换current节点中的元素值，将parentOfRightMost节点和rightMost节点的左孩子相连，然后删除rightMost节点。
     */
    public boolean delete2(E e) {
        TreeNode<E> parent = null;
        TreeNode<E> current = root;

        // 找到要删除的节点的位置
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else {
                break;
            }
        }
        // 没找到要删除的节点
        if (current == null) {
            return false;
        }
        //考虑第一种情况
        if (current.left == null) {
            if (parent == null) {
                root = current.right;
            } else {
                if (e.compareTo(parent.element) < 0) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            }
        } else {
            //考虑第二种情况
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;
            // 找到左子树中最大的元素节点
            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }

            // 替换
            current.element = rightMost.element;
            // parentOfRightMost和rightMost左孩子相连
            if (parentOfRightMost.right == rightMost) {
                //左子树最大的节点如果是右节点，那rightMost是不会再有右节点了，所以直接连接左节点
                parentOfRightMost.right = rightMost.left;
            } else {
                //可能左子树的节点都只有左孩子，所以直接链接左孩子
                parentOfRightMost.left = rightMost.left;
            }
        }
        return true;
    }

    private TreeNode<E> getReplaceNodeParent(TreeNode<E> root, TreeNode<E> replaceNode) {
        TreeNode<E> parent = root;
        while (parent.left != null) {
            if (parent.left == replaceNode) {
                break;
            }
            parent = parent.left;
        }
        return parent;
    }

    private TreeNode<E> getReplaceNode(TreeNode<E> delNode) {
        TreeNode<E> replaceNode = delNode;
        if (replaceNode.left != null) {
            replaceNode = replaceNode.left;
        }
        return replaceNode;
    }

    // 二叉树的节点
    class TreeNode<E extends Comparable<E>> {

        E element;
        TreeNode<E> left;
        TreeNode<E> right;

        public TreeNode(E e) {
            element = e;
        }
    }

    //创建新的节点
    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }
}
