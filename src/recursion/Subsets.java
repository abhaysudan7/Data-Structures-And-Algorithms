package recursion;

public class Subsets {

    static void subSets(String input, String output) {
        if (input.length() == 0) {
            System.out.println(output);
            return;
        }
        String op2 = output + input.charAt(0);
        input = input.substring(1);

        subSets(input, output);
        subSets(input, op2);
    }

    public static void main(String[] args) {
        subSets("abc", "");
    }
}
