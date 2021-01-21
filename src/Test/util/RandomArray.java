package Test.util;

import org.omg.CORBA.INTERNAL;

import java.util.Random;

/**
 * @author 张烈文
 *
 */
public class RandomArray {


    public static Integer[] randomArray(int n) {
        Random random = new Random();
        Integer[] nums = new Integer[n];
        for (int i = 0; i < n; i++) {
            nums[i] = new Integer((int)random.nextInt(n));
        }
        return nums;
    }


}
