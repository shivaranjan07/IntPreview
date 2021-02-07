package algorithms.dp;


// kadane's algorithm
public class MaxSumSubArray {

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.printf("max sum of a sub array " + maxSum(arr));
    }

    private static int maxSum(int[] arr) {
        int maxSumEndingHere = arr[0];
        int maxSoFar = arr[0];
        int n = arr.length;
        for (int i=1;i<n;i++) {
            maxSumEndingHere = Math.max(arr[i], arr[i] + maxSumEndingHere);
            maxSoFar = Math.max(maxSoFar, maxSumEndingHere);
        }

        return maxSoFar;
    }
}


/**
 * meh -2  msf -2 //initial values
 * {-2, -3, 4, -1, -2, 1, 5, -3}
 * arr[i]  -> arr[i]  -> arr_i+maxEndinghere  -> maxSoFar
 * -3 -> -3 -> -3 + -2 = (-3, -5)  -> -2
 * 4  -> 4 -> 4 + -3 = (4, 1) -> 4
 * -1 -> -1 -> 4 + -1 = (-1, 3) -> 4
 * -2 -> -2 -> 3 + -2 = (-2, 1) -> 4
 * 1 -> 1 , 1 + 1 = (1, 2) -> 4
 * 5 -> 5, 5+2 (5, 7) -> 7
 * -3 -> -3, (-3+7) -> 4
 * */