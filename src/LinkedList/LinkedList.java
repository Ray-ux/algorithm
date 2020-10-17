package LinkedList;

/**
 * @author 张烈文
 */
public class LinkedList<E> {

    /**
     * 设置为一个私有静态的内部类
     *
     */
    private class Node {

        private E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /**
     *虚拟头节点
     */

    private Node dummyHead;
    private int size;


    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * 在索引位置添加一个新的节点
     *
     * 让新节点的next下先等于prev.next，而后在让prev.next=新节点
     * 这里要考虑好顺序关系
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed");
        }
            Node prev = dummyHead;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
            prev.next = new Node(e, prev.next);
            size++;

    }

    /**
     * 在链表末尾添加一个元素
     * @param e
     */

    public void addLast(E e) {
        add(size,e);
    }

    /**
     * 在链表头添加元素
     * @param e
     */
    public void addFirst(E e) {
        add(0,e);
    }


    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }


    /**
     * 获取链表第一个位置的节点
     * @return
     */
    public E getFirst() {
        return get(0);
    }


    /**
     * 获取链表最后一个位置的节点
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }


    /**
     * 修改链表中的某个索引的元素
     * @param e
     * @param index
     */
    public void set(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Update failed, Illegal index");
        }

        Node cur = dummyHead.next;

        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;

    }


    /**
     * 查询链表中是否包含某个元素
     * @param e
     * @return
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        for (int i = 0; i < size; i++) {
            if (cur.e == e) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }


    /**
     * 从链表中删除索引位置的元素，将索引位置前的节点的next指向索引位置的next，
     * 最后为了方便jvm的垃圾回收机制，需要将索引位置的next赋值为null
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Update failed, Illegal index");
        }
        Node prv = dummyHead;

        for (int i = 0; i < index; i++) {
            prv = prv.next;
        }
        Node retNode = prv.next;
        prv.next = retNode.next;

        retNode.next = null;
        size--;
        return retNode.e;
    }

    /**
     * 删除链表第一个元素
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }


    /**
     * 删除链表最后一个元素
     * @return
     */
    public E removeLast() {
        return remove(size);
    }


    /**
     * 删除链表中第一次出现的元素
     * @param e
     */
    public void removeElement(E e) {
        Node prev = dummyHead;
        for (int i = 0; i < size; i++) {
            if (prev.next.e == e) {
                Node temp = prev.next.next;
                prev.next.next = null;
                prev.next = temp;
                size--;
            }
            prev = prev.next;
        }
    }



    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur.e + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

}
