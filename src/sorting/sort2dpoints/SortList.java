package sorting.sort2dpoints;

import java.util.ArrayList;
import java.util.Collections;

public class SortList {
    public static void main(String[] args) {
        ArrayList<Point> a = new ArrayList<>();
        a.add(new Point(10, 20));
        a.add(new Point(3, 12));
        a.add(new Point(5, 7));

        /**
         * Sorting list on the basis of MySort class
         * using Collections.sort function
         */
        Collections.sort(a, new MySort());

        for (Point p :
                a) {
            System.out.println(p.x + " " + p.y);
        }
    }
}
