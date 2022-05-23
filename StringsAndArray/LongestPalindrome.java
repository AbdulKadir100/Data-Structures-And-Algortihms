package StringsAndArray;

public class LongestPalindrome {
    private static String max_String = "";

    public static void main(String[] args) {

        String s = "geeks";
        isPalindrome(s);

    }

    private static void isPalindrome(String str) {

        for (int i = 1; i < str.length(); i++) {
             StringBuilder s1 = new StringBuilder(str.substring(0, i));
            StringBuilder s2 = new StringBuilder(str.substring(0, i));
            s2.reverse();
            if (s1.toString().equals(s2.toString())) {
                if (max_String.length() <= s1.length()) {
                    max_String = s1.toString();
                }
            }
        }
        System.out.println("Max is : " + max_String);

    }
}
