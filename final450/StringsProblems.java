package final450;

import java.util.*;

import static GFGSelfPaced.DP.longestPalindromeSubseq;
import static GFGSelfPaced.Strings.*;


public class StringsProblems {
    static final int CHAR = 256;

    public static void main(String[] args) {
        System.out.println(isomorphic("aab", "xxz"));
    }
    public String removeConsecutiveCharacter2(String S){
        StringBuilder ss= new StringBuilder();
        char[] a = S.toCharArray();
        for(int i=0;i<S.length()-1;i++){
            if(a[i] != a[i+1]){
                ss.append(a[i]);
            }
        }
        return ss.toString();
    }
    static boolean isomorphic(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        int[] count = new int[256];
        int[] count2 = new int[256];

        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
            count2[s2.charAt(i)]++;

            if (count[s1.charAt(i)] != count2[s2.charAt(i)]) {
                return false;
            }
        }
        return true;
    }

    static int containANotherString(String a, String b) {
        int n = a.length(), m = b.length();
        int[] count = new int[256];
        int res = 0;
        //Counting both array items and then check both are equal size or not.
        for (int i = 0; i < n; i++) {
            count[a.charAt(i)]++;
            count[b.charAt(i)]--;
        }
        //Checking..
        for (int i = 0; i < 256; i++)
            if (count[i] != 0)
                return -1;
        int i = n - 1, j = m - 1;
        while (i >= 0) {
            if (a.charAt(i) != b.charAt(j)) {
                res++;
            } else
                j--;
            i--;
        }
        return res;

    }

    static boolean match(String wild, String pattern) {
        int n = wild.length(), m = pattern.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (wild.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?') {
                i++;
                j++;
            } else if (pattern.charAt(j) == '*')
                j++;
            else
                return true;
        }
        return false;
    }

    public static String removeConsecutiveCharacter(String S) {
        Stack<Character> sb = new Stack<>();
        char[] newString = new char[S.length()];
        sb.push(S.charAt(0));
        for (int i = 1; i < S.length(); i++) {
            if (sb.peek() != S.charAt(i) && !sb.isEmpty())
                sb.push(S.charAt(i));

        }
        int k = S.length() - 1;
        while (!sb.isEmpty()) {
            newString[k] = sb.pop();
            k--;
        }
        return new String(newString);
    }

    public static String smallestWindow(String s, String p) {
        int len1 = s.length(), len2 = p.length();
        if (len1 < len2)
            return "-1";
        int hash_pat[] = new int[256];
        int hash_str[] = new int[256];
        for (int i = 0; i < len2; i++) {
            hash_pat[p.charAt(i)]++;
        }
        int start = 0, start_index = -1, min_len = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < len1; i++) {
            hash_str[s.charAt(i)]++;

            if (hash_str[s.charAt(i)] <= hash_pat[s.charAt(i)])
                count++;
            if (count == len2) {
                //try to minimize window
                while (hash_str[s.charAt(start)] > hash_pat[s.charAt(start)] ||
                        hash_pat[s.charAt(start)] == 0) {
                    if (hash_str[s.charAt(start)] > hash_pat[s.charAt(start)]) {
                        hash_pat[s.charAt(start)]--;
                    }
                    start++;
                }
                //updating window size
                int win_len = i - start + 1;
                if (min_len > win_len) {
                    min_len = win_len;
                    start_index = start;
                }
            }

        }
        if (start_index == -1)
            return "-1";
        return s.substring(start_index, start_index + min_len);

    }

    public static List<List<String>> Anagrams(String[] string_list) {
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < string_list.length; i++) {
            char[] ch = string_list[i].toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);
            if (isAnagramEff(s, string_list[i])) {
                list.add(new ArrayList<>());
            }
        }
        return list;
    }

    static int makePalindrome(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        int begin = 0, end = n - 1, c = 0;
        while (begin < end) {
            if (sb.charAt(begin) != sb.charAt(end)) {
                sb.deleteCharAt(end);
                c++;
                end--;
            } else {
                begin++;
                end--;
            }

        }
        return c;
    }

    public static int findSubString(String str) {
        int n = str.length(), res = 0;
        int[] prev = new int[256];
        Arrays.fill(prev, -1);
        int i = 0;
        for (int j = 0; j < n; j++) {
            i = Math.max(i, prev[str.charAt(j)] + 1);
            int maxEnd = j - i + 1;
            res = Math.max(res, maxEnd);
            prev[str.charAt(j)] = j;
        }
        return res;
    }

    static int lcs(int x, int y, String s1, String s2) {
        int[][] dp = new int[x + 1][y + 1];
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                dp[0][j] = 0;
            }

        }
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                dp[i][0] = 0;
            }
        }
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[x][y];
    }


    static String secMostRepeat(String[] s) {
        int N = s.length;
        TreeMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            map.put(s[i], i);
        }
        int firs = Integer.MIN_VALUE, sec = Integer.MIN_VALUE;
        Iterator<Map.Entry<String, Integer>> entry = map.entrySet().iterator();
        while (entry.hasNext()) {
            Map.Entry<String, Integer> e2 = entry.next();
            int v = e2.getValue();
            if (v > firs) {
                sec = firs;
                firs = v;
            } else if (v > sec && v != firs)
                sec = v;
        }
        entry = map.entrySet().iterator();
        while (entry.hasNext()) {
            Map.Entry<String, Integer> e1 = entry.next();
            int v = e1.getValue();
            if (v == sec)
                return e1.getKey();
        }

        return null;
    }

    static int minFlip(String str) {
        return Math.min(flipwithStarting(str, '0'), flipwithStarting(str, '1'));
    }

    static int flipwithStarting(String str, char exp) {
        int flipCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != exp)
                flipCount++;
            exp = flip(exp);
        }
        return flipCount;
    }

    static char flip(char c) {
        return (c == '0') ? '1' : '0';
    }

    public static int minFlips(String S) {
        int flip = 0;
        int i = 0, j = S.length() - 1;
        while (i < j) {
            if (S.charAt(i + 1) == S.charAt(i) || S.charAt(j) == S.charAt(j - 1)) {
                swap(S.charAt(i + 1), S.charAt(j - 1));
                i++;
                j--;
                flip++;
            }
        }
        return flip;
    }

    static int romantoInt(String str) {
        int ans = 0, num = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            switch (str.charAt(i)) {
                case 'I':
                    num = 1;
                    break;
                case 'V':
                    num = 5;
                    break;
                case 'X':
                    num = 10;
                    break;
                case 'L':
                    num = 50;
                    break;
                case 'C':
                    num = 100;
                    break;
                case 'D':
                    num = 500;
                    break;
                case 'M':
                    num = 1000;
                    break;
            }
            if (4 * num < ans)
                ans -= num;
            else
                ans += num;
        }
        return ans;
    }

    static int countRev(String expr) {
        int len = expr.length();

        if (len % 2 != 0) {
            return -1;
        }

        Stack<Character> s = new Stack<>();
        int stackLen = 0;
        int n = 0;
        for (int i = 0; i < len; i++) {
            char ch = expr.charAt(i);
            if (ch == '}' && !s.isEmpty()) {
                if (s.peek() == '{')
                    s.pop();
                else
                    s.push(ch);
            } else {
                s.push(ch);
            }
            stackLen = s.size();
            n = 0;
            while (!s.isEmpty() && s.peek() == '{') {
                s.pop();
                n++;
            }

        }

        return (stackLen / 2 + n % 2);
    }

    static int countPalinString(String str) {
        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[0][j] = 0;
            }
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][0] = 0;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (str.charAt(i - 1) == str.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[n][n];
    }

    static int longestValidParentheses(String s) {
        Stack<Character> st = new Stack<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                char c = st.peek();
                if (c == ')')
                    count++;
                else
                    st.push(s.charAt(i));
            }
            st.push(s.charAt(i));
        }
        return (st.isEmpty()) ? 0 : count;
    }


    static boolean parathesisCheck(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (st.isEmpty() && (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']')) {
                return false;
            } else {
                if (s.charAt(i) == ')') {
                    char top = st.peek();
                    if (top == '(')
                        st.pop();
                    else
                        return false;
                } else if (s.charAt(i) == '}') {
                    char top = st.peek();
                    if (top == '{')
                        st.pop();
                    else
                        return false;
                } else if (s.charAt(i) == ']') {
                    char top = st.peek();
                    if (top == '[')
                        st.pop();
                    else
                        return false;
                } else {
                    st.push(s.charAt(i));
                }
            }

        }
        if (st.isEmpty())
            return true;
        else
            return false;
    }

    static int split01String(String str) {
        int count0 = 0, count1 = 0, count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0')
                count0++;
            else
                count1++;
            if (count0 == count1)
                count++;
        }
        return count;
    }

    static int longestPalin(String S) {
        return longestPalindromeSubseq(S);

    }

    static int longRepeat(String str) {
        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[0][j] = 0;
            }
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][0] = 0;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][n];
    }

    static void findDuplicate(String str) {
        int[] cont = new int[CHAR];
        for (int i = 0; i < str.length(); i++) {
            cont[str.charAt(i)]++;
        }
        for (int i = 0; i < CHAR; i++) {
            if (cont[i] > 1) {
                System.out.print((char) i + " count: " + cont[i]);
            }
        }
    }

    public static void reverseString(char[] s) {
        int n = s.length;
        int l = 0, r = n - 1;
        while (l < r) {
            char t = s[l];  //Swapping(l,r).
            s[l] = s[r];
            s[r] = t;

            l++;
            r--;
        }
        System.out.println(s);
    }

    static void swap(char a, char b) {
        char t = a;
        a = b;
        b = t;
    }
}
 