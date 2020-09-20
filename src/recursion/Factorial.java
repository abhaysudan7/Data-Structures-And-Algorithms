package recursion;

public class Factorial {

    static int factorial(int n) { // hypothesis

        if (n == 0 || n == 1) // base
            return 1;

        return n * factorial(n - 1); // Induction
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}
