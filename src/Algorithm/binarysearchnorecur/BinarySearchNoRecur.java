package Algorithm.binarysearchnorecur;

/**
 *
 *非递归方式的二分查找
 * 这里可能会发生溢出
 *@author 张烈文
 */
public class BinarySearchNoRecur {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
