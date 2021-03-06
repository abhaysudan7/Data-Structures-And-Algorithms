package matrix;

public class Rotate90Degree {

    /**
     * func : rotateMatrix_n
     * Approach: Naive approach
     * Time: O(n^2)
     * Aux Space: O(n^2)
     *
     * @param arr int[]
     * @param n   int
     */
    static void rotateMatrix_n(int[][] arr, int n) {
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[n - j - 1][i] = arr[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            System.arraycopy(temp[i], 0, arr[i], 0, n);
        }
    }

    /**
     * func : rotateMatrix_e
     * Approach: Efficient approach
     * Time: O(n^2)
     * Aux Space: O(n^2)
     *
     * @param arr int[]
     * @param n   int
     */
    static void rotateMatrix_e(int[][] arr, int n) {
        TransposeOfMatrix.transposeMatrix_e(arr, n);
        for (int i = 0; i < n; i++) {
            int low = 0, hi = n - 1;
            while (low < hi) {
                swap(arr, low, hi, i);
                low++;
                hi--;
            }
        }
    }

    static void swap(int[][] arr, int low, int hi, int i) {
        int temp = arr[low][i];
        arr[low][i] = arr[hi][i];
        arr[hi][i] = temp;
    }


    static void printMatrix(int[][] arr) {
        for (int[] ints : arr) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        rotateMatrix_n(arr, arr.length);
        printMatrix(arr);
        System.out.println();

        int[][] arr2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        rotateMatrix_e(arr2, arr2.length);
        printMatrix(arr2);
    }
}
