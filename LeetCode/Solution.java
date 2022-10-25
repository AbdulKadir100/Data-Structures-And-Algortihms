package LeetCode;


import ExploreTCS.*;

import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Scanner;

class Comp implements Comparator<Bill> {
    public int compare(Bill b1, Bill b2) {
        return (b1.getBillNo() - b2.getBillNo());
    }
}

class Sort implements Comparator<Bill> {
    @Override
    public int compare(Bill o1, Bill o2) {
        return (int) (o1.getBillAmount() - o2.getBillAmount());
    }
}

class Solution {
    static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb1 = new StringBuilder();

    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList<>();
        int m = words1.length,n = words2.length;
        String s1= words2[0],s2=words2[1];
        for(int i=0;i<m;i++){
            if(words1[i].contains(s1) && words1[i].contains(s2)){
                res.add(words1[i]);
            }
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) throws IOException {
        String[] eq = new String[]{"a==b","b!=a"};
        equationsPossible(eq);
    }
    public static boolean equationsPossible(String[] equations) {
        int[] count = new int[0];

        for(int i=0;i<equations.length;i++){
            String ch = equations[i];
            for (int j=0;j<ch.length();j++){
                count = Arrays.copyOf(count,count.length+1);
                count[ch.charAt(i)]++;
            }

        }
        System.out.println(Arrays.toString(count));
        return false;
    }
    public static void rotateByk(int[] arr, int k) {
        int n = arr.length, idx = 1;
        if (k < 0 || k > n) return;
        int[] res = new int[n];
        res[0] = arr[0];
        for (int i = k + 1; i < n; i++) {
            res[idx++] = arr[i];
        }
        for (int i = 1; i < n - k; i++) {
            res[idx++] = arr[i];
        }
        System.out.println(Arrays.toString(res));

    }

    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        for (int x : nums) count[x]++;
        int avoid = 0, using = 0, prev = -1;

