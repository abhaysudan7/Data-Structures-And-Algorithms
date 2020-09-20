package math;

public class ReverseInteger {

    public static int reverse(int A) {

        boolean isNegative = false;
        if (A < 0) {
            isNegative = true;
        }
        int num = Math.abs(A);
        int rev = 0, prev_num = 0;

        while (num != 0) {
            int digit = (num % 10);
            rev = (rev * 10) + digit;
            if ((rev - digit) / 10 != prev_num)
                return 0;
            prev_num = rev;
            num = num / 10;
        }
        if (isNegative) {
            return rev * (-1);
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-1146467285));
    }
}
