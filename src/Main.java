import Array.Array;
import Bst.BST;
import LinkedList.LinkedList;
import MaxHeap.MaxHeap;
import Queue.ArrayQueue;
import Queue.LoopQueue;
import Queue.Queue;
import Stack.ArrayStack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Stack;

public class Main {

    /**
     * 测试使用queue运行opCount个enqueue和dequeue操作所需要的时间，秒
     * @param
     * @param opCount
     * @return
     */
    private static double testQueue(MaxHeap<Integer> maxHeap, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();

        for (int i = 0; i < opCount; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;


    }
    public static void main(String[] args) {
//        StringBuilder res = new StringBuilder("sdwewe");
//        System.out.println(res.reverse());
//
//        int n = 10000000;
//        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
//        System.out.println(testQueue(maxHeap, n));
        Solution solution = new Solution();
        int[] arr1 = {2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31};
        int[] arr2 = {2,42,38,0,43,21};
        int[] nums = solution.relativeSortArray(arr1, arr2);
        for (int num : nums) {
            System.out.println(num);
        }


    }

}
