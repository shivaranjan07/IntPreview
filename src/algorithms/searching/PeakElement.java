package algorithms.searching;

public class PeakElement {

    public static Integer getPeakElement(int[] array) {

        if (array == null || array.length == 0) {
            return null;
        }

        int n = array.length;

        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if ((mid == 0 || array[mid - 1] <= array[mid]) && (mid == n - 1 || array[mid] >= array[mid + 1])) {
                return array[mid];
            } else if (mid > 0 && array[mid - 1] > array[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] array = { 4, 2, 5, 7 };
        Integer peak = getPeakElement(array);
        System.out.println(peak != null ? "Peak Element is "  + peak : "No peak element!" );
    }
}