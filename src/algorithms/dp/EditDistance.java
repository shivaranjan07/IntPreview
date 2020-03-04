package algorithms.dp;

public class EditDistance {

	private static int FindEditDistance(String firstString, String secondString, int firstStringLength,
			int secondStringLength) {
		int[][] distanceMatrix = new int[firstStringLength+1][secondStringLength+1];
		for(int i=0; i <= firstStringLength; i++) {
			for(int j=0; j <= secondStringLength; j++) {
				if(i == 0) 
					distanceMatrix[i][j] = j;
				else if(j == 0)
					distanceMatrix[i][j] = i;
				else if(firstString.charAt(i-1) == secondString.charAt(j-1))
					distanceMatrix[i][j] = distanceMatrix[i-1][j-1];
				else
					distanceMatrix[i][j] =1 + minimum(distanceMatrix[i][j-1], distanceMatrix[i-1][j],distanceMatrix[i-1][j-1]);
			}
		}
		return distanceMatrix[firstStringLength][secondStringLength];
	}
	
	private static int minimum(int i, int j, int k) {
		if(i <= j && i <= k)
			return i;
		else if(j <= i && j <= k)
			return j;
		else
			return k;
	}

	public static void main(String[] args) {
		String firstString = "Shiva";
		String secondString = "Shashi";
		int firstStringLength = firstString.length();
		int secondStringLength = secondString.length();
		System.out.println("Number of changes required : " + FindEditDistance(firstString, secondString, firstStringLength, secondStringLength));
	}
}
