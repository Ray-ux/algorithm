package Queue;

import MaxHeap.MaxHeap;

/**
 * @author 张烈文
 * 优先队列
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<E>();
    }


    /**
     * 获取元素的个数
     * @return
     */
    @Override
    public int getSize() {
        return maxHeap.size();
    }

    /**
     * 判断是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    /**
     * 添加一个元素
     * @param e
     */
    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    /**
     *取出一个元素
     * @return
     */
    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    /**
     * 获取当前队列中的最大元素
     * @return
     */
    @Override
    public E getFront() {
        return maxHeap.findMax();
    }
}
