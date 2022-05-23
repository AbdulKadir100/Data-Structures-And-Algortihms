package StringsAndArray;

public class StringUnique {

    public static void main(String[] args) {
      char[] c = new char[]{'m','r',' ','j','h','o','n',' ','s','m','i','t','h'};
       replaceSpace(c,10);
        System.out.println(c);
    }



   public static void replaceSpace(char[] str, int truelenght) {
        int spacecount = 0, index, i = 0;
        for (i = 0; i < truelenght; i++) {
            if (str[i] == ' ') {
                spacecount++;
            }
        }
        index = truelenght + spacecount * 2;
        if (truelenght < str.length) str[truelenght] = '\0';
        for (i = truelenght - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                index--;
            }
        }
    }

    boolean isUniqueChars(String str) {
        if (str.length() > 128) return false;

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;

    }

    static boolean Permutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] letter = new int[128];
        //char[] s_array = s.toCharArray();
        for (char c : s.toCharArray()) {
            letter[c]++;
        }

        for (var i = 0; i < t.length(); i++) {
            var c = t.charAt(i);
            letter[c]--;
            if (letter[c] < 0) {
                return false;
            }

        }
        return true;
    }
}