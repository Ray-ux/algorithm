package SegmentTree;

/**
 * @author 张烈文
 */
public class Test {
    public static void main(String[] args) {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<Integer>(nums, (a, b) -> a + b);
        System.out.println(segmentTree.toString());


    }
}
