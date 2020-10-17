package Bst.Set;

import Bst.BST;

/**
 *
 * 使用二分搜索树实现set
 * @author 张烈文
 */
public class BstSet<E extends Comparable<E>> implements Set<E> {


    private BST<E> bst;

    public BstSet() {
        bst = new BST<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {

        bst.remove(e);

    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
