package algorithms.sort;

public class BubbleSort {

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
	
		for(int i=0; i<length-1; i++)
		{
			boolean swap = false;
			for(int j=0; j<length - i - 1; j++)
			{
				if(array[j] > array[j+1])
				{
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					swap = true;
				}
			}
			if(swap == false)
				break;
		}
	}
}
