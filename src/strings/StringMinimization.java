package strings;


/**
 * Divide String in two non-empty parts
 * Swap both parts, if suffix of string 2 is same as prefix of string 1
 * after swap then reduce string from middle.
 */
public class StringMinimization {

    static int reduceString(String str) {


        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return str.length();
        }

        String str1 = str.substring(0, str.length() / 2);
        String str2 = str.substring(str.length() / 2);

        while (str2.length() > 0 && str2.charAt(str2.length() - 1) == str1.charAt(0)) {
            int i = str2.length() - 1;
            int j = 1;
            int count = 1;
            while (i > 0 && str2.charAt(i) == str2.charAt(i - 1)) {
                count++;
                i--;
            }
            str2 = str2.substring(0, str2.length() - count);

            count = 1;
            while (j < str1.length() && str1.charAt(j) == str1.charAt(j - 1)) {
                count++;
                j++;
            }
            str1 = str1.substring(count);
        }

        return (str2 + str1).length();
    }

    public static void main(String[] args) {
        String str = "aaaaaaaa";
        System.out.println(reduceString(str));
    }
}
