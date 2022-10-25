package GFGSelfPaced;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.*;
import java.lang.*;
import java.util.HashSet;
import java.util.Set;

import static CodeChef.CodeChefProblems.swap;


public class Strings {

    static final int CHAR = 256;
public static String StringChellenge(String str){
    str= str.toLowerCase().replaceAll("\\W","");
    if (isPalindrome(str))
        return "true";
    return "false";
}
    public static void main(String[] args) {
        fn("bubble");
        
    }
    public static String reverseWords(String s){
        String[] sarr = s.split(" ");
        StringBuilder res = new StringBuilder();

        for(int i=0;i< sarr.length;i++){
            
            res.insert(0,sarr[i]);
            res.insert(0," ");
        }
        return res.toString().trim();
    }
    public static void fn(String input){
        Map<Character,Integer> map = new HashMap<>();
        for(Character c : input.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int count=0;
        System.out.println(map);
        for(Map.Entry<Character,Integer> e:map.entrySet()){
            if (e.getKey().equals('b'))
                count = e.getValue();
        }
        System.out.println(count);
    }
    public static boolean oddeven(int n){
        return n % 2 == 0;
    }
    public static int lengthOfLongestSubstring(String s) {
        /*
        Given a string s, find the length of the longest substring
        without repeating characters.
        Input: s = "abcabcbb"
        Output: 3
        Explanation: The answer is "abc", with the length of 3.
         */
        int n = s.length(), res = 0;
        int[] prev = new int[256];
        Arrays.fill(prev, -1);
        int i = 0;
        for (int j = 0; j < n; j++) {
            i = Math.max(i, prev[s.charAt(j)] + 1);
            int maxEnd = j - i + 1;
            res = Math.max(res, maxEnd);
            prev[s.charAt(j)] = j;
        }
        return res;
    }
    static boolean arePermutation(char str1[], char str2[])
    {
        /*
        Time = O(n) , Space = O(n)
         */
        int NO_OF_CHARS=256;

        int[] count1 = new int [NO_OF_CHARS];
        int[] count2 = new int [NO_OF_CHARS];
        int i;
        for (i = 0; i <str1.length && i < str2.length ;
             i++)
        {
            count1[str1[i]]++;
            count2[str2[i]]++;
        }
        // fail for strings like "aaca" and "aca"
        if (str1.length != str2.length)
            return false;

        // Compare count arrays
        for (i = 0; i < NO_OF_CHARS; i++)
            if (count1[i] != count2[i])
                return false;

        return true;
    }
    public boolean checkPermutation(String s1, String s2) {
    /*
    Given two strings check if s1 is the permutation of s2 or not.
    example, “abcd” and “dabc” are Permutation of each other.
    Hint:
    Method 1 (Use Sorting)
    1) Sort both strings
    2) Compare the sorted strings
    Time = O(nlogn)(if merge sort invoke) else O(n^2) in case quick sort
    space = O(1)
    */
        if(s1.length() > s2.length())
            return false;
        int[] ct1 = new int[26];
        int[] ct2 = new int[26];
        for(int i=0;i<s1.length();i++){ //Count all the char int the String s1.
            ct1[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<s2.length();i++){
            ct2[s2.charAt(i)-'a']++;
            if(i>=s1.length()){
                ct2[s2.charAt(i-s1.length())-'a']--;
            }
            if(Arrays.equals(ct1,ct2)) return true;
        }
        return false;

    }
    public static boolean isPresent(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();
        int[] ct = new int[CHAR];
        int[] cp = new int[CHAR];
        for (int i = 0; i < m; i++) {
            ct[txt.charAt(i)-'a']++;
            cp[pat.charAt(i)-'a']++;
        }
        for (int i = m; i < n; i++) {
            if (ct[txt.charAt(i)] == 1)
                return true;
        }
        return false;
    }

    public static boolean checkStringRotation(String s, String goal) {
        //if (s.length() != goal.length()) return false;
        return (s + s).contains(goal);
    }

    public static void patternMatchEfficient(String txt, String patt) {
        //Bayer Moore Algorithm
        int m = patt.length();
        int n = txt.length();
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (patt.charAt(j) != txt.charAt(i + j))
                    break;
            }
            if (j == m)
                System.out.print(i + " ");
            if (j == 0)
                i++;
            else
                i = i + j;
        }
    }
    public String multiply(String num1, String s) {
        int n = num1.length();
        List<String> many = new ArrayList<>();
        for (int i=0; i<n; i++) {
            many.add(new String(s));
        }
        return many.toString();
    }

