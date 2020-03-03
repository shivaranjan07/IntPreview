package algorithms.dp;

//tabulated implementation for the LIS problem
public class LongestIncreasingSubsequence {
	private static int LongestSequence(int[] array,int length) {
		int[] sequenceList = new int[length];
		
		int longestSequence = 0;
		for(int i=0; i < length; i++) {
			sequenceList[i] = 1;
		}
		for(int i=1; i < length; i++) {
			for(int j=0; j<i; j++) {
				if(array[i]>array[j] && sequenceList[i] < sequenceList[j] + 1) {
					sequenceList[i] = sequenceList[j] + 1;
				}
			}
		}
		for(int i=0; i < length; i++) {
			if(longestSequence < sequenceList[i]) {
				longestSequence = sequenceList[i];
			}
		}
		
		return longestSequence;
	}
	
	public static void main(String[] args) {
		int[] array = {3,1,2,4,6};
		int length = array.length;
		System.out.println(LongestSequence(array,length));
	}
}
