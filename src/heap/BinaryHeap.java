package heap;

import java.util.Arrays;

public class BinaryHeap {

    int[] arr;
    int size;
    int capacity;

    public BinaryHeap(int capacity) {
        arr = new int[capacity];
        size = 0;
        this.capacity = capacity;
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int left(int i) {
        return (2 * i) + 1;
    }

    public int right(int i) {
        return (2 * i) + 2;
    }

    void minInsert(int x) {
        if (size == capacity) return;
        size++;
        arr[size - 1] = x;
        for (int i = size - 1; i >= 0 && (arr[parent(i)] > arr[i]); i = parent(i)) {
            swap(arr, i, parent(i));
        }
    }

    void maxInsert(int x) {
        if (size == capacity) return;
        size++;
        arr[size - 1] = x;

        for (int i = size - 1; i >= 0 && (arr[parent(i)] < arr[i]); i = parent(i)) {
            swap(arr, i, parent(i));
        }
    }

    /**
     * Time Complexity : O(h)
     * Space Complexity : O(h)
     *
     * @param i int
     */
    void minHeapify(int i) {
        int lt = left(i), rt = right(i);
        int smallest = i;

        if (lt < size && arr[lt] < arr[i])
            smallest = lt;
        if (rt < size && arr[rt] < arr[smallest])
            smallest = rt;

        if (smallest != i) {
            swap(arr, i, smallest);
            minHeapify(smallest);
        }
    }

    /**
     * Time Complexity : O(h)
     * Space Complexity : O(h)
     *
     * @param i int
     */
    void maxHeapify(int i) {
        int lt = left(i), rt = right(i);
        int largest = i;

        if (lt < size && arr[lt] > arr[i])
            largest = lt;
        if (rt < size && arr[rt] > arr[largest])
            largest = rt;

        if (largest != i) {
            swap(arr, i, largest);
            maxHeapify(largest);
        }
    }

    /**
     * Time Complexity : O(log(h))
     * Space Complexity : O(log(h))
     *
     * @return
     */
    int extractMin() {
        if (size == 0)
            return Integer.MAX_VALUE;

        if (size == 1) {
            size--;
            return arr[0];
        }
        swap(arr, 0, size - 1);
        size--;
        minHeapify(0);
        return arr[size];
    }

    int extractMax() {
        if (size == 0)
            return Integer.MIN_VALUE;

        if (size == 1) {
            size--;
            return arr[0];
        }
        swap(arr, 0, size - 1);
        size--;
        maxHeapify(0);
        return arr[size];
    }

    /**
     * Time Complexity : O(log(h))
     * Space Complexity : O(log(h))
     *
     * @param idx int
     * @param x   int
     */
    void decreaseKey(int idx, int x) {
        if (idx >= size) return;
        arr[idx] = x;

        for (int i = idx; i >= 0 && (arr[parent(i)] > arr[i]); i = parent(i)) {
            swap(arr, i, parent(i));
        }
    }

    /**
     * Time Complexity : O(log(h))
     * Space Complexity : O(log(h))
     *
     * @param idx int
     * @param x   int
     */
    void increaseKey(int idx, int x) {
        if (idx >= size || idx < 0) return;
        arr[idx] = x;

        for (int i = idx; i >= 0 && (arr[parent(i)] < arr[i]); i = parent(i)) {
            swap(arr, i, parent(i));
        }
    }

    void deleteKeyMinHeap(int idx) {
        decreaseKey(idx, Integer.MIN_VALUE);
        extractMin();
    }

    void deleteKeyMaxHeap(int idx) {
        increaseKey(idx, Integer.MAX_VALUE);
        extractMax();
    }

    void buildMinHeap() {
        for (int i = (size - 2) / 2; i >= 0; i--) {
            minHeapify(i);
        }
    }

    void buildMaxHeap() {
        for (int i = (size - 2) / 2; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