    public static void spatternMatch(String txt, String patt) {
        int m = patt.length();
        int n = txt.length();
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (patt.charAt(j) != txt.charAt(i + j))
                    break;
            }
            if (j == m)
                System.out.print(i + " ");
        }
    }

    public static String reverseWord(String s) {
        char[] str = s.toCharArray();
        int start = 0;
        for (int end = 0; end < str.length; end++) {
            if (str[end] == ' ') {
                reverseString(str, start, end - 1);
                start = end + 1;
            }
        }
        reverseString(str, start, str.length - 1);
        reverseString(str, 0, str.length - 1);
        return new String(str);
    }

    public static void reverseString(char[] str, int low, int high) {
        while (low <= high) {
            swap(str, str[low], str[high]);
            low++;
            high--;
        }
    }

    public static void swap(char[] s, int low, int high) {
        char str = s[low];
        s[low] = s[high];
        s[high] = str;

    }

    private static int nonRept(String str) {
        int[] count = new int[CHAR];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] == 1)
                return i;
        }
        return -1;
    }

    public static int leftmostRepeatEfficient(String str) {
        boolean[] visited = new boolean[CHAR];
        int res = -1;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (visited[str.charAt(i)])
                res = i;
            else
                visited[str.charAt(i)] = true;
        }
        return res;
    }

    public static int leftmostRepeat2(String str) {
        int[] findex = new int[CHAR];

        Arrays.fill(findex, -1);
        int res = Integer.MAX_VALUE; //Infinite
        for (int i = 0; i < str.length(); i++) {
            int fi = findex[str.charAt(i)];
            if (fi == -1)
                findex[str.charAt(i)] = i;
            else
                res = Math.min(res, fi);

        }
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }

    public static int leftmostRepeat(String str) {
        int[] count = new int[CHAR];
        for (int i = 0; i < str.length(); i++) {   //Counting total Character appearing in the string.
            count[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if ((count[str.charAt(i)]) > 1)        //If char  appear more then one time, return it immediately
                return i;
        }
        return -1;
    }

    public static boolean isAnagramEff(String s1,String s2){
        if (s1.length() != s2.length())
            return false;
        int[] count = new int[256];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }
        for (int i = 0; i < 256; i++) {
            if (count[i]!=0)
                return false;
        }
        return true;
    }
    public static boolean isAnagram(String s, String t) {
        /*
        E.g, God is anagram Dog
         */
        if (s.length() != t.length())
            return false;
        char[] a = s.toCharArray();
        Arrays.sort(a);
        s = new String(a);
        char[] a2 = t.toCharArray();
        Arrays.sort(a2);
        t = new String(a2);
        return s.equals(t);
    }
 
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int j = 0;
        for (int i = 0; i < n && j < m; i++) {
            if (s.charAt(i) == t.charAt(j))
                j++;
        }
        return (j == m);
    }


    public static boolean isPalindrome(String str) {
        int begin = 0, end = str.length() - 1;
        while (begin < end) {
            if (str.charAt(begin) != str.charAt(end))
                return false;
            begin++;
            end--;
        }
        return true;
    }

    public int numMatchingSubseq(String s, String[] words) {
        int sl = s.length();
        int wordl = words.length;
        int j = 0, count = 0;
        for (int i = 0; i < wordl && j < sl; i++) {
            if (words[i].charAt(i) == s.charAt(j)) {
                j++;
                count++;
            }
        }
        return count;
    }
}
