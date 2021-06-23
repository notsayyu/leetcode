package datastructure;

/**
 * @description: 红黑树
 * @author: dsy
 * @date: 2021/6/17 14:36
 */
public class RBTree<K extends Comparable<K>, V> {
    private static final boolean RED = false;
    private static final boolean BLACK = true;
    private RBNode root;

    public RBNode getRoot() {
        return root;
    }

    public void setRoot(RBNode root) {
        this.root = root;
    }

    /**
     * 左旋
     *     pf                         pf
     *     /                          /
     *    p                         pr(r)
     *   / \                        / \
     *  pl  pr(r)         ==>         p   rr
     *      / \                   / \
     *      rl rr                pl  rl
     */
    private void leftRotate(RBNode p) {
        if(p != null){
            RBNode r = p.right;
            p.right = r.left;
            if(r.left != null){
                r.left.parent = p;
            }

            r.parent = p.parent;
            if(p.parent == null){
                root = r;
            }else if(p.parent.left == p){
                p.parent.left = r;
            }else {
                p.parent.right = r;
            }

            r.left = p;
            p.parent = r;
        }
    }

    /**
     * 右旋
     *    pf                         pf
     *    \                          \
     *    p                         pl(l)
     *   / \                        / \
     * pl(l) pr         ==>       ll   p
     * / \                           / \
     * ll lr                        lr pr
     */
    private void rightRotate(RBNode p) {
        if(p != null){
            RBNode l = p.left;
            p.left = l.right;
            if(l.right != null){
                l.right.parent = p;
            }

            l.parent = p.parent;
            if(p.parent == null){
                root = l;
            }else if(p.parent.left == p){
                p.parent.left = l;
            }else {
                p.parent.right = l;
            }

            l.right = p;
            p.parent = l;
        }
    }

    /**
     * 新增
     */
    public void put(K key, V value){
        RBNode t = root;
        //如果是根节点
        if(t == null){
            root = new RBNode(key, value == null? key : value, null);
        }

        //寻找插入位置，定义一个双亲指针
        int cmp;
        RBNode parent;
        if(key == null){
            throw new NullPointerException("key is null!");
        }
        //沿着根节点寻找插入位置
        do{
            parent = t;
            cmp = key.compareTo((K) t.key);
            if(cmp < 0){
                t = t.left;
            }else if(cmp > 0){
                t = t.right;
            }else {
                //key存在则覆盖并返回
                t.setValue(value == null ? key : value);
                return;
            }

        }while (t != null);

        //找到了存放位置的父节点
        RBNode<K, Object> e = new RBNode<>(key, value == null ? key : value, parent);
        //比较判断是左孩子还是右孩子
        if(cmp < 0){
            parent.left = e;
        }else {
            parent.right = e;
        }

        //调整数结构
        fixAfterPut(e);

    }

    /**
     * 1、2-3-4树：新增元素+2节点合并（节点中只有一个元素）=3节点（节点中有两个元素）
     *    红黑树：新增一个红色节点+黑色父亲节点=上黑下红（2节点）------------不要调整
     *
     * 2、2-3-4树：新增元素+3节点合并（节点中有两个元素）=4节点（节点中有三个元素）
     *            这里有四种小情况（左3，右3，还有两种左中右不需要调整）-----左3，右3需要调整，其他两个不需要调整
     *            //TODO 疑问：如果是4、3，插入3.5呢
     *   红黑树：新增红色节点+上黑下红=排序后中间节点是黑色，两边节点都是红色（3节点）
     *
     * 3、2-3-4树：新增元素+4节点合并（节点中有三个元素）=原来的四节点分类，中间元素升级为父节点，新增元素与剩下的其中一个合并
     *    红黑树：新增红色节点+爷爷节点黑色，父节点和叔叔节点都是黑色=爷爷节点变红，父亲和叔叔边黑，如果爷爷是根节点，则再变黑。
     */
    private void fixAfterPut(RBNode x){
        x.color = RED;
        //本质上父节点是黑色就不需要调整，对应情况就是2，3
        while (x != null && x != root && x.parent.color == RED){
            //1、x的父节点是爷爷的左孩子（左3）
            if(parentOf(x) == leftOf(parentOf(parentOf(x)))){
                //叔叔节点
                RBNode y = rightOf(parentOf(parentOf(x)));
                //第三中情况
                if(colorOf(y) == RED){
                    //设置父亲和叔叔黑，爷爷红，爷爷如果是根节点则再设置黑
                    setColor(parentOf(x), BLACK);
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    //如果爷爷的父亲也是红色，则双红，进行递归处理
                    x = parentOf(parentOf(x));

                }else {
                    //第2种情况

                    //如果左三的时候，x是父节点的右孩子，则需要转化为左三再处理
                    if(x == rightOf(parentOf(x))){
                        x = parentOf(x);
                        leftRotate(x);
                    }

                    //父亲变黑
                    setColor(parentOf(x), BLACK);
                    //爷爷变红
                    setColor(parentOf(parentOf(x)), RED);
                    //根据爷爷节点右旋转
                    rightRotate(parentOf(parentOf(x)));
                }

            }else {
                //右3
                    //叔叔节点
                    RBNode y = leftOf(parentOf(parentOf(x)));
                    //第三中情况
                    if(colorOf(y) == RED){
                        //设置父亲和叔叔黑，爷爷红，爷爷如果是根节点则再设置黑
                        setColor(parentOf(x), BLACK);
                        setColor(y, BLACK);
                        setColor(parentOf(parentOf(x)), RED);
                        //如果爷爷的父亲也是红色，则双红，进行递归处理
                        x = parentOf(parentOf(x));
                    }else {
                        //第2种情况

                        //右三的时候，x是父节点的左孩子，则需要转化为右三再处理
                        if(x == leftOf(parentOf(x))){
                            x = parentOf(x);
                            rightRotate(x);
                        }

                        //父亲变黑
                        setColor(parentOf(x), BLACK);
                        //爷爷变红
                        setColor(parentOf(parentOf(x)), RED);
                        //根据爷爷节点左旋转
                        leftRotate(parentOf(parentOf(x)));
                    }


            }
        }

        root.color = BLACK;
    }

    private RBNode parentOf(RBNode node){
        return node == null ? null : node.parent;
    }

    private RBNode leftOf(RBNode node){
        return node == null ? null : node.left;
    }

    private RBNode rightOf(RBNode node){
        return node == null ? null : node.right;
    }

    private boolean colorOf(RBNode node){
        //注意：很多判断黑色的节点可能是null
        return node == null ? BLACK : node.color;
    }

    private void setColor(RBNode node, boolean color){
        if(node != null){
            node.color = color;
        }
    }


    static class RBNode<K extends Comparable<K>, V> {
        private RBNode parent;
        private RBNode left;
        private RBNode right;
        private boolean color;
        private K key;
        private V value;

        public RBNode(RBNode parent, RBNode left, RBNode right, boolean color, K key, V value) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.color = color;
            this.key = key;
            this.value = value;
        }

        public RBNode(K key, V value, RBNode parent) {
            this.parent = parent;
            this.key = key;
            this.value = value;
            color = BLACK;
        }

        public RBNode() {
        }

        public RBNode getParent() {
            return parent;
        }

        public void setParent(RBNode parent) {
            this.parent = parent;
        }

        public RBNode getLeft() {
            return left;
        }

        public void setLeft(RBNode left) {
            this.left = left;
        }

        public RBNode getRight() {
            return right;
        }

        public void setRight(RBNode right) {
            this.right = right;
        }

        public boolean isColor() {
            return color;
        }

        public void setColor(boolean color) {
            this.color = color;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
