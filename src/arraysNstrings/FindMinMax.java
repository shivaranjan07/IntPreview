package arraysNstrings;


/**
 * Pair MaxMin(array, array_size)
     if array_size = 1
        return element as both max and min
     else if arry_size = 2
         one comparison to determine max and min
         return that pair
     else   array_size  > 2
        recur for max and min of left half
        recur for max and min of right half
              one comparison determines true max of the two candidates
              one comparison determines true min of the two candidates
              return the pair of max and min
 * */
public class FindMinMax {
    public static void main(String[] args) {
        int[] arr = {1000, 11, 445, 1, 330, 3000};
        int n = arr.length;

        FindMinMax findMinMax = new FindMinMax();

        ExtremeNums extremeNums = findMinMax.findMinMaxFunc(arr, 0, n-1);

        System.out.println("min "+extremeNums.min);
        System.out.println("max "+extremeNums.max);
    }

    static class ExtremeNums {
        int min;
        int max;
    }

    ExtremeNums findMinMaxFunc(int[] arr, int low, int high) {
        ExtremeNums extremeNums = new ExtremeNums();
        ExtremeNums extremeNumsLeft = new ExtremeNums();
        ExtremeNums extremeNumsRight = new ExtremeNums();
        int mid = 0;

        if(high == low) {
            extremeNums.max = arr[low];
            extremeNums.min = arr[low];
            return extremeNums;
        } else if (high == low+1) {
            if(arr[low] > arr[high]) {
                extremeNums.max = arr[low];
                extremeNums.min = arr[high];
            } else {
                extremeNums.max = arr[high];
                extremeNums.min = arr[low];
            }
            return extremeNums;
        }

        mid = (low + high) / 2;

        extremeNumsLeft = findMinMaxFunc(arr, low, mid);
        extremeNumsRight = findMinMaxFunc(arr, mid+1, high);

        if(extremeNumsLeft.min < extremeNumsRight.min) {
            extremeNums.min = extremeNumsLeft.min;
        } else {
            extremeNums.min = extremeNumsRight.min;
        }

        if(extremeNumsLeft.max > extremeNumsRight.max) {
            extremeNums.max = extremeNumsLeft.max;
        } else {
            extremeNums.max = extremeNumsRight.max;
        }

        return extremeNums;
    }
}

/**
 *
 * Time Complexity: O(n)

 Total number of comparisons: let the number of comparisons be T(n). T(n) can be written as follows:
 Algorithmic Paradigm: Divide and Conquer

 T(n) = T(floor(n/2)) + T(ceil(n/2)) + 2
 T(2) = 1
 T(1) = 0
 If n is a power of 2, then we can write T(n) as:

 T(n) = 2T(n/2) + 2
 After solving the above recursion, we get

 T(n)  = 3n/2 -2
 Thus, the approach does 3n/2 -2 comparisons if n is a power of 2. And it does more than 3n/2 - 2 comparisons
 if n is not a power of 2.

 * */
