package Array;

import java.lang.Object;

/**
 * @author ray
 */
public class Array<E> {
    private E[] data;

    private int size;

    /**
     *
     * size为数组索引
     * 构造函数，传入数组的容量capacity构造Array，初始化size
     * @param capacity
     */
    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    /**
     * 当用户不传入capacity时，为data数组赋予默认值10
     */
    public Array() {
        this(10);
        size = 0;
    }

    /**
     * 获取数组中的元素个数
     * @return
     */
    public int getSize() {
        return size;
    }


    /**
     *获取数组中最后一个元素
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }


    /**
     * 获取数组第一个元素
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取数组的容量
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 返回数组是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 判断数组元素是否满了
     * 向所有元素后添加一个新元素
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 在数组开头添加一个元素
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }


    /**
     * 在数组中index(任意)位置插入e
     * 同时判断数组是否满了，若满了则扩充数组为原来的一倍
     * @param index
     * @param e
     */
    public void add(int index,E e){


        if (index<0||index>size){
            throw new IllegalArgumentException("Add failed. Require index >=0 and index <=size");
        }

        if (size==data.length){
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }


    /**
     * 获取传入索引位置的元素
     * @param index
     * @return
     */
    public E get(int index) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed . Index is illegal");
        }
        return data[index];
    }

    /**
     * 修改传入索引位置的元素为e
     * @param index
     * @param e
     */
    public void set(int index,E e){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed . Index is illegal");
        }
        data[index] = e;
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array.Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(",");
            }
        }
        res.append(']');
        return res.toString();
    }

    /**E
     * 判断数组中是否含有传入元素
     * @param e
     * @return
     */
    public boolean contains( E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] .equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找某个元素，找到返回索引，没找到返回-1
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] .equals( e)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 删除某个元素，并返回该元素
     * 当前数组元素的数量为数组容量的1/4时，数组容量缩小一半
     * @param index
     * @return
     */
    public E remove(int index){

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed . Index is illegal");
        }

        E ret = data[index];
        for (int i=index+1;i<size;i++){
            data[i-1] = data[i];
        }
        size--;
        data[size] = null;
        if (size == data.length / 4 && data.length / 2 != 0) {

            resize(data.length / 2);
        }
        return ret;
    }


    /**
     * 删除数组中第一个元素
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除数组中最后一个元素
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }


    /**
     * 从数组中删除元素e，先判断是否有该元素，有则返回true，没有则返回false，只能删除一个e，若有多个则另外考虑
     * @param e
     */
    public boolean removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }


    /**
     * 重置数组容量，扩充一倍
     * 设置为私有方法
     */
    private void resize(int newCapacity) {

        E[] newData = (E[])new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
