package algorithms.dp;

import java.util.Arrays;

/*
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.
For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
 *   Generated array is (Weights) 0 1 2 3 4 5
 *   1st loop : i = 0 : ways[] =  1 1 1 1 1 1
 *   2nd loop : i = 1 : ways[] =  1 1 2 2 3 3
 *   3rd loop : i = 2 : ways[] =  1 1 2 3 4 5
 */
public class CoinChangeProblem1 {
	
	private static int NumberOfWays(int[] array, int length, int sum) {
		int[] ways = new int[sum+1];
		
		Arrays.fill(ways, 0);
		
		//If sum =0 return 1 way i.e, we can exclude all the coins and give 0 sum
		ways[0] = 1;
		
		for(int i=0; i < length; i++){
			for(int j=array[i]; j <= sum; j++) {
				ways[j] += ways[j - array[i]];
			}
		}
		
		return ways[sum];
		
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3};
		int length = array.length;
		int sum = 5;
		System.out.println(NumberOfWays(array,length, sum));
	}
}
