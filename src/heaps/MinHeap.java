package heaps;

public class MinHeap {
    private int[] heap;
    //to indicate the current index
    private int heap_size;
    //to indicate total capacity of heap
    private int max_size;

    public MinHeap(int max_size) {
        this.max_size = max_size;
        heap = new int[max_size];
        this.heap_size = 0;
    }

    public int parentIndex(int i) {
        return (i-1)/2;
    }

    public int left(int i) {
        return 2 * i + 1;
    }

    public int right(int i) {
        return 2 * i + 2;
    }

    public void insert(int key) {
        if(heap_size == max_size) {
            System.out.println("Overflow!!");
            return;
        }
        heap_size++;
//        System.out.println(heap_size);
        int i = heap_size - 1;
//        System.out.println(i);
        heap[i] = key;

        while(i!=0 && heap[i] < heap[parentIndex(i)]) {
            swap(i, parentIndex(i));
            i=parentIndex(i);
        }
    }

    private void swap(int child, int parent) {
        int temp = heap[child];
        heap[child] = heap[parent];
        heap[parent] = temp;
    }

    public int extractMinakaPoll() {
        if(heap_size < 0) {
            return Integer.MAX_VALUE;
        }
        if(heap_size == 1) {
            heap_size--;
            return heap[0];
        }

        int root = heap[0];
        heap[0] = heap[heap_size-1];
        heap_size--;
        minHeapify(0);

        return root;
    }

    private void minHeapify(int i) {
        int left = left(i);
        int right = right(i);
        int smallest = i;

        if(left < heap_size && heap[left] < heap[i]) {
            smallest = left;
        }
        if(right < heap_size && heap[right] < smallest) {
            smallest = right;
        }

        if(smallest != i) {
            swap(i, smallest);
            minHeapify(smallest);
        }
    }

    public void removeByValue(int value) {
        int i;
        for(i=0;i<heap.length;i++) {
            if(heap[i] == value) {
                break;
            }
        }
        removeByIndex(i);
    }

    public void removeByIndex(int index) {
        decreaseKey(index, Integer.MIN_VALUE);
        extractMinakaPoll();
    }

    private void decreaseKey(int i, int minValue) {
        heap[i] = minValue;
        while(i!=0 && heap[i] < heap[parentIndex(i)]) {
            swap(heap[i], heap[parentIndex(i)]);
            i = parentIndex(i);
        }
    }

    public void print() {

        for (int i=0;i<heap_size;i++) {
            System.out.print(heap[i] + " ");
        }

//        for (int i = 0; i < heap_size / 2; i++) {
//            System.out.print(" PARENT : " + heap[i] + " LEFT CHILD : " +
//                    heap[2 * i + 1] + " RIGHT CHILD :" + heap[2 * i + 2]);
//            System.out.println();
//        }
    }
}
