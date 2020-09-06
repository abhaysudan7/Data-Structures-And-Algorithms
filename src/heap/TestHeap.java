package heap;

public class TestHeap {

    public static void main(String[] args) {

        BinaryHeap heap = new BinaryHeap(10);
        heap.minInsert(35);
        heap.minInsert(30);
        heap.minInsert(25);
        heap.minInsert(80);
        heap.minInsert(32);
        heap.minInsert(40);
        heap.minInsert(60);
        heap.minInsert(20);
        heap.minInsert(70);
        heap.minInsert(100);

        heap.printHeap();
        heap.buildMinHeap();
        heap.printHeap();
        heap.buildMaxHeap();
        heap.printHeap();
        heap.increaseKey(3, 110);
        heap.printHeap();
        heap.deleteKeyMaxHeap(1);
        heap.printHeap();

    }
}
