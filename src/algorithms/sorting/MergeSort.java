package algorithms.sorting;

public class MergeSort {
    public static void main(String[] args) {
//        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
//        mergeSort(intArray, 0, intArray.length);

        int[] arr = {38, 27, 43,3, 9, 82, 10};
        msort(arr, 0, arr.length-1, 0);
        printArr(arr);

    }

    private static void msort(int[] arr, int low, int end, int level) {
        StringBuilder tab = new StringBuilder("\t");
        for(int i=0;i<level;i++) {
            tab.append("\t");
        }
        System.out.println(tab+"msort "+low+" "+end);

        if(low >= end) {
            return;
        }
        int mid = low + (end-low)/2;
        msort(arr, low, mid, level+1);
        msort(arr, mid+1, end, level+1);
        mergeArray(arr, low, mid, end);
    }

    private static void mergeArray(int[] arr, int low, int mid, int end) {
        System.out.println("merge Array "+low + " "+mid+" "+end);
        //create left and right array
        int n1 = mid - low + 1; // size of the left array
        int n2 = end - mid; // size of the right array

        int[] left = new int[n1];
        int[] right = new int[n2];
        //copy the left array elems to left array
        for(int i=0;i<n1;i++) {
            left[i]=arr[low+i];
        }

        for(int j=0;j<n2;j++) {
            right[j]=arr[mid+1+j];
        }

        int i=0, j=0;
        int k=low;

        while(i<n1 && j<n2) {
            if(left[i]<=right[j]) {
                arr[k]=left[i];
                i++;
            } else {
                arr[k]=right[j];
                j++;
            }
            k++;
        }

        while(i<n1) {
            arr[k++]=left[i++];
        }

        while(j<n2) {
            arr[k++] = right[j++];
        }
        System.out.println("\nafter merging ");
        printArr(arr);
        System.out.println("\n");
    }

    public static void printArr(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + " ");
        }
    }

    // { 20, 35, -15, 7, 55, 1, -22 }
    public static void mergeSort(int[] input, int start, int end) {

        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
    }

    // { 20, 35, -15, 7, 55, 1, -22 }
    public static void merge(int[] input, int start, int mid, int end) {

        if (input[mid - 1] <= input[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        //System.arraycopy(src, srcpos, des, despos, length);
        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);


    }
}
