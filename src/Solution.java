import java.util.*;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num:arr2) {
            map.put(num, 0);
        }
        for (int num:arr1) {
            if (map.containsKey(num)) {
                Integer count = map.get(num);
                map.put(num, ++count);
            }else{
                list.add(num);
            }
        }
        Collections.sort(list);
        int sum = arr1.length;
        int[] result = new int[sum];
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < map.get(arr2[i]); j++) {
                result[index] = arr2[i];
                index++;
            }
        }
        int i = 0;

        while (index < sum) {
            result[index++] = list.get(i++);
        }

        return result;
    }
}
