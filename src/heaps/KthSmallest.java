package heaps;

import java.util.PriorityQueue;

public class KthSmallest {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 12, 7, 23, 1};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int k = 3;

        for(int i=0;i<k;i++) {
            pq.add(arr[i]);
        }

        for(int i=k;i<arr.length;i++)
            if(pq.peek() > arr[i]) {
                pq.add(arr[i]);
            }

        for(int i=0;i<k-1;i++)
            pq.poll();

        System.out.println(pq.poll());
    }
}
