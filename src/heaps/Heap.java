package heaps;

public class Heap {
    public static void main(String[] args) {
        MinHeap min = new MinHeap(10);
        MaxHeap max = new MaxHeap(10);

        min.insert(3);
        min.insert(5);
        min.insert(6);
        min.insert(1);
        min.insert(9);
        min.insert(8);
        min.extractMinakaPoll();

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
