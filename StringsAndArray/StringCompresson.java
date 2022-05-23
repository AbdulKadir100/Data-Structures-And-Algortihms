package StringsAndArray;

public class StringCompresson {

    public static void main(String[] args) {
        String res = BuildCompressd("aabbbccaa");
        System.out.println(res);
    }

    /*Using StringBuilder to reduce time complexity o(n)*/
    public static String BuildCompressd(String str) {
        StringBuilder compress = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;
            if (i + 1 > str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compress.append(str.charAt(i));
                compress.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compress.length() < str.length() ? compress.toString() : str;
    }

    public static String Compressed(String str) {
        String compressed = "";
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed += "" + str.charAt(i) + countConsecutive;
                countConsecutive = 0;
            }
        }
        return compressed.length() < str.length() ? compressed : str;
    }
}
