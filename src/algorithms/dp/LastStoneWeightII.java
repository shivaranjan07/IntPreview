package algorithms.dp;


/**
 * leetcode
 * 1049. LastStoneWeightII
 * similar to Minimum Subset sum difference
 * */
class LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        if(stones.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        return helper(stones, sum);
    }

    public int helper(int[] stones, int sum) {
        boolean[] dp = new boolean[sum/2+1];
        int n = stones.length;
        dp[0] = true;
        for(int s=1; s<sum/2+1; s++) {
            dp[s] = stones[0] == s;
        }


        for(int i=1; i<n; i++) {
            for(int s= sum/2; s>=0;s--) {
                if(s >= stones[i]) {
                    dp[s] = dp[s] || dp[s - stones[i]];
                } else {
                    dp[s] = dp[s];
                }
            }
        }

        int sum1 = 0;
        for(int s=sum/2;s>=0;s--) {
            if(dp[s]) {
                sum1 = s;
                break;
            }
        }

        int sum2 = sum - sum1;

        return Math.abs(sum1 - sum2);
    }

    //recursive approach
    public int lastStoneWeightIIRecursive(int[] stones) {
        // helper(int[] stones, int ci, int sum1, int sum2)
        return helper(stones, 0, 0, 0);
    }

    public static int helper(int[] stones, int ci, int sum1, int sum2) {
        if(ci == stones.length) {
            return Math.abs(sum1 - sum2);
        }

        int set1 = helper(stones, ci+1, sum1+stones[ci], sum2);
        int set2 = helper(stones, ci+1, sum1, sum2+stones[ci]);

        return Math.min(set1, set2);
    }
}
