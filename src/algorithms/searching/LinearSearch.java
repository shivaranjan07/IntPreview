package algorithms.searching;

import java.util.Scanner;


//The time complexity of this algorithm is O(n).


public class LinearSearch {

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the length of the Array : ");
		int length = input.nextInt();
		
//		int[] array = {1,2,3,4,5};
		int[] array = new int[length];
		System.out.println("\nPlease input the array elements ");
		for(int  i = 0; i < length; i++) {
			array[i] = input.nextInt();
		}
		System.out.print("Enter the search Element :");
		int searchElement = input.nextInt();
		int position = search(array , searchElement);
		
		if(position == 0) 
		{
			System.out.println("Search Element not found in the given array");
		}
		else
		{
			System.out.println("Element found at position : " + position);
		}
		input.close();
	}

	private static int search(int[] array, int searchElement) {

		int position = -1;
		for(int i = 0; i < array.length; i++ ) 
		{
			if(array[i] == searchElement) 
			{
				position = i;
				break;
			}
		}
		return position + 1;
	}
}
