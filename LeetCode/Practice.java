package LeetCode;

import FastRead.FastReader;


import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}

class ParkingSystem {
    public int big, medium, small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        if (carType == 1 && big-- > 0) return true;
        else if (carType == 2 && medium-- > 0) return true;
        else if (carType == 3 && small-- > 0) return true;
        else return false;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class OrderedStream {

    private int pointer;
    private final String[] array;

    public OrderedStream(int n) {
        array = new String[n];
    }

    public List<String> insert(int idKey, String value) {
        array[idKey - 1] = value;
        List<String> getlist = new ArrayList<>();
        if (array[pointer] == null)
            return new ArrayList<>();
        for (int i = pointer; i < array.length; i++) {
            if (array[i] == null) {
                pointer = i;
                break;
            }
            getlist.add(array[i]);

        }
        return getlist;
    }
}


public class Practice {
    public static void main(String[] args) throws IOException {

    }

    public int finalValueAfterOperations(String[] operations) {
          int n = operations.length,count=0;
        for (int i = 0; i < n; i++) {
            String s1 = operations[i];
            if (s1.equals("++X"))
                count++;
            else if (s1.equals("X++"))
                count++;
            else if (s1.equals("--X"))
                count--;
            else
                count--;
        }
        return count;
    }

    public static int countSquares(int[][] matrix) {
        int H = matrix.length;
        int W = matrix[0].length;

        int[][] dp = new int[H][W];
        int count=0;

        //Filling First Row
        for (int i = 0; i < W; i++) {
              dp[0][i] = matrix[0][i];
              count+=dp[0][i];
        }
        //Filling First Column
        for (int i = 0; i < H; i++) {
            dp[i][0] = matrix[i][0];
            count+=dp[i][0];
        }
        //Finding all other cell
        for (int i = 1; i < H; i++) {
            for (int j = 1; j < W; j++) {
               if (matrix[i][j]==1){
                   dp[i][j] = 1+(Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1])));
                   count+=dp[i][j];
               }
            }
        }
        return count;
    }

    public static int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxpro = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i]<minprice){
                minprice = prices[i];
            }else if (prices[i]-minprice > maxpro){
                 maxpro  = prices[i]-minprice;
            }
        }
        return maxpro;
    }
    public static int[] countBits(int n) {
        int[] result = new int[n+1];
        result[0] = 0;
        int i;
        for (i = 1; i <= n; i++) {
              if (i%2==0){
                  result[i] = result[i/2];
              }else {
                  result[i] = 1+result[i-1];
              }
        }
        return result;
    }
    public static void multPlyTwoMatrics(){
        int[][] mat = new int[][]{
                {1, -2}, {2, -3}
        };
        int h = mat.length;
        int w = mat[0].length;
        int res=0;
        for (int row = 0; row < h-1; row++) {
            for (int col = 0; col < w-1; col++) {
                res += mat[col][row]*mat[col+1][row+1];
            }
        }
        System.out.println(res);
    }
    public static int mod(int a, int m)
    {
        return (a%m + m) % m;
    }
    public static String removeOuterParentheses(String s) {
         int count=0;
         StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i)=='(' && s.charAt(i+1) == ')'){
                sb.append(s.charAt(i));
                sb.append(s.charAt(i+2));
            }

        }
        return sb.toString();
    }



    public static String sortSentence(String s) {
        String[] str = s.split(" ");
        String[] res = new String[str.length];
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String elem : str) {
            i = (int) (elem.charAt(elem.length() - 1) - '0');
            res[i - 1] = elem.substring(0, elem.length() - 1);
        }
        for (i = 0; i < res.length - 1; i++)
            sb.append(res[i]).append(" ");
        sb.append(res[i]);
        return sb.toString();
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuffer sb = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        for (String s : word1) {
            sb.append(s);
        }
        for (String s : word2) {
            sb2.append(s);
        }
        if (sb.toString().equals(sb2.toString()))
            return true;
        else
            return false;
    }

    public static int maxDepth(String s) {
        if (s.equals(""))
            return 0;
        else if (s.length() == 1) {
            if (s.charAt(0) >= 48 && s.charAt(0) <= 57) {
                return 0;
            }
        }
        int maxDepth = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                maxDepth = Math.max(stack.size(), maxDepth);
                stack.pop();
            }

        }

        return maxDepth;

    }

    public static void getLang() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            sc.nextLine();
            String[] ar = new String[k];
            for (int i = 0; i < k; i++) {
                ar[i] = sc.nextLine();
            }
            for (int i = 0; i < ar.length - 1; i++) {
                for (int j = 0; j < i; j++) {
                    if (Character.isLowerCase(ar[j].charAt(j)) == Character.isLowerCase(ar[j + 1].charAt(j + 1))) {
                        System.out.println("Yes");
                    } else if (Character.isLowerCase(ar[j].charAt(j)) == Character.isUpperCase(ar[j + 1].charAt(j + 1))) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No");
                    }
                }
                if (Character.isUpperCase(ar[i].charAt(i)) == Character.isUpperCase(ar[i + 1].charAt(i + 1)))
                    System.out.println("No");
            }
        }
    }

    public static void minTimeWork() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int m = sc.nextInt();
            int x = sc.nextInt();
            int d = sc.nextInt();
            int time_taken, upper_bound = 0, r;
            time_taken = m * x;
            upper_bound = m + d;
            r = Math.min(time_taken, upper_bound);
            System.out.println(r);
        }
    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null)
            return 0;
        if (root.val < low)
            return rangeSumBST(root.right, low, high);
        else if (root.val > high)
            return rangeSumBST(root.left, low, high);
        else
            return root.val + rangeSumBST(root.right, low, high) + rangeSumBST(root.left, low, high);
    }

    public static int xorOperation(int n, int start) {
        int[] num = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            num[i] = start + 2 * i;
        }

        for (int i = 0; i < n; i++) {
            sum = sum ^ num[i];

        }


        return sum;
    }

    public static int balancedStringSplit(String s) {
        int count = 0, rVal = 0, lVal = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'R')
                rVal++;
            if (c == 'L')
                lVal++;
            if (rVal == lVal)
                count++;

        }

        return count;
    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        int idx = ruleKey.equals("type") ? 0 : (ruleKey.equals("color") ? 1 : 2);
        return (int) items.stream().map(l -> l.get(idx)).filter(ruleValue::equals).count();
    }

    public static int removeDuplicates(int[] nums) {
        int i, j = 1;
        for (i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[j++] = nums[i + 1];
            }

        }
        // nums[j++] = nums[nums.length-1];
        return j;
    }

    public static void candies() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }
        int j = 0;
        for (int i = 0; i < n - 1; i++) {
            if (ar[i] > ar[i + 1])
                ar[j++] = ar[i];
            else
                ar[j++] = 1;
        }
        System.out.println(Arrays.toString(ar));
    }

    public int maxProduct(String[] words) {

        int len = words.length;
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j >= 0; j--) {

            }
        }

        return 0;
    }

    public static String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G') {
                sb.append("G");
            } else if (command.charAt(i) == '(' && command.charAt(i + 1) == ')') {
                sb.append("o");
                i++;
            } else {
                sb.append("al");
                i += 3;
            }
        }
        return sb.toString();
    }

    public static int[] createTargetArray(int[] nums, int[] index) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int ind = index[i];
            list.add(ind, num);
        }

        return list.parallelStream().mapToInt(i -> i).toArray();
    }

    public static int[] decode(int[] encoded, int first) {
        int[] ar_org = new int[encoded.length + 1];
        ar_org[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            ar_org[i + 1] = encoded[i] ^ ar_org[i];
        }
        return ar_org;
    }

    public static int[] decompressRLElist(int[] nums) {
        int siz = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            siz += nums[i];
        }
        int[] add_ar = new int[siz];
        int l = nums.length;
        //Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < l; i = i + 2) {
            int freq = nums[i];
            int val = nums[i + 1];
            for (int j = 0; j < freq; j++) {
                add_ar[count++] = val;
            }
        }
        return add_ar;
    }

    public static String restoreString(String s, int[] indices) {
        int len = s.length();
        String[] arr = new String[indices.length + 1];
        for (int i = 0, j = 0; i < len && j < len; i++, j += 2) {
            arr[j] = String.valueOf(indices[i]);
            arr[j + 1] = String.valueOf(indices[i + len]);
        }
        return Arrays.toString(arr);
    }

    public static int subtractProductAndSum(int n) {
        int sum = 0, pd = 1, res = 0;
        while (n != 0) {
            pd *= n % 10;
            sum += n % 10;
            n = n / 10;
        }

        return pd - sum;
    }

    public static int numberOfSteps(int num) {
        int count = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num /= 2;
                count++;
            } else {
                num -= 1;
                count++;
            }
        }


        return count;
    }

    public static int minCostOFMatrix(int[][] arr, int si, int sj, int ei, int ej) {
        int r = 0;
        if (si == ei && sj == ej)
            return arr[ei][ej];
        if (si > ei || sj > ej)
            return Integer.MAX_VALUE;
        int option1 = minCostOFMatrix(arr, si + 1, sj, ei, ej);
        int option2 = minCostOFMatrix(arr, si + 1, sj + 1, ei, ej);
        int option3 = minCostOFMatrix(arr, si, sj + 1, ei, ej);
        return arr[si][sj] + Math.min(option1, Math.min(option2, option3));

    }

    public static int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        char[] stone = stones.toCharArray();
        char[] jewel = jewels.toCharArray();
        for (char c : jewel) {
            for (char value : stone) {
                if (c == value)
                    count++;
            }
        }
        return count;
    }

    public static int subsetXORSum(int[] nums) {
        int res = 0, j;
        int cnt = (int) Math.pow(2, nums.length);
        for (int i = 0; i < cnt; i++) {
            int res2 = 0;
            for (j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0)
                    res2 ^= nums[j];
            }
            res += res2;
        }
        return res;
    }

    public static String truncateSentence(String s, int k) {
        int i = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') k--;
            if (k == 0) return s.substring(0, i);
            i++;
        }
        return s;

    }

    public static int largestAltitude(int[] gain) {
        int height = 0;
        int currHeight = 0;

        for (int i = 0; i < gain.length; i++) {

            currHeight += gain[i];

            if (height < currHeight) {
                height = currHeight;
            }

        }

        return height;
    }

    public static String replaceDigits(String s) {
        char[] c = s.toCharArray();
        for (int i = 1; i < s.length(); i++) {
            if (!Character.isLetter(c[i])) {
                c[i] = (char) (c[i - 1] + Character.getNumericValue(c[i]));
            }
        }
        return String.valueOf(c);
    }

    public static int maximumPopulation(int[][] logs) {
        int i = 1950;
        int max_pop = Integer.MIN_VALUE;
        int[] year = new int[2100];
        while (i <= 2050) {
            int count = 0;
            for (int[] log : logs) {
                int birth_yr = log[0];
                int death_yr = log[1];

                if (birth_yr <= i && death_yr > i) {
                    count++;
                }
                year[i] = count;
            }
            i++;
        }
        int ans = 0;
        for (i = 0; i < year.length; i++) {
            if (year[i] > max_pop) {
                max_pop = year[i];
                ans = i;
            }
        }
        return ans;
    }

    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    for (int k = j + 1; k < arr.length; k++) {
                        if ((Math.abs(arr[j] - arr[k]) <= b) && (Math.abs(arr[i] - arr[k]) <= c)) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static int getDecimalValue(ListNode head) {
        StringBuffer sbuffer = new StringBuffer();
        while (head != null) {
            sbuffer.append(head.val);
            head = head.next;
        }
        sbuffer.reverse().toString();
        int sum = 0, length = 1;

        for (int i = 0; i < sbuffer.length(); i++) {
            sum = sum + length * Character.getNumericValue(sbuffer.charAt(i));
            length = length * 2;
        }
        return sum;
    }

    public static int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for (int i = 1; i <= arr.length; i += 2) {
            for (int j = 0; j < arr.length - i + 1; j++) {
                for (int l = 0; l < i; l++) {
                    sum += arr[j + l];
                }
            }
        }

        return sum;
    }

    public static int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        char[] c = allowed.toCharArray();
        for (int i = 0; i < words.length; i++) {
            if (allowed.equals(words[i]))
                count++;
        }
        return count;
    }

    public static int[] shuffle(int[] nums, int n) {
        int[] arr = new int[nums.length];

        for (int i = 0, j = 0; i < n; i++, j += 2) {
            arr[j] = nums[i];
            arr[j + 1] = nums[i + n];
        }
        return arr;
    }

    public static String stringChallenge(String str) {
        String str2 = str.toLowerCase();
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            if (str2.charAt(i) == ' ') {
                System.out.print(" ");
                res += str2.charAt(i);

            } else {
                res += (int) str2.charAt(i);
            }

        }
        return res;
    }

    public static String defangIPaddr(String address) {
        String res = "";
        int l = address.length();
        for (int i = 0; i < l; i++) {
            if (address.charAt(i) == '.') {
                res += "[.]";
            } else {
                res += address.charAt(i);
            }
        }

        return res;
    }
}
