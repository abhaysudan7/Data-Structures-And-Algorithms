package strings;

public class LeetCode_28 {

    public static int strStr(String haystack, String needle) {
        int n = needle.length();
        if (n == 0) return 0;
        for (int i = 0; i < (haystack.length() - n + 1); i++) {
            if ((haystack.substring(i, i + n)).equals(needle)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issip"));
    }
}
