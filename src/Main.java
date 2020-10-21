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
        int n = 10000000;
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
        System.out.println(testQueue(maxHeap, n));
    }

}
