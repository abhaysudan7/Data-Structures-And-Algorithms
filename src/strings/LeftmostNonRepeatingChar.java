package strings;

public class LeftmostNonRepeatingChar {

    static final int CHAR = 256;

    /**
     * func : leftmostNonRep_n
     * Approach: Naive approach
     * Time: O(n^2)
     * Aux Space: O(1)
     *
     * @param str {@link String}
     * @return int
     */
    static int leftmostNonRep_n(String str) {
        for (int i = 0; i < str.length(); i++) {
            boolean flag = false;
            for (int j = 0; j < str.length(); j++) {
                if (i != j && str.charAt(i) == str.charAt(j)) {
                    flag = true;
                    break;
                }
            }
            if (!flag)
                return i;
        }
        return -1;
    }

    /**
     * func : leftmostNonRep_e
     * Approach: Better approach
     * Time: O(n)
     * Aux Space: O(1)
     *
     * @param str {@link String}
     * @return int
     */
    static int leftmostNonRep_e(String str) {
        int[] count = new int[CHAR];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] == 1)
                return i;
        }
        return -1;
    }

    /**
     * main method
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        System.out.println(leftmostNonRep_n("geeksforgeeks"));

        System.out.println(leftmostNonRep_e("geeksforgeeks"));

    }
}
