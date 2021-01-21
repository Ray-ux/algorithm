package Algorithm;

import Test.entity.Student;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * 选择排序
 * @author 张烈文
 */
public class SelectionSort {

    public  void select(Comparable[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j].compareTo(nums[i])<0) {
                    Comparable temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

    }


}
