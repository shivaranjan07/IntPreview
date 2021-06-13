package algorithms.sorting;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {20,35, -15, 7, 55, 1, -22};
        quickSort_start(arr, 0, arr.length);
        printArr(arr);

        int[] arr2 = {20,35, -15, 7, 55, 1, -22};
        quickSort_end(arr2, 0 ,arr.length-1);
        printArr(arr2);
    }

    private static void printArr(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    private static void quickSort_end(int[] arr, int low, int end) {
        if(low >= end) {
            return;
        }

        int partitionIdx = partition2(arr, low, end);
        quickSort_end(arr, low, partitionIdx-1);
        quickSort_end(arr, partitionIdx+1, end);
    }

    private static int partition2(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i=low-1;
        int j = low;

        for(;j<high;j++) {
            if(arr[j]<pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        //j reaches high-1, [..., i, i+1, j, pivot]
        swap(arr, i+1, high);
        return (i+1);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void quickSort_start(int[] arr, int start, int end) {
        if(end - start < 2) {
            return;
        }

        int partitionIdx = partition(arr, start, end);
        quickSort_start(arr, start, partitionIdx);
        quickSort_start(arr, partitionIdx+1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start;
        int j= end;

        while(i < j) {
            while(i < j && arr[--j] >= pivot);
            if(i<j) {
                arr[i]=arr[j];
            }

            while(i < j && arr[++i] <= pivot);
            if(i<j) {
                arr[j]=arr[i];
            }
        }

        arr[j] = pivot;
        return j;
    }

    /**
     * last index as a pivot element
     *
     * arr[] = {10, 80, 30, 90, 40, 50, 70}
     * Indexes:  0   1   2   3   4   5   6
     *
     * low = 0, high =  6, pivot = arr[h] = 70
     * Initialize index of smaller element, i = -1
     *
     * Traverse elements from j = low to high-1
     * j = 0 : Since arr[j] <= pivot, do i++ and swap(arr[i], arr[j])
     * i = 0
     * arr[] = {10, 80, 30, 90, 40, 50, 70} // No change as i and j
     *                                      // are same
     *
     * j = 1 : Since arr[j] > pivot, do nothing
     * // No change in i and arr[]
     *
     * j = 2 : Since arr[j] <= pivot, do i++ and swap(arr[i], arr[j])
     * i = 1
     * arr[] = {10, 30, 80, 90, 40, 50, 70} // We swap 80 and 30
     *
     * j = 3 : Since arr[j] > pivot, do nothing
     * // No change in i and arr[]
     *
     * j = 4 : Since arr[j] <= pivot, do i++ and swap(arr[i], arr[j])
     * i = 2
     * arr[] = {10, 30, 40, 90, 80, 50, 70} // 80 and 40 Swapped
     * j = 5 : Since arr[j] <= pivot, do i++ and swap arr[i] with arr[j]
     * i = 3
     * arr[] = {10, 30, 40, 50, 80, 90, 70} // 90 and 50 Swapped
     *
     * We come out of loop because j is now equal to high-1.
     * Finally we place pivot at correct position by swapping
     * arr[i+1] and arr[high] (or pivot)
     * arr[] = {10, 30, 40, 50, 70, 90, 80} // 80 and 70 Swapped
     *
     * Now 70 is at its correct place. All elements smaller than
     * 70 are before it and all elements greater than 70 are after
     * it.
     *
     * */
}
