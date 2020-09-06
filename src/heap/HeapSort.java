package heap;

import java.util.Arrays;

public class HeapSort {

    static void buildMaxHeap(int[] arr, int n) {
        for (int i = (n - 2) / 2; i >= 0; i--) {
            maxHeapify(arr, n, i);
        }
    }

    private static void maxHeapify(int[] arr, int n, int i) {

        int left = 2 * i + 1, right = 2 * i + 2, largest = i;

        if (left < n && arr[left] > arr[i])
            largest = left;
        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            swap(arr, i, largest);
            maxHeapify(arr, n, largest);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Time Complexity : O(n*log(n))
     * Used in intro-sort(Quicksort + Heapsort(Control quicksort))
     * Improvement of selection-sort
     * Merge Sort & Quicksort better than Heap-Sort because of constants
     *
     * @param arr int[]
     * @param n   int
     */
    static void heapSort(int[] arr, int n) {
        buildMaxHeap(arr, n);
        for (int i = n - 1; i >= 1; i--) {
            swap(arr, 0, i);
            maxHeapify(arr, i, 0);
        }
    }


    public static void main(String[] args) {
        int[] arr = {10, 15, 50, 4, 20};
        heapSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
