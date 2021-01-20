package recursion101;

public class PrintArray {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 30};

//        displayArr(arr, 0);
//        System.out.println(maxArr(arr, 0));
        System.out.println(firstIndex(arr, 0, 30));
    }

    private static int firstIndex(int[] arr, int idx, int data) {
        if(idx >= arr.length) {
            return -1;
        }
        if(arr[idx] == data) {
            return idx;
        }
        return firstIndex(arr, idx+1, data);
    }

    private static void displayArr(int[] arr, int idx) {
        if(idx >= arr.length)
            return;
        displayArr(arr, idx+1);
        System.out.println(arr[idx]);
    }

    private static int maxArr(int[] arr, int idx) {
        if(idx >= arr.length)
            return 0;

        int maxInsubarr = maxArr(arr, idx+1);
        if(arr[idx] > maxInsubarr)
            return arr[idx];
        else
            return maxInsubarr;
    }
}
