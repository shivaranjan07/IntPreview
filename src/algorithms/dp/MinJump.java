package algorithms.dp;


/**
 * Minimum jumps required to reach the end
 *
 * Given an array of positive numbers, where each element represents the max number of jumps that can be made forward from that element,
 * write a program to find the minimum number of jumps needed to reach the end of the array (starting from the first element).
 * If an element is 0, then we cannot move through that element.
 *
 * In = {2,1,1,1,4}
 * Out = 3
 * Explanation: Starting from index '0', we can reach the last index through: 0->2->3->4
 *
 * following call contains,
 * ci -> currentIndex
 * recursive approach (u can convert into top-down)
 * bottom-up approach
 * */
public class MinJump {
    public static void main(String[] args) {
        MinJump min = new MinJump();
        int[] arr = {2, 1, 1, 1, 4};
        System.out.println("min jumps required " + min.helper(arr, 0, 1));
//        System.out.println("min jumps required " + min.bottomUpify(arr));
    }


    private int helper(int[] arr, int ci, int level) {

        String tab = "\t";

        for(int i=1;i<=level;i++) {
            tab+="\t";
        }

        System.out.println(tab+"helper(arr ci "+ci+") level "+level);

        //if ci index is the last one
        if(ci == arr.length-1)
            return 0;

        if(arr[ci] == 0)
            return Integer.MAX_VALUE;

        int totalJumps = Integer.MAX_VALUE;
        //if currentIndex is x we can move between 1 to x i.e from nextIndex(ci+1) to arr[ci];
        int start = ci + 1;
        int end = ci + arr[ci];
        //will move to nextIndex find the minjumps required from that index recursively
        while(start < arr.length && start <= end) {
            int minJumps = helper(arr, start++, level+1);
            if(minJumps != Integer.MAX_VALUE) {
                //why minJumps+1, every index with in range can be reached in one jump from ci
                totalJumps = Math.min(totalJumps, minJumps+1);
            }
        }

        return totalJumps;
    }


    private int bottomUpify(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];

        //initialize arr elems from 1 to n with maxValue
        for(int i=1;i < n;i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for(int start=0;start<n;start++) {
            for(int end =start+1;end <= start+arr[start] && end < arr.length; end++) {
                //take the minimum value between the current jump-count and the jumps needed to reach the current index + 1
                dp[end] = Math.min(dp[end], dp[start]+1);
            }
        }

        return dp[n-1];
    }
}
