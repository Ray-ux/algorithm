package MaxHeap;

import Array.Array;

/**
 * @author 张烈文
 */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<E>(capacity);
    }

    public MaxHeap() {
        data = new Array<E>();


    }

    public MaxHeap(E[] arr) {
        data = new Array<E>(arr);

        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);

        }
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }


    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
     * @param index
     * @return
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent");
        }

        return (index - 1) / 2;
    }


    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子的索引
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return (2 * index) + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子的索引
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return (2 * index) + 2;
    }

    /**
     * 向堆中添加元素
     * 由于自己实现的底层数组已经有了动态扩容的操作，因此不必在需要去管理数组的容量
     * 向堆中添加元素需要注意的是：添加的元素要比其父节点的元素大时则交换，以此来实现最小堆
     * @param e
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }


    /**
     *当父节点元素小于添加的元素则两个节点元素交换位置
     * @param k
     */
    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }


    /**
     * 找到堆中的最大元素，并返回
     * @return
     */
    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Can not findMax when heap is Empty");
        }
        return data.get(0);
    }

    /**
     *
     * 删除最大元素，并用节点中的最后一个元素加以替换
     * 而后将该元素与其左右节点比较与节点中最大的交换,并循环,
     * 直到它的左节点位置处的索引大于堆的元素个数时，
     * @return
     */
    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }


    /**
     * 左右节点比较，并实现元素交换
     * @param k
     */
    private void siftDown(int k) {
        while (leftChild(k) <data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
            }

            if (data.get(k).compareTo(data.get(j)) > 0) {
                break;
            }

            data.swap(k, j);
            k = j;
        }
    }

    /**
     * 取出最大元素，并且替换成元素e
     * @param e
     * @return
     */
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }


}
