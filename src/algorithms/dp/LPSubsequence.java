package algorithms.dp;


/**
 * Longest Palindromic Subsequence
 *
 * subsequence -> need not to be consecutive charaters, is a sequence that can be derived from
 * original string by deleting some or no elems "without changing the order" of the remaining characters
 *
 * 1 recursive approach
 * 2 top-down recursive (you can convert recursive program to top-down approach... function signature is given )
 * 3 bottom-up approach
 *
 * basic brute-force solution -> we need to try all the subsequences(complete search) of a given String.
 *  we can start processing from first and last character
 *  1. if they both match, then 2+current length
 *  2. if they dont match, skip the element from either begining or ending prcess the remaining sequence
 *
 *
 *  bottom-up matrix                result
 *      0 1 2 3 4                     0 1 2 3 4
 *      a e e p e                     a e e p e
 *  0 a 0 0 0 0 0                 0 a 1 1 2 2 3
 *  1 e 0 0 0 0 0                 1 e 0 1 2 2 3
 *  2 e 0 0 0 0 0                 2 e 0 0 1 1 2
 *  3 p 0 0 0 0 0                 3 p 0 0 0 1 1
 *  4 e 0 0 0 0 0                 4 e 0 0 0 0 1
 * */
public class LPSubsequence {
    public static void main(String[] args) {
        LPSubsequence lps = new LPSubsequence();
        lps.recurseLps("aeepe");
//        lps.topDown("aeepe");
//        System.out.println("using dynamic programing "+lps.bottomUpify("aeepe"));
    }

    private void recurseLps(String st) {
        System.out.println("using recursive approach "+helper1(st, 0, st.length()-1, 1));
    }

    private int helper1(String st, int si, int ei, int level) {
        if(si > ei)
            return 0;

        if(si == ei)
            return 1;

        if(st.charAt(si) == st.charAt(ei)) {
            return 2 + helper1(st, si+1, ei-1, level+1);
        } else {
            int c1 = helper1(st, si+1, ei, level+1); // skipping charAt startIndex
            int c2 = helper1(st, si, ei-1, level+1); // skipping charAt endIndex
            return Math.max(c1, c2);
        }
    }

//    private void topDown(String st) {
//        int n = st.length();
//        Integer[][] dp = new Integer[n][n];
//        System.out.println(helper2(st, 0, st.length()-1));
//    }

    private int bottomUpify(String st) {
        int n = st.length();
        int[][] dp = new int[n][n];

        //every subsequence with one character has palindrome length 1
        for(int i=0; i < n; i++) {
            dp[i][i] = 1;
        }

        for(int si=n-1; si>=0; si--) {
            for(int ei=si+1; ei<n;ei++) {
                //case-1 if first and last char matches
                if(st.charAt(si) == st.charAt(ei)) {
                    dp[si][ei] = 2+dp[si+1][ei-1];
                } else {
                    //case-2 if first n last character doesn't match then skip either first or last character
                    dp[si][ei] = Math.max(dp[si+1][ei], dp[si][ei-1]);
                }
            }
        }

        return dp[0][n-1];
    }
}


