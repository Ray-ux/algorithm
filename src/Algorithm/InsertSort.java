package Algorithm;

/**
 * 插入排序法
 *
 * @author 张烈文
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
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
