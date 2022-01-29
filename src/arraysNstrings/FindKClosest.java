package arraysNstrings;

import java.util.*;
import java.util.stream.Collectors;

public class FindKClosest {
    public static void main(String[] args) {
        int[] arr = new int[]{5,6,7,8,9};
        System.out.println(findKClose(arr, 3, 7));
    }

    private static List<Integer> findKClose(int[] arr, int k, int x) {
        int low=0, end = arr.length-k;
        while(low<end) {
            int mid = low+(end-low)/2;
            if(x - arr[mid] > arr[mid+k]-x) {
                low = mid+1;
            } else {
                end = mid;
            }
        }

        return Arrays.stream(arr, low, low+k).boxed().collect(Collectors.toList());
    }

    public static void sort(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:arr)
            map.put(num, map.getOrDefault(num, 0)+1);

        Comparator<Map.Entry<Integer, Integer>> comparator = (e1, e2) -> {
            if(e1.getValue() == e2.getValue()) {
                return e1.getKey()-e2.getKey();
            } else {
                return e2.getValue()-e1.getValue();
            }
        };

        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>(comparator);

        pq.addAll(map.entrySet());

        int i=0;
        while(pq.size() > 0) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            for(int j=0;j<entry.getValue();j++) {
                arr[i]=entry.getKey();
                i++;
            }
        }

        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
    }
}
