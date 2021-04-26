package algorithms.dp;

public class climbStairsVariants {
    public static void main(String[] args) {
        int n = 4;
        int noOfWays = climbStairs(n);
        System.out.println("number of ways to reach the n "+n +" is "+noOfWays);

        int[] arr = {3, 3, 0, 2, 2, 3};
        int noOfWaysWithVarJumps = climbStairsWithVarJumps(arr, arr.length);
    }

    private static int climbStairsWithVarJumps(int[] arr, int n) {
        int[] dp = new int[n+1];
        dp[n]=1;

        //meaning of cell-> number of ways to reach nth index ex no of ways to reach 6 from 3rd index

        for(int i=n-1;i>=0;i--) {
            for(int j=1;j<=arr[i] && i+j < dp.length;j++) {
                dp[i]+=dp[i+j];
            }
        }

        return dp[0];
    }

    private static int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;

        for(int i=4;i<=4;i++) {
            dp[i]=dp[i-3]+dp[i-2]+dp[i-1];
        }

        return dp[n];
    }
}
