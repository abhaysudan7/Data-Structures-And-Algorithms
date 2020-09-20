package math;

public class PalindromeInteger {

    public static int isPalindrome(int A) {
        int n = (int) Math.log10(A)+1;
        int i = 1, j = n;
        while (i < j) {
            System.out.println((int)(A / Math.pow(10, j - 1)) % 10);
            System.out.println((int)((A % (Math.pow(10, i))) / (Math.pow(10, i - 1))));
            if ((int)(A / Math.pow(10, j - 1)) % 10 != (int)((A % (Math.pow(10, i))) / (Math.pow(10, i - 1)))) {
                return 0;
            }
            i++;
            j--;
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(2147447412));
    }
}
