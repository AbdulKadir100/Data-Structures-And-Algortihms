package Algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class AlgoOnString {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(onEditAway("pale","bale"));
    }

    static boolean onEditAway(String first, String second) {
        if (Math.abs(first.length()-second.length())>1)
            return false;
        // Get Shorter and longer String.
        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second:first;

        int index1=0;
        int index2=0;
        boolean foundDiffrence = false;
        while (index2 < s2.length() && index1 < s1.length()){

            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (foundDiffrence)    //Ensure that this frst diff.
                    return false;
            }
            foundDiffrence = true;
            if (s1.length() == s2.length()){
                index1++;
            }else {
                index1++;

            }
            index2++;
        }
        return true;
    }

    public static String longestSubstring(String s) {
        int n = s.length();
        int max_count = 0;
        String res = "";
        for (int i = 0; i < n; i++) {
            //Odd Lenght
            int l = i;
            int r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                int curr_l = r - l + 1;
                if (curr_l > max_count) {
                    res = s.substring(l, r + 1);
                    max_count = curr_l;
                }
                l--;
                r++;
            }
            //Even Length
            l = i;
            r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                int curr_l = r - l + 1;
                if (curr_l > max_count) {
                    res = s.substring(l, r + 1);
                    max_count = curr_l;
                }
                l--;
                r++;
            }

        }
        return res;
    }

    public static boolean isMatching(String[] s, String[] p) {
        int n = s.length;
        int m = p.length;

        for (int i = 0; i <= m - n; i++) {
            boolean isFound = true;
            for (int j = 0; j < m; j++) {
                if (!s[i + j].equals(p[j])) {
                    isFound = false;
                    break;
                }


            }
            if (isFound)
                return true;

        }
        return true;
    }
}
