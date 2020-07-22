package matrix;

public class SpiralTraversal {

    /**
     * func : printSpiral
     * Time: Θ(r*c)
     * Aux Space: Θ(1)
     *
     * @param arr int[]
     */
    static void printSpiral(int[][] arr, int r, int c) {
        int top = 0, left = 0, bottom = r - 1, right = c - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                System.out.print(arr[top][i] + " ");
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                System.out.print(arr[i][right] + " ");
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    System.out.print(arr[bottom][i] + " ");
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(arr[i][left] + " ");
                }
                left++;
            }
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

        printSpiral(arr, arr.length, arr[0].length);
    }
}
