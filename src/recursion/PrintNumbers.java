package recursion;

public class PrintNumbers {

    static void print(int n) {
        if (n == 0)
            return;
        print(n - 1);
        System.out.print(n + " ");
    }

    static void print_reverse(int n) { //hypothesis
        if (n == 0) //base
            return;
        System.out.print(n + " "); // Induction
        print_reverse(n - 1);
    }

    public static void main(String[] args) {
        print(7);
        System.out.println();
        print_reverse(7);
    }
}
