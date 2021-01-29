package algorithms.dp;

import java.util.Scanner;

public class HouseRobber {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }


        System.out.println(bottomUp(arr));
        // System.out.println(helper(arr, n-1));
        // System.out.println(helper2(arr, 0));
    }

    static int helper(int[] arr, int n) {
        if(n < 0) {
            return 0;
        }

        return Math.max(arr[n] + helper(arr, n-2), helper(arr, n-1));
    }

    static int helper2(int[] arr, int in) {
        if(in >= arr.length) {
            return 0;
        }

        int inc = arr[in]+helper2(arr, in+2);
        int exc = helper2(arr, in+1);

        return Math.max(inc, exc);
    }

    static int bottomUp(int[] arr) {
        if(arr.length == 0) {
            return 0;
        }

        if(arr.length == 1) {
            return arr[0];
        }

        int include = arr[0];
        int exclude = 0;

        for(int i=1;i<arr.length;i++) {
            int newInclude = arr[i] + exclude;
            int newExclude = Math.max(include, exclude);

            include = newInclude;
            exclude = newExclude;
        }

        return Math.max(include, exclude);
    }
}
