package heaps;

public class Heap {
    public static void main(String[] args) {
        MinHeap min = new MinHeap(10);
        MaxHeap max = new MaxHeap(10);

        min.insert(10);
        min.insert(8);
        min.insert(9);
        min.insert(7);
        min.insert(6);
        min.insert(5);
        min.insert(4);
        min.extractMinakaPoll();

        for(int i = (6/2)-1; i>=0;i--) {
            min.minHeapify(i);
        }


        min.print();

        max.insert(3);
        max.insert(5);
        max.insert(6);
        max.insert(1);
        max.insert(9);
        max.insert(8);

        max.print();
    }
}
