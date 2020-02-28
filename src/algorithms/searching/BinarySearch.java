package algorithms.searching;

import java.util.Scanner;

//Assuming array is sorted 
//Time Complexity for recursive way is O(Logn)  for Iterative Way is O(1)

public class BinarySearch {

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8};
		int length = array.length;
		int searchElement = input.nextInt();
		int startPosition = 0;
		
		int position = search(array, startPosition, length - 1, searchElement);
		
		if(position == -1) 
		{
			System.out.println("Search Element not found in the given array");
		}
		else
		{
			System.out.println("Element found at position : " + (position + 1));
		}
		input.close();
		
	}

	static int search(int[] array, int startPosition, int endPosition, int searchElement) {
	
		 if(endPosition >= startPosition)
		 {
			 int mid = (startPosition + endPosition) / 2;
			 
			 if(array[mid] == searchElement)
				 return mid ;
			 
			 if(array[mid] > searchElement)
				 return search(array, startPosition, mid - 1, searchElement);
			 
			 return search(array, mid + 1, endPosition, searchElement);				 
		 }
		return -1;
		
	}
}
