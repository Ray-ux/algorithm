package SegmentTree;

/**
 * @author 张烈文
 */
public interface Merger<E> {
    E merge(E a, E b);
}
