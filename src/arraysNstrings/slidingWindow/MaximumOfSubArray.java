package arraysNstrings.slidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

//https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1#
public class MaximumOfSubArray {
    public static void main(String[] args) {
        int n =9, k=3;
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        max_of_subarrays(arr, n, k);
    }

    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k)
    {
        Deque<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0;i<n;i++) {
            while(!queue.isEmpty() && arr[queue.getLast()] <= arr[i])
                queue.removeLast();

            queue.addLast(i);

            //discard the indexes which are not required
            if(queue.getFirst() == i-k)
                queue.removeFirst();


            if(i>=k-1) {
                result.add(arr[queue.getFirst()]);
            }
        }

        return result;
    }
}
