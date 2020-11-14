package UnionFind;

public class UnionFind1 implements UF {


    /**
     * 通过数组来记录每一个数据所对应的编号
     */
    private int[] id;

    public UnionFind1(int size) {
        id = new int[size];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }
    @Override
    public int getSize() {
        return id.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
    /**
     * 来查找元素p对应的编号
     *
     * @param p
     * @return
     */
    private int find(int p) {
        if (p > 0 && p >= id.length) {
            throw new IllegalArgumentException("p is out og bound");
        }
        return id[p];
    }

    /**
     * 合并元素p和元素q是否属于一个集合
     * 传入的元素p，q相当于数组的下标而数组的元素相当于传入传入元素的集合类型
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {

        int pID = find(p);
        int qID = find(q);
        if (pID == qID) {
            return;
        }

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
    }
}
