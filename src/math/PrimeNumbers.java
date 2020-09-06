package math;

public class PrimeNumbers {

    static void printAllPrime(int n) {
        boolean[] prime = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            prime[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j = j + i) {
                    prime[j] = false;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            if (prime[i]) {
                System.out.print(i + " ");
            }
        }

    }

    static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int x = 61;
        printAllPrime(x);
        int y = 61;
        System.out.println("\nIs " + y + " prime? " + isPrime(y));
    }

}
