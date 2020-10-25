package Algorithm;

/**
 *
 * 选择排序
 * @author 张烈文
 */
public class SelectionSort {

    public static int[] select(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

}
