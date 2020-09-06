package bitmagic;

import java.util.Arrays;

public class DecimalToBinary {


    static void decimalToBinary_arr(int x) {
        int[] binary_arr = new int[32];

        int i = 0;
        while (x > 0) {
            binary_arr[i] = x % 2;
            x = x / 2;
            i++;
        }
        for (int j = i - 1; j >= 0; j--) {
            System.out.print(binary_arr[j]);
        }
    }

    static void decimalToBinary_bit(int x) {
        for (int i = 31; i >= 0; i--) {
            int k = x >> i;
            if ((k & 1) > 0)
                System.out.print(1);
            else
                System.out.print(0);
        }
    }

    static int decimalToBinary(int x) {
        int p = 0;
        int res = 0;
        while (x > 0) {
            int rem = x % 2;
            double c = Math.pow(10, p);
            res += rem * c;
            p++;
            x = x / 2;
        }

        return res;
    }


    public static void main(String[] args) {
        int x = 19;
        decimalToBinary_arr(x);
        System.out.println();
        decimalToBinary_bit(x);
        System.out.println("\n" + decimalToBinary(x));
    }
}
