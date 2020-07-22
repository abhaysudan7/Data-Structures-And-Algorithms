package strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeftmostRepeatingChar {

    static final int CHAR = 256;

    /**
     * func : leftmost_n
     * Approach: Naive approach
     * Time: O(n^2)
     * Aux Space: O(1)
     *
     * @param s1 {@link String}
     * @return int
     */
    static int leftmost_n(String s1) {
        for (int i = 0; i < s1.length(); i++) {
            for (int j = i + 1; j < s1.length(); j++) {
                if (s1.charAt(i) == s1.charAt(j)) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * func : leftmost_e1
     * Approach: Efficient approach
     * Time: O(n)
     * Aux Space: O(1)
     *
     * @param s1 {@link String}
     * @return int
     */
    static int leftmost_e1(String s1) {
        int[] count = new int[CHAR];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (count[s1.charAt(i)] > 1)
                return i;
        }
        return -1;
    }

    /**
     * func : leftmost_e2
     * Approach: Efficient approach
     * Time: O(n)
     * Aux Space: O(1)
     *
     * @param s1 {@link String}
     * @return int
     */
    static int leftmost_e2(String s1) {
        int[] fIndex = new int[CHAR];
        Arrays.fill(fIndex, -1);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < s1.length(); i++) {
            int fi = fIndex[s1.charAt(i)];
            if (fi == -1)
                fIndex[s1.charAt(i)] = i;
            else
                res = Math.min(res, fi);
        }
        return (res == Integer.MAX_VALUE ? -1 : res);
    }

    /**
     * func : leftmost_e3
     * Approach: Efficient approach
     * Time: O(n)
     * Aux Space: O(1)
     *
     * @param s1 {@link String}
     * @return int
     */
    static int leftmost_e3(String s1) {
        boolean[] visited = new boolean[CHAR];
        int res = -1;
        for (int i = s1.length() - 1; i >= 0; i--) {
            if (visited[s1.charAt(i)])
                res = i;
            else
                visited[s1.charAt(i)] = true;
        }
        return res;
    }

    /**
     * main method
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        System.out.println(leftmost_n("geeksforgeeks"));
        System.out.println(leftmost_n("abbcc"));
        System.out.println(leftmost_n("abcd"));

        System.out.println(leftmost_e1("geeksforgeeks"));
        System.out.println(leftmost_e1("abbcc"));
        System.out.println(leftmost_e1("abcd"));

        System.out.println(leftmost_e2("geeksforgeeks"));
        System.out.println(leftmost_e2("abbcc"));
        System.out.println(leftmost_e2("abcd"));

        System.out.println(leftmost_e3("geeksforgeeks"));
        System.out.println(leftmost_e3("abbcc"));
        System.out.println(leftmost_e3("abcd"));

    }
}
