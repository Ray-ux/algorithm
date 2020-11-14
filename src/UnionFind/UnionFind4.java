package UnionFind;

/**
 * 关于rank的优化
 * 1.考虑到关于size的优化可以会出现一种情况：
 *    很多个子节点指向p节点，但此时高度仅为2，
 *    而q几点的高度为3但子节点数量并没有p节点多，
 *    按照size优化，就会将整体高度提升，导致效率降低
 * 2.因此采用rank优化：即这种情况下，将高度低的父节点指向高度高的父节点
 * @author 张烈文
 */
public class UnionFind4 implements UF{

    private int[] parent;

    private int[] rank;

    public UnionFind4(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }


    /**
     * @param p
     * @return
     */
    private int find(int p) {
        if (p < 0 && p >= parent.length) {
            throw new IllegalArgumentException("p is out of the bound");
        }
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }

        /**
         * 根据两个元素所在树的rank不同判断合并方向
         * 将rank低的集合合并到rank高的集合上
         */
        if (rank[pRoot]<rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        }else{
            parent[qRoot] = pRoot;
            rank[pRoot]+=1;
        }
    }
}
