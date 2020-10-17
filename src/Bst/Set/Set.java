package Bst.Set;

/**
 * @author 张烈文
 *
 */
public interface Set<E> {

    /**
     * 添加一个元素，不能重复
     * @param e
     */
    void add(E e);


    /**
     * 删除一个元素
     * @param e
     */
    void remove(E e);

    /**
     * 判断是否包含某个元素
     * @param e
     * @return
     */
    boolean contains(E e);

    /**
     * 返回该集合中的元素个数
     * @return
     */
    int getSize();

    /**
     * 判断该集合是否为空
     * @return
     */
    boolean isEmpty();
}
