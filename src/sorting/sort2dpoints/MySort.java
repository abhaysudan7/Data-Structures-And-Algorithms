package sorting.sort2dpoints;

import java.util.Comparator;

/**
 * points sorted according to x-axis value
 * with use of Comparator interface
 */
public class MySort implements Comparator<Point> {

    @Override
    public int compare(Point a, Point b) {
        return a.x - b.x;
    }
}
