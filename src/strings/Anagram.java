package strings;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

    static final int CHAR = 256;

    /**
     * func : checkAnagram_n
     * Approach: Naive approach
     * Time: O(n*log(n))
     * Aux Space: O(n)
     *
     * @param s1 {@link String}
     * @param s2 {@link String}
     * @return boolean
     */
    static boolean checkAnagram_n(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        char[] a1 = s1.toCharArray();
        Arrays.sort(a1);
        s1 = new String(a1);

        char[] a2 = s2.toCharArray();
        Arrays.sort(a2);
        s2 = new String(a2);

        return s1.equals(s2);
    }

    /**
     * func : checkAnagram_e
     * Approach: Efficient approach
     * Time: O(n)
     * Aux Space: O(1)
     *
     * @param s1 {@link String}
     * @param s2 {@link String}
     * @return boolean
     */
    static boolean checkAnagram_e(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        int[] count = new int[CHAR];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }
        for (int i = 0; i < CHAR; i++) {
            if (count[i] != 0)
                return false;
        }
        return true;
    }

    /**
     * main method
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        String s1 = "listen", s2 = "silent";
        System.out.println("Is '" + s1 + "' anagram of '" + s2 + "'? " + checkAnagram_n(s1, s2));

        s1 = "aabc";
        s2 = "bbac";
        System.out.println("Is '" + s1 + "' anagram of '" + s2 + "'? " + checkAnagram_n(s1, s2));

        s1 = "aabcb";
        s2 = "bbaca";
        System.out.println("Is '" + s1 + "' anagram of '" + s2 + "'? " + checkAnagram_e(s1, s2));

    }
}
