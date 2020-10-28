package Algorithm;

/**
 * @author 张烈文
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70};
    }
    
    public static void quickSort(int[] arr, int left, int right) {
        //左下标
        int l = left;
        //右下标
        int r = right;

//        pivot中轴值
        int pivot = arr[(left + right) / 2];
//        交换时使用
        int temp = 0;

//        while循环的目的是让比pivot值小放到左边
//        比pivot值大放到右边
        while (1 < r) {

//            在pivot的左边一直找，找到大于等于pivot值才退出
            while (arr[l] < pivot) {
                l++;
            }

//            在pivot的右边一直找，找到小于等于pivot值才退出
            while (arr[r] > pivot) {
                r--;
            }

//            如果l>=r说明pivot的左右两的值，已经按照左边全部是小于等于pivot值，
//            而右边全部是大于等于pivot值
            if (l >= r) {
                break;
            }
//            交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

//            如果交换完后，发现这个arr[l]==pivot值 相等 r-- ，前移
            if (arr[l] == pivot) {
                r--;
            }
            //如果交换完后，发现这个arr[r]==pivot值 相等 l++ ，前移
            if (arr[r] == pivot) {
                l++;
            }
        }

//        如果l==r,必须l++,r--,否则会出现栈溢出
        if (l == r) {
            l++;
            r--;
        }

        if (left < r) {
            quickSort(arr, left, r);
        }

        if (right > l) {
            quickSort(arr, l, right);

        }
    }
}
