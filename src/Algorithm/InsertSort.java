package Algorithm;

/**
 * 插入排序法
 *
 * @author 张烈文
 */
public class InsertSort {


    /**
     * 这里的简单版的插入排序，需要调用自己定义的swap方法，使得时间效率变慢
     * @param arr
     */
    public static void insertSimple(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0&&arr[j]<arr[j-1]; j--) {
                swap(arr, j, j-1);
            }
        }
    }

    /**
     * 优化版本的插入排序，先将待插入的元素copy一份，然后再寻找待插入的位置，最后将其插入进去
     * @param arr
     */
    public static void insert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j;
            int copy = arr[i];
            for (j = i; j > 0 && arr[j-1] > copy; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = copy;
        }
    }

    public static void swap(int[] arr, int min, int max) {
        int temp = arr[max];
        arr[max] = arr[min];
        arr[min] = temp;
    }



    public static void insertSort(int[] arr) {

        int insertVal = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {

//        第一轮

//        定义待插入的数
             insertVal = arr[i];
//            arr[i]的前面的这个数的下标
             insertIndex = i-1;
//        给insertVal找到插入的位置
//        说明
//        1.insertIndex>=0保证再给insertVal找插入位置,不越界
//        2.insertVal<arr[insertIndex]待插入的数，还没有找到插入的位置
//        3.就需要将arr[insertIndex]后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
//        当退出while循环时，说明插入的位置找到，insertIndex=1
            if (insertIndex + 1!=i) {
                arr[insertIndex + 1] = insertVal;
            }

        }

    }
}
