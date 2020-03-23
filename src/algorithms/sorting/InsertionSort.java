package algorithms.sorting;

public class InsertionSort {

	public static void main(String[] args)
	{
		int[] array = { 3, 4, 2, 8, 1, 7, 9, 6, 5 };
		int length = array.length;
		
//		sort(array, length);
		insertionSort(array);
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

	/**
	 * Insertion Sort(ascending)
	 *  as with all sorting algos, there will be sorted part and unsorted part with each iteration
	 *  if arr has a one elem then array is sorted
	 *  so we select the "first elem" of unsorted part and compare with elems from sorted part, right to left.
	 */
	private static void insertionSort(int[] arr) {
		//considering arr with one elem is sorted and the 1 is the first index unsorted part of arr
		for(int firstUnsortedIndex = 1; firstUnsortedIndex < arr.length; firstUnsortedIndex++) {
			//since we replace elem inside arr, right to left, we need elem ar fUI
			int newElement = arr[firstUnsortedIndex];
			int i;
			//you will be comparing newElem with every elem in sorted part
			for(i=firstUnsortedIndex; i>0 && arr[i-1] > newElement; i--) {
				arr[i] = arr[i-1];
			}// once we reach the end, that is there is no such elem which is grater than newElement,
			// ith index will still have prev elem, so replace it.
			arr[i] = newElement;
		}
	}

}
