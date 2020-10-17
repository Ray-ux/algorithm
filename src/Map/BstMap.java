package Map;

/**
 * @author 张烈文
 */
public class BstMap<K extends Comparable<K>,V>  implements Map<K,V> {


    @Override
    public void add(K key, V value) {
        root=add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            node = new Node(key, value);
            size++;
            return node;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        }else{
            node.value = value;
        }

        return node;
    }

    /**
     * 删除任意一个节点
     * @param key
     * @return
     */
    @Override
    public V remove(K key) {

        Node delNode = getNode(root, key);

        if (delNode != null) {
            root = remove(root, key);
            return delNode.value;
        }
        return null;
    }

    /**
     * 删除任意一个节点
     * @param node
     * @param key
     * @return
     */
    private Node remove(Node node, K key) {

        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            node.left=remove(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            node.right=remove(node.right, key);
        }else{

//            当要删除节点左子树为空时
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

//            当要删除节点右子树为空时
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

//            当删除节点左右子树都不为空时
            Node res = getMin(node.right);
            res.right = removeMin(node.right);
            res.left = node.left;
            node.left = node.right = null;
            return res;

        }
        return node;
    }


    /**
     * 获取该节点下的最小节点
     * @param node
     * @return
     */
    private Node getMin(Node node) {
        if (node.left != null) {
            return getMin(node.left);
        }
        return node;
    }

    public V removeMin() {
        root = removeMin(root);
        return getMin(root).value;
    }
    /**
     * 删除当前节点下的最小节点
     *
     * @return
     */
    private Node removeMin(Node node) {


        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        System.out.println(node.value);

            node.left = removeMin(node.left);

        return node;

    }


    /**
     * 判断是否存在传入节点所在的key
     * @param key
     * @return
     */
    @Override
    public boolean contains(K key) {
        Node node = getNode(root, key);
        return node!=null;
    }


    /**
     * 获取当前key下的node节点
     * @param key
     * @return
     */
    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            return node.value;
        }
        return null;
    }

    /**
     *该方法用于获取node节点
     * 可在判断节点是否存在和获取节点元素时使用
     * @param node
     * @param key
     * @return
     */
    private Node getNode(Node node, K key) {

        if (node == null) {
            return null;
        }
        if ((key.compareTo(node.key) < 0)) {
            return getNode(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            return getNode(node.right, key);
        }else{
            return node;
        }
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + "doesn't exist!");
        }
        node.value = newValue;

    }

    public void preOrder() {
        preOrder(root);
    }
    private void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.value);
            preOrder(node.left);
            preOrder(node.right);
        }
        return;

    }



    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private class Node{
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public Node() {
            this(null, null);
        }

    }

    private Node root;
    private int size;

    public BstMap() {
        root = null;
        size = 0;
    }

    public V getR() {
        return root.right.value;
    }
    public V getL() {
        return root.left.right.value;
    }
}
