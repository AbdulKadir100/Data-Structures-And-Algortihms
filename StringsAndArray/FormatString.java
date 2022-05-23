package StringsAndArray;

import java.util.Scanner;

public class FormatString {

    static boolean oneEditAway(String first, String second) {
        if (first.length() == second.length()) {
            return oneEditAway(first, second);
        } else if (first.length() + 1 == second.length()) {
            return oneEditAway(first, second);
        } else if (first.length() - 1 == second.length()) {
            return oneEditAway(first, second);
        }
        return false;
    }

    static boolean onEditReplace(String s1, String s2) {
        boolean foundDiffrence = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                if (foundDiffrence) {
                    return false;
                }
            foundDiffrence = true;

        }
        return true;
    }

    static boolean onEditInsert(String s1, String s2) {
        int index = 0;
        int index2 = 0;
        while (index2 < s2.length() && index < s1.length()) {
            if (s1.charAt(index) != s2.charAt(index2)) {
                if (index != index2) {
                    return false;
                }
                index2++;
            } else {
                index++;
                index2++;
            }
        }
        return true;
    }

    boolean onEditWay(String first, String second) {
        /*Lets check length*/
        if (Math.abs(first.length() - second.length()) > 1) return false;

        /*Get shorter and longer*/
        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : second;

        int index1 = 0;
        int index2 = 0;
        boolean foudnDifference = false;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (foudnDifference) return false;
                foudnDifference = true;
                if (s1.length() == s2.length()) {
                    index1++;
                }
            } else {
                index1++;
            }
            index2++;
        }
        return true;
    }



    public static void main(String[] args) {
        boolean r = oneEditAway("Add", "A");
        System.out.println(r);
    }
}
