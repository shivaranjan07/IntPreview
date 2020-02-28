package algorithms.sorting;

public class SelectionSort {

	public static void main(String[] args)
	{
		int[] array = { 3, 4, 2, 8, 1, 7, 9, 6, 5 };
		int length = array.length;
		
		sort(array, length);
		System.out.print("Sorted Array : ");
		for(int i=0; i<array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
	}

	private static void sort(int[] array, int length) {

		
		for(int i = 0; i < length-1; i++)
		{
			int indexOfMin = i;
			for(int j = i+1; j < length; j++) 
			{
				if(array[j] < array[indexOfMin]) 
					indexOfMin = j;
			}
			int temp = array[i];
			array[i] = array[indexOfMin];
			array[indexOfMin] = temp;		}
	}

}
