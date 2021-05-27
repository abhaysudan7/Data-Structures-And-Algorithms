package arrays;

import java.util.Arrays;

public class ReverseAnArray {

    private static void reverseArray(int[] arr, int arr_size) {
        int l = 0, r = arr_size - 1;
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1000, 11, 445, 1, 330, 3000};
        int arr_size = 6;
        reverseArray(arr, arr_size);
        System.out.print(Arrays.toString(arr));
    }
}
