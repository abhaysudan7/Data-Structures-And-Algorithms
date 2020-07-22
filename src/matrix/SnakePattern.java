package matrix;

public class SnakePattern {

    /**
     * func : printBoundaryElements
     * Time: Θ(r+c)
     * Aux Space: Θ(1)
     *
     * @param arr int[][]
     */
    static void snakePattern(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
            } else {
                for (int j = arr[i].length - 1; j >= 0; j--) {
                    System.out.print(arr[i][j] + " ");
                }
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

        snakePattern(arr);
    }


}
