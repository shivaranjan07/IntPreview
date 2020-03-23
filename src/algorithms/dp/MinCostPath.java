package algorithms.dp;

/**
 * Problem statement contains that we can traverse right, left or diagonal
 * While traversing from (0,0) to (1,2) we will go with (0,0) -> (0,1) -> (1,2)
 *                                                        1        4        2    = 7
 * Matrix generated for this program is
 *     0 1 2
	0  1 5 10
	1  5 8 7
	2  6 11 8

 just another way
 * of deriving recurrence relation think we are at the index arr(2,2),
 * we can come to that index from (1,1), (1,2), (2,1).
 * and dp[][] table will contain the best path possible till those index, lets call it as bp(best path).
 * so find the minmum of bp and add it to index (2,2)
 * so dp[2][2] = arr[2][2] + Math.min(dp[1][1], Math.min(dp[1,2], dp[2][1])
*/
public class MinCostPath {

	private static int calculateMinCost(int[][] costMatrix, int row, int column) {
		int[][] totalCost = new int[row+1][column+1];
		totalCost[0][0] = costMatrix[0][0];
		for(int i = 1; i <= row; i++)
			totalCost[i][0] = totalCost[i-1][0] + costMatrix[i][0];
		for(int j = 1; j <= column; j++)
			totalCost[0][j] = totalCost[0][j-1] + costMatrix[0][j];
		
		for(int i = 1; i <= row; i++)
			for(int j = 1; j <= column; j++)
				totalCost[i][j] = costMatrix[i][j] + minimum(totalCost[i-1][j], totalCost[i][j-1], totalCost[i-1][j-1]);
		return totalCost[row][column];
	}
	
	private static int minimum(int i, int j, int k) {
		if(i <= j && i <= k)
			return i;
		else if(j <= i && j <= k)
			return j;
		else
			return k;
	}
	
	public static void main(String args[]) 
	{ 
		int costMatrix[][]= {{1, 4, 5},
                             {4, 7, 2},
                             {1, 6, 1}}; 
		System.out.println(calculateMinCost(costMatrix,1,2)); 
	}
}
