package arraysNstrings;

import java.util.*;


/**
 * wrong approach when u have to print all the triplets is
 * for(int i=0;i<arr.length;i++) {
         int j=i+1, k=arr.length-1;

         while(j < k) {
             int sum = arr[i]+arr[j]+arr[k];
             if(sum == 0) {
             triplets.add(Arrays.asList(arr[i], arr[j], arr[k]));
             break;
             } else if(sum < 0) {
             j++;
             } else {
             k--;
             }
        }
    }
 *
 *
 * */
class TripletSumToZero {
    public static void main(String[] args) {
        List<List<Integer>> ans = searchTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2});
        for(List<Integer> list: ans) {
            System.out.println(list);
        }

    }

    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();

        Arrays.sort(arr);




        return triplets;
    }
}
