package algorithms.sorting;

public class InsertionSort {

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

		for(int i=0; i<length ; i++)
		{
			int selectedElement = array[i];
			int indexOfFirstUnsortedElement = i-1;
			while (indexOfFirstUnsortedElement >= 0 && array[indexOfFirstUnsortedElement] > selectedElement) { 
                array[indexOfFirstUnsortedElement + 1] = array[indexOfFirstUnsortedElement]; 
                indexOfFirstUnsortedElement = indexOfFirstUnsortedElement - 1; 
            } 
            array[indexOfFirstUnsortedElement + 1] = selectedElement; 
		}

	}
}
