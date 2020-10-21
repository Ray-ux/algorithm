package SegmentTree;

import java.util.Arrays;

/**
 * 线段树
 * @author 张烈文
 */
public class SegmentTree<E> {
    private E[] data;

    private E[] tree;

    private Merger<E> merger;
    public SegmentTree(E[] arr,Merger<E> merger) {

        this.merger = merger;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[arr.length * 4];
        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * 在treeIndex的位置创建表示区间[l,r]的区间
     * @param treeIndex
     * @param l
     * @param r
     */
    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        int mid = l + (r - l) / 2;
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public int getSize() {
        return tree.length;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal;");
        }
        return tree[index];
    }

    private int leftChild(int k) {
        return (2 * k) + 1;
    }

    private int rightChild(int k) {
        return (2 * k) + 2;
    }


    /**
     * 返回区间[queryL,queryR]
     * @param queryL
     * @param queryR
     * @return
     */
    public E query(int queryL, int queryR) {

        if (queryL < 0 || queryL >= data.length || queryL > queryR) {
            throw new IllegalArgumentException("index is Illegal");
        }

        return query(0, 0, data.length - 1, queryL, queryR);
    }

    /**
     * 在以treeId为根的线段树中[l...r]的范围里，搜索区间[queryL...queryR]的值
     * @param treeIndex
     * @param l
     * @param r
     * @param queryL
     * @param queryR
     * @return
     */
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }

        int mid = l + (r - l) / 2;

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if (queryL >= mid + 1) {
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        } else if (queryR <= mid + 1) {
            return query(leftTreeIndex, l,mid, queryL, queryR);
        }


        E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
        return merger.merge(leftResult, rightResult);
    }


    /**
     * 将index位置的值，更新为e
     * @param index
     * @param e
     */
    public void set(int index, E e) {

        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal");
        }

        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    /**
     * 更新操作
     * @param treeIndex
     * @param l
     * @param r
     * @param index
     * @param e
     */
    private void set(int treeIndex, int l, int r, int index, E e) {
        if (l == r) {
            tree[treeIndex] = e;
        }

        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (index >= mid + 1) {
            set(rightTreeIndex, mid + 1, r, index, e);
        }else {
            set(leftTreeIndex, 0, mid,index, e);
        }
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);

    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i = 0; i < tree.length; i++) {

            if (tree[i] != null) {

                res.append(tree[i] + ",");
            }else{
                res.append("null");
            }
        }
        res.append(']');
        return res.toString();
    }

}
