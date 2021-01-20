package arraysNstrings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an unsorted array arr[] of N integers and a sum.
 * The task is to count the number of subarrays which add to a given number.
 * */
public class countSubArrayWithSum {
    public static void main(String[] args) {
        int[] arr = {10, 2, -2, -20, 10};
        helper(arr, -10);
    }

    private static void helper(int[] arr, int s) {
        int csum=0;
        Map<Integer, Integer> map = new HashMap<>();
        int i =0, n = arr.length;
        int count = 0;
        while(i < n) {
            csum += arr[i];
            int find = csum - s;
            if(find == 0)
                count+=1;

            if(map.containsKey(find))
                count+=map.get(find);

            if(map.containsKey(csum)) {
                map.put(csum, map.get(csum)+1);
            } else {
                map.put(csum, 1);
            }

            i++;
        }
        System.out.println(count);
    }
}
