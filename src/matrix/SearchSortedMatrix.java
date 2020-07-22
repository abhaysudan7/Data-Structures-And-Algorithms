package matrix;

public class SearchSortedMatrix {

    /**
     * func : search_n
     * Approach: Naive approach
     * Time: O(r*c)
     * Aux Space: O(1)
     *
     * @param arr int[]
     * @param x   int
     */
    static void search_n(int[][] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == x) {
                    System.out.println("Found at row: " + ++i + " col: " + ++j);
                    return;
                }
            }
        }
        System.out.println("Not Found");
    }

    /**
     * func : search_e
     * Approach: Efficient approach
     * Time: O(r+c)
     * Aux Space: O(1)
     *
     * @param arr int[]
     * @param x   int
     */
    static void search_e(int[][] arr, int x) {
        int r = arr.length, c = arr[0].length;
        int i = 0, j = c - 1;
        while (i < r && j >= 0) {
            if (arr[i][j] == x) {
                System.out.println("Found at row: " + ++i + " col: " + ++j);
                return;
            } else if (arr[i][j] > x)
                j--;
            else
                i++;
        }
        System.out.println("Not Found");
    }

    /**
     * main method
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        int[][] arr = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };
        search_n(arr, 29);

        int[][] arr1 = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };
        search_e(arr1, 35);
    }
}
