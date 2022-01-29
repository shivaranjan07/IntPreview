package arraysNstrings;


import java.util.HashMap;
import java.util.Map;

/**
 * count of sub arrays whose sum is 0
 *
 * */
public class CoutOfSubarray {
    public static void main(String[] args) {
        int[] arr = {0,0,5,5,0,0};
        System.out.println(countOfSubarrays(arr));
    }

    private static int countOfSubarrays(int[] arr) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int i=-1;
        int sum = 0;
        map.put(sum, 1);
        while(i < arr.length-1) {
            i++;
            sum+=arr[i];
            if(map.containsKey(sum)) {
                count+=map.get(sum);
                map.put(sum, map.get(sum)+1);
            } else {
                map.put(sum, 1);
            }
        }


        return count;
    }
}