        for (int k = 0; k <= 10000; ++k)
            if (count[k] > 0) {
                int m = Math.max(avoid, using);
                if (k - 1 != prev) {
                    using = k * count[k] + m;
                    avoid = m;
                } else {
                    using = k * count[k] + avoid;
                    avoid = m;
                }
                prev = k;
            }
        return Math.max(avoid, using);
    }

    public static Books[] sortBooksByPrice(Books[] b) {
        for (int i = 0; i < b.length - 1; i++) {
            for (int k = 0; k < b.length - i - 1; k++) {
                if (b[k].getPrice() > b[k + 1].getPrice()) {
                    Books temp = b[k];
                    b[k] = b[k + 1];
                    b[k + 1] = temp;
                }
            }
        }
        return b;
    }

    public static Document[] docsWithOddPages(Document[] docs) {
        Document[] docs2 = new Document[0];
        for (Document d : docs) {
            if (d.getPages() % 2 != 0) {
                docs2 = Arrays.copyOf(docs2, docs2.length + 1);
                docs2[docs2.length - 1] = d;
            }
        }
        for (int i = 0; i < docs2.length - 1; i++) {
            for (int j = 0; j < docs2.length - i - 1; j++) {
                if (docs2[j].getId() > docs2[j + 1].getId()) {
                    Document temp = docs2[j];
                    docs2[j] = docs2[j + 1];
                    docs2[j + 1] = temp;
                }
            }
        }
        return docs2;
    }

    public static Bill[] findBillWithMaxBillAmountBasedOnStatus(Bill[] bills, boolean par) {
        Bill[] b = new Bill[0];

        for (Bill value : bills) {
            if (value.isStatus() == par) {
                b = Arrays.copyOf(b, b.length + 1);
                b[b.length - 1] = value;
            }
        }
        if (b.length == 0)
            return null;

        for (int i = 0; i < b.length - 1; i++) {
            for (int j = 0; j < b.length - i - 1; j++) {
                if (b[j].getBillAmount() > b[j + 1].getBillAmount()) {
                    Bill temp = b[j];
                    b[j] = b[j + 1];
                    b[j + 1] = temp;
                }
            }
        }

        return b;
    }

    public static int findBillWithMaxCountBasedOnType(Bill[] bills, String type) {
        int count = 0;
        for (Bill bill : bills) {
            if (bill.getTypeOfConnection().equalsIgnoreCase(type)) {
                count++;
            }
        }
        return count;
    }

    public static Point pointWithHighestOriginDistance(Point p1, Point p2, Point p3) {
        double d1 = Math.sqrt(p1.getX1() * p1.getX1() + p1.getY1() * p1.getY1());
        double d2 = Math.sqrt(p2.getX1() * p2.getX1() + p2.getY1() * p2.getY1());
        double d3 = Math.sqrt(p3.getX1() * p3.getX1() + p3.getY1() * p3.getY1());
        return d1 > d2 ? (d1 > d3 ? p1 : p3) : (d2 > d3 ? p2 : p3);
    }

    public static double findDistance(Point p1, Point p2) {
        double dx = Math.abs(p2.getX2() - p1.getX1());
        double dy = Math.abs(p2.getY2() - p1.getY1());
        return Math.sqrt(dx * dx + dy * dy);
        // return  0.0;
    }

    public static void printStudent() {
        //Scanner sc = new Scanner(System.in);
        //Student[] students = new Student[4];

//        for (int i=0;i<students.length;i++){
//            int rollno = sc.nextInt();
//            sc.nextLine();
//            String name = sc.next();
//            String branch = sc.next();
//            double score= sc.nextDouble();
//            boolean dayscholar = sc.nextBoolean();
//            students[i] = new Student(rollno,name,branch,score,dayscholar);
//        }
//        System.out.println(findCountOfDayscholarStudents(students));
//        Student s = findStudentwithSecondHighestScore(students);
//        System.out.println(s.getRollNo()+"#"+s.getName()+"#"+s.getScore());
    }

    public static Student findStudentwithSecondHighestScore(Student[] students) {
        Student[] s2 = new Student[0];


        for (Student student : students) {
            if (!student.isDayScholar()) {
                s2 = Arrays.copyOf(s2, s2.length + 1);
                s2[s2.length - 1] = student;

            }
        }
        for (int i = 0; i < s2.length; i++) {
            for (int j = 0; j < s2.length - i - 1; j++) {
                if (s2[j].getScore() > s2[j + 1].getScore()) {
                    Student temp = s2[j];
                    s2[j] = s2[j + 1];
                    s2[j + 1] = temp;
                }
            }
        }
        //System.out.println(Arrays.toString(s2));
        Student s = new Student();

        return s2[s2.length - 2];
    }

    public static int findCountOfDayscholarStudents(Student[] students) {
        int count = 0;
        for (Student student : students) {
            if (student.isDayScholar() && student.getScore() > 80) {
                count++;
            }
        }
        return count;
    }

    public static Player[] searchPlayerForMatch(String side, Player[] players) {
        Player[] pl = new Player[0];
        for (Player player : players) {
            if (player.getSide().equalsIgnoreCase(side)) {
                pl = Arrays.copyOf(pl, pl.length + 1);
                pl[pl.length - 1] = player;
            }
        }
        return pl;
    }

    public static double[] findAverageOfRuns(Player[] players, int target) {
        double averageRun[] = new double[0];
        for (int i = 0; i < players.length; i++) {
//            if(players[i].getNoOfMatchesPlayed() >= target){
//                averageRun = Arrays.copyOf(averageRun, averageRun.length+1);
//                averageRun[averageRun.length-1] = (double)(players[i].getTotalRunScored()/players[i].getNoOfMatchesPlayed());
//            }
        }
        return averageRun;
    }

    public static Integer[] medicinePriceForGivenDiseas(Medicine[] medicine, String disease) {

        Integer[] arr = new Integer[4];
        int j = 0;
        for (int i = 0; i < 4; i++) {
            if (medicine[i].getDiseas().equals(disease)) {
                arr[j++] = medicine[i].getPrice();
            }
        }
        Arrays.sort(arr);

        return arr;

    }

    public int getMaximumGenerated(int n) {
        int[] arr = new int[n + 1];
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        for (int i = 2; i < n + 1; i++) {
            arr[i * 2] = arr[i];
            arr[2 * i + 1] = arr[i] + arr[i + 1];
        }
        int res = 0;
        for (int i = 0; i < n + 1; i++) {
            res = Math.max(res, i);
        }
        return res;
    }

    public static int numSplits(String s) {
        int rc[] = new int[26], lc[] = new int[26], l = 0, r = 0, res = 0;
        for (char c : s.toCharArray()) if (rc[c - 'a']++ == 0) r++;
        for (char c : s.toCharArray()) {
            if (lc[c - 'a']++ == 0) l++;
            if (--rc[c - 'a'] == 0) r--;
            if (l == r) res++;
        }
        return res;

    }

    public static int isVowelOrCons(String str) {
        int n = str.length();
        int cv = 0, cc = 0;
        for (int i = 0; i < n; i++) {
            if (isVowel(str.charAt(i))) {
                cv++;
            }
            if (isConsonant(str.charAt(i))) {
                cc++;
            }
        }
        //Or print(cv+" "+cc);
        return cv + cc;
    }

    static boolean isVowel(char ch) {
        // To handle lower case
        ch = Character.toUpperCase(ch);

        return (ch == 'A' || ch == 'E' ||
                ch == 'I' || ch == 'O' ||
                ch == 'U') && ch >= 65 && ch <= 90;
    }

    static boolean isConsonant(char ch) {
        // To handle lower case
        ch = Character.toUpperCase(ch);

        return !(ch == 'A' || ch == 'E' ||
                ch == 'I' || ch == 'O' ||
                ch == 'U') && ch >= 65 && ch <= 90;
    }

    public static int trappingWater(int[] arr) {
        int a = arr[0];
        int temp = 0, ans = 0;
        for (int i = 1; i < arr.length; ++i) {
            if (a - arr[i] < 0) {
                ans += temp;
                temp = 0;
                a = arr[i];
            }
            temp += a - arr[i];

        }
        return ans;
    }

    public int[] intersect(int[] arr, int[] brr) {

        HashSet<Integer> set = new HashSet<>();
        for (int j : arr) {
            set.add(j);
        }
        ArrayList<Integer> r = new ArrayList<>();
        int res = 0, j = 0;
        for (int i : brr) {
            if (set.contains(i)) {
                //res++;
                r.add(i);
                // set.remove(i);
            }
        }
        int[] ans = new int[r.size()];
        for (int i = 0; i < r.size(); i++) {
            ans[i] = r.get(i);
        }
        return ans;
    }

    public static void reverseString(char[] s) {
        int n = s.length;
        int i = n - 1;
        while (i >= 0) {
            System.out.print(s[i] + " ");
            i--;
        }
    }

    public int[] twoSum(int[] nums, int target) {
        TreeMap<Integer, Integer> hm = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(target - nums[i])) {
                return new int[]{i + 1, hm.get(target - nums[i]) + 1};
            }
            hm.put(nums[i], i);
        }
        return (new int[]{});
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        //Arrays.binarySearch(nums1,2);
        while (i < m + n) {
            if (nums1[i] <= nums2[j]) {
                nums1[i] = nums1[i];
                i++;
            } else {
                nums1[i] = nums2[j];
                j++;
            }
        }
        System.out.println(Arrays.toString(nums1));

    }

    public String sortString(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        while (map.size() > 0) {
            for (int i = 0; i < 26; i++) {
                char k = (char) (97 + i);
                if (map.containsKey(k)) {
                    sb.append(k);
                    map.put(k, map.get(k) - 1);
                    if (map.get(k) == 0) map.remove(k);
                }
            }

            for (int j = 25; j >= 0; j--) {
                char i = (char) (97 + j);
                if (map.containsKey(i)) {
                    sb.append(i);
                    map.put(i, map.get(i) - 1);
                    if (map.get(i) == 0) map.remove(i);
                }

            }
        }
        return sb.toString();

    }

    public static int lengthOfLastWord(String s) {
        int n = s.length(), space = 1;
        boolean spac = false;
        StringBuilder sb = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ')
                sb.append(s.charAt(i));
            else if (spac && s.charAt(i) == ' ')
                break;
            else
                spac = true;
        }
        return sb.length();
    }

    public int strStr(String haystack, String needle) {
        if (needle == null)
            return 0;
        if (haystack.equals(needle))
            return 0;
        if (haystack.contains(needle)) {
            return needle.indexOf(needle);
        } else {
            return -1;
        }
    }

    public static String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index == -1)
            return word;
        StringBuilder sb = new StringBuilder();

        for (int i = index; i >= 0; i--) {
            sb.append(word.charAt(i));
        }
        sb.append(word.substring(index + 1, word.length()));
        return sb.toString();

    }

    public static String restoreString(String s, int[] indices) {
        char[] ch = new char[s.length()];
        int n = indices.length;
        for (int i = 0; i < n; i++) {
            ch[indices[i]] = s.charAt(i);
        }
        return new String(ch);
    }

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int l = 0, h = n - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (target > nums[mid]) {
                l = mid + 1;
            } else if (target < nums[mid]) {
                h = mid - 1;
            } else {
                return mid;
            }
        }
        return l;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();

        for (String value : wordDict) {
            set.add(value);
        }
        return set.contains(s);
    }

    public String isSubset(long a1[], long a2[], long n, long m) {
        boolean f = false;
        HashSet<Long> set = new HashSet<>();
        for (long i : a1) {
            set.add(i);
        }
        for (long i : a2) {
            if (set.contains(i)) {
                f = true;
            }
        }
        if (f)
            return "Yes";
        else
            return "No";
    }


    public String fractionToDecimal(int numerator, int denominator) {
        return "";
    }

    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            mat[0][i] = original[i];
        }
        for (int i = m; i < m + n; i++) {
            mat[1][i - m] = original[i];
        }
        return mat;
    }

    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            }
        }
        System.out.println(Arrays.toString(nums));
        return n;
    }

    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int res = 0, j;
        for (int i = 0; i < n; i++) {
            j = i + 1;
            if (nums[j] > nums[i]) {
                res = Math.max(res, nums[j] - nums[i]);
            } else {
                res = -1;
            }
        }
        return res;
    }

    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            s.add(num);
        }
        int pre_fix = 0;
        if (s.contains(p))
            return 0;
        else
            return -1;
    }

    public int repeatedNTimes(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int i : nums) {
            if (!s.contains(i)) {
                return i;
            }
            s.add(i);
        }
        return -1;
    }

    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        char[] c = s.toCharArray();
        int count = map.get(c[0]);
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            if (m.getValue() != count)
                return false;
        }
        return true;
    }

    public static int[] smallerNumbersThanCurrent2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = nums.length - 1; j >= 0; j--) {
                if (nums[i] > nums[j] && i != j) {
                    count++;
                }
            }
            result.add(count);
        }
        int index = 0;
        int[] newArray = new int[result.size()];
        for (int n : result) {
            newArray[index++] = n;
        }
        return newArray;

    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        int count = 0, sum = 0;
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j >= 0; j--) {
                if (nums[i] > nums[j] && i != j) {
                    count++;
                }
            }
            list.add(count);
        }
        int k = 0;
        int[] arr = new int[list.size()];
        for (int n : list) {
            arr[k++] = n;
        }
        return arr;
    }

    public static void lapindrome() throws IOException {
        int tn = Integer.parseInt(br.readLine());
        String s = br.readLine();
        if (tn != s.length())
            return;


        String str = s.toLowerCase();
        char[] ch = str.toCharArray();
        int l = ch.length;
        boolean isFound = false;
        String n = s.substring(0, str.length() - 1);

        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.reverse();
        int count = 0;
        for (int i = 0, j = tn - 1; i < j; i++, j++) {
            if (ch[i] == ch[j])
                count++;
        }
        if (sb.equals(n))
            System.out.println(n);
        System.out.println(count);


    }

    public static int CountPS(char str[], int n) {
        int sum = 0;

        int dp[][] = new int[n][n];

        boolean P[][] = new boolean[n][n];

        for (int i = 0; i < n; i++)
            P[i][i] = true;


        for (int i = 0; i < n - 1; i++) {
            if (str[i] == str[i + 1]) {
                P[i][i + 1] = true;
                dp[i][i + 1] = 1;
            }
        }

        for (int gap = 2; gap < n; gap++) {
            // Pick starting point for current gap
            for (int i = 0; i < n - gap; i++) {
                // Set ending point
                int j = gap + i;

                // If current string is palindrome
                if (str[i] == str[j] && P[i + 1][j - 1])
                    P[i][j] = true;

                // Add current palindrome substring ( + 1)
                // and rest palindrome substring (dp[i][j-1]
                // + dp[i+1][j]) remove common palindrome
                // substrings (- dp[i+1][j-1])
                if (P[i][j])
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j]
                            + 1 - dp[i + 1][j - 1];
                else
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j]
                            - dp[i + 1][j - 1];
            }

        }
        // return total palindromic substrings
        return dp[0][n - 1];

    }

    public static int[] shuffle(int[] nums, int n) {
        int[] arr = new int[2 * n];
        for (int i = 0; i < nums.length; i++) {
            if ((i + 1) % 2 == 0) {
                arr[i] = arr[i];
            } else {
                arr[i] = nums[n];
            }
        }
        return arr;

    }

    public static int maxFrequency(int[] A, int k) {
        int res = 1, i = 0, j;
        long sum = 0;
        Arrays.sort(A);
        for (j = 0; j < A.length; ++j) {
            sum += A[j];
            while (sum + k < (long) A[j] * (j - i + 1)) {
                sum -= A[i];
                i += 1;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;

    }

    public static void getPermutation() {
//        int t = sc.nextInt();
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] ar = new int[n];

            for (int i = 0; i < n; i++) {
                ar[i] = sc.nextInt();
            }
            int[] ar2 = new int[n];
            for (int i = 0; i < n; i++) {
                ar2[ar[i] - 1] = i + 1;
            }
            if (Arrays.equals(ar, ar2))
                System.out.println("ambiguous");
            else
                System.out.println("not ambiguous");
        }
    }


    static long aVeryBigSum(long[] ar) {
        long res = 0;
        int l = ar.length;
        for (int i = 0; i < l; i++) {
            res += ar[i];
        }
        return res;

    }

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int count = 0, count2 = 0;
        List<Integer> list = new ArrayList<>();
        int asz = a.size();
        int bsz = b.size();
        for (int i = 0, j = 0; j < bsz && i < asz; j++, i++) {
            if (a.get(i) > b.get(j))
                count++;
            if (a.get(i) < b.get(j))
                count2++;
        }
        list.add(count);
        list.add(count2);
        return list;
    }

    public static void getPairSum() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = sc.nextInt();
            }
            Arrays.sort(a);
            int r = 0;
            for (int i = 0; i < 1; i++) {
                r = a[i] + a[i + 1];
            }
            System.out.println(r);
        }

    }

    public static void getSalary() {
        double res1 = 0, res2;
        int t = sc.nextInt();
        while (t-- > 0) {

            double salary = sc.nextInt();

            if (salary < 1500) {
                res1 = salary + (salary / 10) + (salary * 9) / 10;
                System.out.println(res1);
            }
            if (salary >= 1500) {
                res2 = salary + 500 + (salary * 9.8) / 10;
                System.out.println(res2);
            }

        }
    }

    public static int numIdenticalPairs(int[] nums) {
        int i, count = 0;
        for (i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j] && i < j) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean checkIfPangram(String sentence) {
        String s = sentence.toLowerCase();

        boolean[] mark = new boolean[26];
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            if ('a' <= s.charAt(i) && s.charAt(i) <= 'z') {
                index = s.charAt(i) - 'a';
            } else
                continue;
            mark[index] = true;
        }
        for (int i = 0; i <= 25; i++)
            if (!mark[i])
                return false;

        return true;
    }

    public static int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        return fib(n - 2) + fib(n - 1);
    }

}