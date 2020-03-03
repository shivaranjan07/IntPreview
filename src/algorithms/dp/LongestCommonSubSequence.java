package algorithms.dp;

public class LongestCommonSubSequence {

	// tabulated implementation for the LCS problem
//	https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
/*	Matrix generated for this input
	0 S H A S H I
0	0 0 0 0 0 0 0
S	0 1 1 1 1 1 1
H	0 1 2 2 2 2 2
I	0 1 2 2 2 2 3
V	0 1 2 2 2 2 3
A	0 1 2 3 3 3 3 */
	private static int LongestCommonSequence(String firstString, String secondString, int firstStringLength,
			int secondStringLength) {
		int[][] sequence = new int[firstStringLength + 1][secondStringLength + 1];
		
		for(int i=0; i <= firstStringLength; i++) {
			for(int j=0; j <= secondStringLength; j++) {
				if(i==0 || j==0)
					sequence[i][j] = 0;
				else if(firstString.charAt(i - 1) == secondString.charAt(j - 1))
					sequence[i][j] = sequence[i-1][j-1] + 1;
				else
					sequence[i][j] = maximum(sequence[i-1][j], sequence[i][j-1]);
			}
		}
		
		return sequence[firstStringLength][secondStringLength];
	}

	private static int maximum(int i, int j) {

		return i>j?i:j;
	}

	public static void main(String[] args) {
		String firstString = "Shiva";
		String secondString = "Shashi";
		int firstStringLength = firstString.length();
		int secondStringLength = secondString.length();
		System.out.println("Length of the longest Sequence is : " + LongestCommonSequence(firstString, secondString, firstStringLength, secondStringLength));
	}
}
