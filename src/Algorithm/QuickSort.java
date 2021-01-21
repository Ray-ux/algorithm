package Algorithm;

import Test.util.RandomArray;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 张烈文
 * 快速排序法
 * 双路，三路
 */
public class QuickSort{


    public static void quickSortWay3(Comparable[] arr) {
        int n = arr.length;
        __quickSortWay3(arr, 0, n - 1);
    }

    private static void __quickSortWay3(Comparable[] arr, int l, int r) {

       //TODO  当元素个数为16个时可以考虑使用插入排序
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap( arr, l, (int)(Math.random()*(r-l+1)) + l );
        Comparable v = arr[l];
        int lt = l;  //满足arr[l+1...lt]<v
        int gt=r+1;  //满足arr[gt...r]>v
        int i = l + 1; //满足arr[gt+1...i)==v
        while (i < gt) {
            if (arr[i].compareTo(v) < 0) {
                swap(arr, lt + 1, i);
                i++;
                lt++;
            }else if (arr[i].compareTo(v) > 0) {
                swap(arr, i, gt - 1);
                gt--;
            }else{
                i++;
            }
            swap(arr, l, lt);
        }

        __quickSortWay3(arr, l, lt-1);
        __quickSortWay3(arr, gt, r);
    }

    //    对arr[l...r]部分进行快速排序,左闭右闭
    public static void quickSort(Comparable[] arr) {
        int n = arr.length;
        __quickSort(arr, 0, n - 1);
    }

    private  static void __quickSort(Comparable[] arr, int l,int r) {
        if (l >= r) {
            return;
        }
        int p=__partition(arr, l, r);
        __quickSort(arr, l, p - 1);
        __quickSort(arr,p+1,r);
    }

//    返回p使得arr[l...p-1]<arr[p];arr[p+1....r]>arr[p]
    private static int __partition(Comparable[] arr, int l, int r) {

        Comparable v = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(v) < 0) {
                swap(arr, j + 1, i);
                j++;
            }
        }
        swap(arr, l, j);
        return j;
    }

    /**
     * 双路排序
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int __partition2(Comparable[] arr, int l, int r) {
        swap(arr,l,(int)(Math.random()*(r-l+1))+1);
        Comparable v = arr[l];
        int i = l + 1, j = r;
        while (true) {
            while (arr[i].compareTo(v) < 0 && i <= r) {
                i++;
            }
            while (arr[j].compareTo(v) > 0 && j >= l + 1) {
                j--;
            }
            if (i > j) {
                break;
            }
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }

    private static void swap(Object arr[], int max, int min) {
        Object temp = arr[max];
        arr[max] = arr[min];
        arr[min] = temp;
    }


}
