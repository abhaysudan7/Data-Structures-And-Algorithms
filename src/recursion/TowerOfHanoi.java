package recursion;

public class TowerOfHanoi {

    static int count = 0;

    static void towerOfHanoi(int n, char A, char B, char C) {
        count++;
        if (n == 1) {
            System.out.println("Move disc " + n + " from " + A + " to " + C);
            return;
        }
        towerOfHanoi(n - 1, A, C, B);
        System.out.println("Move disc " + n + " from " + A + " to " + C);
        towerOfHanoi(n - 1, B, A, C);
    }


    public static void main(String[] args) {
        towerOfHanoi(4, 'A', 'B', 'C');
        System.out.println(count);
    }
}
