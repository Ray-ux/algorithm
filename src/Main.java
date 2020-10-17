import Array.Array;
import Bst.BST;
import LinkedList.LinkedList;
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
     * @param queue
     * @param opCount
     * @return
     */
    private static double testQueue(Queue<Integer> queue, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();

        for (int i = 0; i < opCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;


    }
    public static void main(String[] args) {


    }

}
