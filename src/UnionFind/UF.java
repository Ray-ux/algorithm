package UnionFind;

/**
 * @author 张烈文
 */
public interface UF {

    /**
     * 获取元素个数
     * @return
     */
    int getSize();
    /**
     * 判断两个元素是否相连
     * @param p
     * @param q
     * @return
     */
    boolean isConnected(int p, int q);


    /**
     * 将两个元素合并在一起，即合并到一个集合
     * @param p
     * @param q
     */
    void unionElements(int p, int q);



}
