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
     *            //TODO 疑问：如果是4、3，插入3.5呢  --转为左三之后再处理
     *   红黑树：新增红色节点+上黑下红=排序后中间节点是黑色，两边节点都是红色（3节点）
     *
     * 3、2-3-4树：新增元素+4节点合并（节点中有三个元素）=原来的四节点分类，中间元素升级为父节点，新增元素与剩下的其中一个合并
     *    红黑树：新增红色节点+爷爷节点黑色，父节点和叔叔节点都是黑色=爷爷节点变红，父亲和叔叔变黑，如果爷爷是根节点，则再变黑。
     */
    private void fixAfterPut(RBNode x){
        x.color = RED;
        //本质上父节点是黑色就不需要调整，对应情况就是2，3
        while (x != null && x != root && x.parent.color == RED){
            //1、x的父节点是爷爷的左孩子（左3）
            if(parentOf(x) == leftOf(parentOf(parentOf(x)))){
                //叔叔节点
                RBNode y = rightOf(parentOf(parentOf(x)));
                //第3种情况，存在叔叔节点，不需要旋转，只需要递归处理颜色
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

    /**
     * 删除节点
     */

    public V remove(K key){
        RBNode<K, V> node = getNode(key);
        if(node == null){
            return null;
        }
        V oldValue = node.value;
        deleteNode(node);
        return oldValue;
    }

    /**
     * 删除节点
     * 1、删除叶子节点，直接删除
     * 2、删除的节点有一个子节点，那么用子节点来代替
     * 3、删除的节点有两个子节点，此时需要找到前驱节点或者后驱节点来代替
     */
    private void deleteNode(RBNode node){
        //3、有两个子节点
        if(node.left != null && node.right != null){
            RBNode successor = successor(node);
            node.key = successor.key;
            node.value = successor.value;
            node = successor;
        }

        RBNode replacement = node.left != null ? node.left : node.right;
        if(replacement != null){
            //2、替代节点不为空，有一个子节点
            replacement.parent = node.parent;
            //root是根节点
            if(node.parent == null){
                root = replacement;
            }else if(node == leftOf(parentOf(node))){
                //node是左孩子，所以替代者还是左孩子
                node.parent.left = replacement;
            }else {
                //node是右孩子，所以替代者还是右孩子
                node.parent.right = replacement;
            }
            //node释放脱离,帮助gc
            node.left = node.right = node.parent = null;

            //替换完之后需要调整平衡
            if(node.color == BLACK){
                //需要调整，这种情况一定是红色（替代节点一定是红色，此时只需要变色）
                fixAfterRemove(replacement);
            }
        }else if(node.parent == null){
            //删除节点是根节点
            root = null;

        }else {
            //1、叶子节点
            //先调整（先删的话没有节点可依靠调整了）
            if(node.color == BLACK){
                fixAfterRemove(node);
            }
            //再删除
            if(node.parent != null){
                if(node == leftOf(parentOf(node))){
                    node.parent.left = null;
                }else {
                    node.parent.right = null;
                }
                node.parent = null;
            }

        }

    }

    /**
     * 删除后调整
     */
    private void fixAfterRemove(RBNode x){
        while (x != root && colorOf(x) == BLACK){
            //x是左孩子的情况
            if(x == leftOf(parentOf(x))){

                //兄弟节点
                RBNode rnode = rightOf(parentOf(x));
                //判断此时兄弟节点是否是真正的兄弟节点
                if(colorOf(rnode) == RED) {
                    setColor(rnode, BLACK);
                    setColor(parentOf(x), RED);
                    leftRotate(parentOf(x));
                    rnode = rightOf(parentOf(x));
                }
                //情况三：找兄弟借，兄弟没得借
                if(colorOf(leftOf(rnode)) == BLACK && colorOf(rightOf(rnode)) == BLACK){
                    setColor(rnode, RED);
                    x = parentOf(x);

                }else {
                    //情况二：找兄弟借，兄弟有的借

                    //分两种小情况，兄弟节点本来是3节点还是4节点的情况
                    if (colorOf(rightOf(rnode)) == BLACK) {
                        //右孩子为空
                        setColor(leftOf(rnode), BLACK);
                        setColor(rnode, RED);
                        rightRotate(rnode);
                        rnode = rightOf(parentOf(x));
                    }
                    setColor(rnode, colorOf(parentOf(x)));
                    setColor(parentOf(x), BLACK);
                    setColor(rightOf(rnode), BLACK);
                    leftRotate(parentOf(x));
                    x = root;
                }

            }else {
                //x是右孩子的情况
                //兄弟节点
                RBNode rnode = leftOf(parentOf(x));
                //判断此时兄弟节点是否是真正的兄弟节点
                if(colorOf(rnode) == RED) {
                    setColor(rnode, BLACK);
                    setColor(parentOf(x), RED);
                    rightRotate(parentOf(x));
                    rnode = leftOf(parentOf(x));
                }
                //情况三：找兄弟借，兄弟没得借
                if(colorOf(rightOf(rnode)) == BLACK && colorOf(leftOf(rnode)) == BLACK){
                    setColor(rnode, RED);
                    x = parentOf(x);

                }else {
                    //情况二：找兄弟借，兄弟有的借

                    //分两种小情况，兄弟节点本来是3节点还是4节点的情况
                    if (colorOf(leftOf(rnode)) == BLACK) {
                        //右孩子为空
                        setColor(rightOf(rnode), BLACK);
                        setColor(rnode, RED);
                        leftRotate(rnode);
                        rnode = leftOf(parentOf(x));
                    }
                    setColor(rnode, colorOf(parentOf(x)));
                    setColor(parentOf(x), BLACK);
                    setColor(rightOf(rnode), BLACK);
                    rightRotate(parentOf(x));
                    x = root;
                }
            }

        }
        //情况一：替代节点是红节点，则直接染黑，补偿删除的黑色节点，这样红黑树依然平衡
        setColor(x, BLACK);
    }


    /**
     * 查询节点
     */
    private RBNode getNode(K key){
        //TODO key == null
        RBNode node = root;
        while (node != null){
            int cmp = key.compareTo((K) node.key);
            if(cmp < 0){
                node = node.left;
            }else if(cmp > 0){
                node = node.right;
            }else {
                return node;
            }
        }
        return  null;
    }


    /**
     * 找前驱节点
     */
    private RBNode predecessor(RBNode node){
        if(node == null){
            return null;
        }else if(node.left != null){
            RBNode p = node.left;
            while (p.right != null){
                p = p.right;
            }
            return p;
        }else {
            RBNode p = node.parent;
            RBNode ch = node;
            while(p != null && ch == p.left){
                ch = p;
                p = p.parent;
            }
            return p;
        }

    }

    /**
     * 找后驱节点
     */
    private RBNode successor(RBNode node){
        if(node == null){
            return null;
        }else if(node.right != null){
            RBNode p = node.right;
            while (p.left != null){
                p = p.left;
            }
            return p;
        }else {
            RBNode p = node.parent;
            RBNode ch = node;
            while(p != null && ch == p.right){
                ch = p;
                p = p.parent;
            }
            return p;
        }

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
