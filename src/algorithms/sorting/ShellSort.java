package algorithms.sorting;


/**
 * what if most the elems are already sorted/in its proper place(after sorting) while doing insertion sort
 * considering gap value is upto u, here we are using arr.length/2.
 * gap will reduced by half everytime, each time an elem is shifted closer its sorted pos
 * insertion sort will be done when gap value becomes 1(gap value must become 1 at some point)
 * */
public class ShellSort {
    public void sort(int[] arr) {
        for(int gap = arr.length/2; gap>0;gap/=2) {

            //insertion sort/all shifting and sorting happens in this arena
            for(int i = gap; i < arr.length; i++) {
                int newElement = arr[i];
                int j = i;
                //if j becomes less than gap we have hit the front of the array
                while (j >= gap && arr[j-gap] > newElement) {
                    arr[j] = arr[j-gap];
                    j = j - gap;
                }
                arr[j] = newElement;
            }

        }
    }
}
