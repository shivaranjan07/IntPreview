package algorithms.searching;

import java.util.Scanner;

//Assuming array is sorted

public class ExponentialSearch {

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8};
		int searchElement = input.nextInt();
		int length = array.length;

		int position = search(array, searchElement, length);
		
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

	private static int search(int[] array, int searchElement, int length) {

		if (array[0] == searchElement) 
	        return 0; 
	  

	    int i = 1; 
	    while (i <= length && array[i-1] <= searchElement) 
	        i = i*2; 
	    
	    if(i>length)
	    	return -1;
	    else
	    //  Call binary search for the found range. 
	    	return algorithms.searching.BinarySearch.search(array, i/2, Math.min(i, length), searchElement);
		
	}
}
