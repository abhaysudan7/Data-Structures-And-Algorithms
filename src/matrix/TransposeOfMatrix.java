package matrix;

public class TransposeOfMatrix {

    /**
     * func : transposeMatrix_n
     * Approach: Naive approach
     * Time: O(n^2)
     * Aux Space: O(n^2)
     *
     * @param arr int[]
     * @param n   int
     */
    static void transposeMatrix_n(int[][] arr, int n) {
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = arr[j][i];
            }
        }
        for (int i = 0; i < n; i++) {
            System.arraycopy(temp[i], 0, arr[i], 0, n);
        }
    }

    /**
     * func : transposeMatrix_n
     * Approach: Efficient approach(In-place, One traversal)
     * Time: O(n^2)
     * Aux Space: O(n^2)
     *
     * @param arr int[]
     * @param n   int
     */
    static void transposeMatrix_e(int[][] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(arr, i, j);
            }
        }
    }

    static void swap(int[][] arr, int i, int j) {
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }

    static void printMatrix(int[][] arr) {
        for (int[] ints : arr) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * main method
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        transposeMatrix_n(arr, arr.length);
        printMatrix(arr);

        System.out.println();
        int[][] arr2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        transposeMatrix_e(arr2, arr2.length);
        printMatrix(arr2);


    }


}
