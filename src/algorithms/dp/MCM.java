package algorithms.dp;

public class MCM{
    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 3, 1, 3};
        System.out.println(matrixMultiplication( arr, arr.length));
//        System.out.println(matrixRecursive(arr, 1, arr.length-1));
    }

    /**
     * i to k is one subproblem and k+1 to j is another subprob
     *   so m(i,j) will be divided into m(i,k)+m(k+1,j)
     *   m(i,k) gives result of dimension A,B
     *   m(k+1, j) => B, C
     *   example -> 40, 20, 30, 10, 30
     *                   i   k      j
     *   m(i,k) => 40 * 20 20*30 => 40*20*30 => 40*30 (D)
     *   m(k+1, j) => 30 * 10 10*30 => 30*10*30 => 30 * 30 (D)
     *   m(i, j) => 40*30*30 40 is i-1,  30 is k, 30 is J
     *   so cost of m(i,j) => arr[i-1]*arr[k]*arr[j]
     * */
    private static int matrixRecursive(int[] arr, int left, int right) {
        if(left >= right) {
            return 0;
        }

        int result = Integer.MAX_VALUE;
        for(int k=left;k<right;k++) {
            int tempCost = matrixRecursive(arr, left, k) + matrixRecursive(arr, k+1, right)
                    + arr[left-1]*arr[k]*arr[right];

            result = Math.min(result, tempCost);
        }
        return result;
    }

    static int matrixMultiplication(int[] arr, int n)
    {
        int[][] m = new int[n][n];

        //sub problems of size 1 will be 0
        for(int i=1;i<n;i++) {
            m[i][i] = 0;
        }

        //cl = chainLength, l= left, r=right
        for(int cl=2;cl<=n-1;cl++) {
            for(int l=1;l<=n-cl;l++) {
                int r = l+cl-1;
                m[l][r] = Integer.MAX_VALUE;
                for(int k=l;k<r;k++) {
                    int totalCost = m[l][k]+m[k+1][r]+
                            arr[l-1]*arr[k]*arr[r];

                    m[l][r] = Math.min(m[l][r], totalCost);
                }
            }
        }

        return m[1][n-1];
    }
}
