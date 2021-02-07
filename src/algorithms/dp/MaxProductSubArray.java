package algorithms.dp;

public class MaxProductSubArray {
    public static void main(String[] args) {
        MaxProductSubArray maxProductSubArray = new MaxProductSubArray();
        int[] arr = {2,3,-2,4};
        System.out.println("max product of sub arr " + maxProductSubArray.maxProduct(arr));
    }

    private int max = Integer.MIN_VALUE;
    // recursive approach
    /**
     * 1. call the recursive dfs function with each of the index
     * 2.0  In the recursive dfs function, the base case is to check if the passed index is going over the length
     *   of the array
     * 2.1 If not, recurse with multiplying the result with the index element and increment the index for the next
     *  recursive call
     *
     * */
    private int maxProduct(int[] arr) {
        if(arr.length == 0) {
            return 0;
        }

        for(int i=0;i<arr.length;i++) {
            int res = 1;
            dfs(arr, res, i);
        }

        return max;
    }

    private void dfs(int[] arr, int res, int index) {
        if(index > arr.length-1) {
            return;
        }

        res = res * arr[index];
        max = Math.max(max, res);
        dfs(arr, res, index+1);
    }


    /**
     *Approach 2 (DP / Kadane's Algorithm Accepted)
     *
     * At each index we make sure to compute three values - overall max, max seen so far, min seen so far
     *
     * maxEndingHere will store all the max product seen so far
         this will be coming from either the current element arr[i]
         or the product of current element with maxEndingHere so far
         or the product of current element with minEndingHere so far (two negative can be positive and may be higher)
     
     * minEndingHere to store the minimum product seen so far
         this will be coming from either the current element itself arr[i]
         or the product of current element with minEndingHere so far
         or the product of current element with maxEndingHere (since max Ending here will be updated prior to this, 
            we take the value of maxEndingHere just before updating in a temp variable)
     
     * maxOverall to store the maximum product that was ever computed while iterating the elements, get the max from
     * maxOverall and maxEndingHere
     *
     * */

    public int maxProductIter(int[] nums) {
        int maxEndinghere = nums[0];
        int minEndinghere = nums[0];
        int maxSoFar = nums[0];

        for(int i=1;i<nums.length;i++) {
            int temp = maxEndinghere;
            maxEndinghere = Math.max(nums[i],
                    Math.max(nums[i]*maxEndinghere, nums[i]*minEndinghere));

            minEndinghere = Math.min(nums[i],
                    Math.min(nums[i]*minEndinghere, nums[i]*temp));

            maxSoFar = Math.max(maxSoFar, maxEndinghere);
        }

        return maxSoFar;
    }
}
