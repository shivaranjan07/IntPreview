package algorithms.sorting;


/**
 * Assumption baseed sorting
 *
 * RadixSorting - sort using the base or radix of a number
 * assuming all numbers have same width and radix
 *
 * */
public class RadixSort {
    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();
        int[] arr = {6783, 5729, 1702, 2899, 4328, 8055};
        radixSort.sort(arr, 10, 4);
    }

    private void sort(int[] arr, int radix, int width) {
        for(int i=0;i<width;i++) {
            helper(arr, i, radix);
        }

        for(int val : arr) {
            System.out.print(val + " ");
        }
    }

    private void helper(int[] arr, int pos, int radix) {
        //need to create a count Array of length radix cz there could be 0-radix digits!!
        int[] countArray = new int[radix];

        //fill the count Array - for that we need to take each digit from number
        for(int value: arr) {
            countArray[getDigit(value, pos, radix)]++;
        }

        //modify the count Array so it contains sum of digits which are less than equal to current index(/digit)
        for(int j=1;j<radix;j++) {
            countArray[j] += countArray[j-1];
        }

        //stable sorting... store the sorted numbers in temp array based on their appearance according to countArray(moded)
        //take numbers from last index
        int[] temp=new int[arr.length];
        for(int tempIndex=arr.length-1; tempIndex>=0; tempIndex--) {
            temp[--countArray[getDigit(arr[tempIndex], pos, radix)]] = arr[tempIndex];
        }

        //copy the temp array to input array
        for(int i=0;i<arr.length;i++) {
            arr[i] = temp[i];
        }
    }

    private int getDigit(int value, int pos, int radix) {
        return (value/(int)Math.pow(radix, pos))%radix;
    }
}
