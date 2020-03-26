package algorithms.sorting;


import java.util.Arrays;
import java.util.Collections;

/**
 * Assumption based sorting alogrithm
 * assumes input values are integers and are in specific range.
 * genrate a count array
 * then based on count of each value from the begining, modify the input arr
 * */
public class CountingSort {
    public static void main(String[] args) {
        CountingSort countSort = new CountingSort();
        Integer[] array = { 0, 3, 4, 2, 2, 10, 5, 7, 8, 1, 7, 9, 6, 5 };
        int max = Collections.max(Arrays.asList(array));
        int min = Collections.min(Arrays.asList(array));
        countSort.sort(array, max, min);
        System.out.println(Arrays.asList(array));
    }

    private void sort(Integer[] arr, int max, int min) {
        int[] countArr = new int[(max-min)+1];

        //lets populate count array
        for(Integer elem:arr) {
            countArr[elem-min]++;
        }

        //lets modify the input array
        int index=0;
        for(int i=min;i<=max;i++) {//count array traverse-r
            //since count array follows zerobased index countArray[i-min]
            while(countArr[i-min] > 0) {
                arr[index] = i;
                index++;
                countArr[i-min]--;
            }
        }

    }
}
