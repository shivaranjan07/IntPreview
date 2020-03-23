package algorithms.sorting;

public class BubbleSort {

	public static void main(String[] args)
	{
		int[] array = { 3, 4, 2, 8, 1, 7, 9, 6, 5 };
		int length = array.length;
		
		sort(array, length);
//		BubbleSort bs = new BubbleSort();
//		bs.bubbleSort(array);

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

	/**
	 * Bubble Sort(ascending)- in bubble sort after the end of the inner loop iteration, the largest elem will go and sit
	 * at the last index.
	 * in the following example the lastUnsortedIndex would be 5
	 * every time we will be comparing elems which are next to each other/consecutive elems
	 * 		0    1  2  3   4   5
	 * 		35 -22  1  15  6   2
	 * */
	public void bubbleSort(int[] arr) {
		for(int lastUnsortedIndex = arr.length-1;lastUnsortedIndex>0;lastUnsortedIndex--) {
			for(int i=0;i<lastUnsortedIndex;i++) {
				if(arr[i] > arr[i+1]) {
					swap(arr, i, i+1);
				}
			}
		}
	}

	private void swap(int[] arr, int i, int j) {
		if(i==j)
			return;

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
