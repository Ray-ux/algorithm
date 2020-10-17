package Queue;

import LinkedList.LinkedList;

/**
 * @author 张烈文
 *
 *
 * 使用链表实现队列，需要添加头尾，即头部出，尾部进
 */
public class LinkedListQueue<E> implements Queue<E> {


    /**
     * 链表节点
     */
    private class Node{
        public E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node() {
            this(null, null);
        }

        public Node(E e) {
            this(e, null);
        }
    }


    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * 从链表尾部进入
     * 先判断tail是否等于null，若等于则创建一个节点同时使head也等于tail，因为此时在整个队列中tail及时尾部也是头部
     * 若不等于则见else部分
     * @param e
     */
    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        }else {
            tail.next = new Node(e);
            tail = tail.next;
        }

        size++;
    }

    /**
     * 链表出队操作
     *
     * 先将要返回的节点赋值给retNode
     * 而后让head=head.next，当前头部等于原来头部指向的下一个节点
     * 而后让retNode.next=null
     * 值得注意的一点是：当原来队列中本来只存在一个节点是时，当删除这个节点后需要让tail=head，要不然tail依然指向的时原来那个节点
     * @return
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return retNode.e;
    }


    /**
     * 先判断链表队列是否为空，然后直接返回head.e
     * @return
     */
    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        return head.e;
    }


    @Override
    public String toString() {
        return "LinkedListQueue{" +
                "head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }
}
