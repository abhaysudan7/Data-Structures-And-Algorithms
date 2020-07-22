package sorting.sort2dpoints;

import java.util.Arrays;

/**
 * Sorting 2D points array using Arrays.sort function
 */
public class SortArray {
    public static void main(String[] args) {
        Point[] arr = {
                new Point(10, 20),
                new Point(3, 12),
                new Point(5, 7)
        };

        /**
         * Sorting Array on the basis of MySort class
         * using Arrays.sort function
         */
        Arrays.sort(arr, new MySort());

        for (Point p :
                arr) {
            System.out.println(p.x + " " + p.y);
        }
    }
}
