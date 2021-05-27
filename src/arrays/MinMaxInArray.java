package arrays;

public class MinMaxInArray {

    static class Pair {
        int min;
        int max;
    }

    /**
     * func : getMinMax
     * Approach: Efficient, Tournament Method
     * Time: O(n)
     * Aux Space: O(1)
     *
     * @param arr  int[]
     * @param low  int
     * @param high int
     * @return Pair {@link Pair}
     */
    private static Pair getMinMax(int[] arr, int low, int high) {
        Pair minMax = new Pair();

        if (low == high) {
            minMax.min = arr[low];
            minMax.max = arr[low];
            return minMax;
        }

        if (high == low + 1) {
            if (arr[low] > arr[high]) {
                minMax.min = arr[high];
                minMax.max = arr[low];
            } else {
                minMax.min = arr[low];
                minMax.max = arr[high];
            }
            return minMax;
        }

        int mid = (low + high) / 2;
        Pair mmL = getMinMax(arr, low, mid);
        Pair mmR = getMinMax(arr, mid + 1, high);

        //Compare min of two parts
        minMax.min = Math.min(mmL.min, mmR.min);

        //Compare max of two parts
        minMax.max = Math.max(mmL.max, mmR.max);

        return minMax;
    }

    public static void main(String[] args) {
        int[] arr = {1000, 11, 445, 1, 330, 3000};
        int arr_size = 6;
        Pair minMax = getMinMax(arr, 0, arr_size-1);
        System.out.printf("\nMinimum element is %d", minMax.min);
        System.out.printf("\nMaximum element is %d", minMax.max);
    }
}
