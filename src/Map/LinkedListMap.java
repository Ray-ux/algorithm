package Map;

/**
 * @author 张烈文
 */
public class LinkedListMap<K, V> implements Map<K, V> {

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    /**
     * 辅助函数，用于用当传入key时来判断该映射结构中是否含有该节点
     * 如果有则返回该节点无则返回null
     * @param key
     * @return
     */
    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public void add(K key, V value) {
        Node cur = getNode(key);
        if (cur == null) {
            Node temp = dummyHead.next;
            dummyHead.next = new Node(key, value, temp);
            size++;
        }else{
            cur.value = value;
        }

    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.key.equals(key)) {
                Node temp = prev.next.next;
                Node delNode = prev.next;
                prev.next = null;
                prev.next = temp;
                size--;
                return delNode.value;
            }
            prev = prev.next;
        }


        return null;
    }

    @Override
    public boolean contains(K key) {

        return getNode(key) != null;
    }

    @Override
    public V get(K key) {

        Node cur = getNode(key);
        if (cur != null) {
            return cur.value;
        }

        return null;
    }

    @Override
    public void set(K key, V newValue) {

        Node node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException(key + "doesn't exit!");
        }
        node.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    private class Node {
        public K key;
        public V value;
        public Node next;


        public Node(K key,V value,Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key, null, null);
        }
        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }
    }
}
