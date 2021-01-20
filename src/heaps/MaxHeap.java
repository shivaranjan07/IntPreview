package heaps;

public class MaxHeap {
    private int[] heap;
    //to indicate the current index
    private int heap_size;
    //to indicate total capacity of heap
    private int max_size;

    public MaxHeap(int max_size) {
        this.max_size = max_size;
        heap = new int[max_size];
        this.heap_size = 0;
    }

    public int parentIndex(int i) {
        return (i - 1) / 2;
    }

    public int left(int i) {
        return 2 * i + 1;
    }

    public int right(int i) {
        return 2 * i + 2;
    }

    public void insert(int key) {
        if (heap_size == max_size) {
            System.out.println("Overflow!!");
            return;
        }
        heap_size++;
        int i = heap_size - 1;
        heap[i] = key;

        while (i != 0 && heap[i] > heap[parentIndex(i)]) {
            swap(i, parentIndex(i));
            i = parentIndex(i);
        }
    }

    private void swap(int child, int parent) {
        int temp = heap[child];
        heap[child] = heap[parent];
        heap[parent] = temp;
    }

    private int extractMaxakaPoll() {
        if (heap_size < 0) {
            return Integer.MAX_VALUE;
        }
        if (heap_size == 1) {
            heap_size--;
            return heap[0];
        }

        int root = heap[0];
        heap[0] = heap[heap_size - 1];
        heap_size--;
        maxHeapify(0);

        return root;
    }

    public void maxHeapify(int i) {
        int left = left(i);
        int right = right(i);
        int largest = i;

        if (left < heap_size && heap[left] > heap[i]) {
            largest = left;
        }

        if (right < heap_size && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            maxHeapify(largest);
        }
    }

    public void print() {
        System.out.println();
        for(int i=0;i<heap_size;i++) {
            System.out.print(heap[i] + " ");
        }
//        for (int i = 0; i < heap_size / 2; i++) {
//            System.out.print(" PARENT : " + heap[i] + " LEFT CHILD : " +
//                    heap[2 * i + 1] + " RIGHT CHILD :" + heap[2 * i + 2]);
//            System.out.println();
//        }
    }
}