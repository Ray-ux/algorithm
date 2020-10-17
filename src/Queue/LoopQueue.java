package Queue;

import java.lang.Object;
import java.util.Arrays;

/**
 * @author 张烈文
 */
public class LoopQueue<E> implements Queue<E>{
    private E[] data;
    private int front, tail;
    private int size;


    /**
     * 循环队列需要浪费一个空间，因此在创建的时候需要加一个空间
     * @param capacity
     */
    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    /**
     * 返回该队列的容量，需要减一
     * @return
     */
    public int getCapacity() {
        return data.length-1;
    }
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 当front==tail时，队列在该位置存储为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return front==tail;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;

    }


    /**
     * 扩容操作
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[])new java.lang.Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("cant dequue from an empty queue");
        }

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {

            resize(getCapacity() / 2);
        }

        return ret;
    }


    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        return data[front];
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");

        for (int i = front; i !=tail; i=(i+1)% data.length) {
            res.append(data[i]);
            if ((i+1)% data.length != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

}
