package GreedyAndDP;

import FastRead.FastReader;

import java.util.*;
import GFGSelfPaced.Sorting;

import static GFGSelfPaced.Sorting.lomutoPartition;


class TreeNode {
    public int val;
    TreeNode root;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }
//    TreeNode(TreeNode rootval){
//        this.root = rootval;
//    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class MyHashMap {
    private int key;
    private int value;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap(int key, int value) {
        this.key = key;
        this.value = value;

    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {


    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        return this.key;

    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {

    }
}

public class LeetCodeProblems {
    private int[][] dp;
    TreeNode firstNode, secondNode, preNode;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }
//        wiggleSort(arr);
    }

    public static void wiggleSort(int[] nums) {
        int n=nums.length-1;
        //copy values to new array
        int[] newarr=Arrays.copyOf(nums,nums.length);
        //sort new array
        Arrays.sort(newarr);
        //old arr=1,5,1,1,6,4
        //new arr=1,1,1,4,5,6
        //now lets apply odd position and even position
        //odd position
        for(int i=1;i<nums.length;i+=2)
            nums[i]=newarr[n--];
        //even position
        for(int i=0;i<nums.length;i+=2)
            nums[i]=newarr[n--];
        System.out.println(Arrays.toString(nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int maxEnding = nums[0];
        var count=1;
        if (maxEnding >= target)
            return 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= target)
                return 1;
            maxEnding = Math.max(maxEnding + nums[i], nums[i]);
            if (maxEnding >= target)
                return maxEnding;
        }
        return 0;
    }

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        int i = 0;
        if (sb.charAt(i) == ' ' || sb.length() - 1 == ' ')
            return sb.substring(i + 1, sb.length() - 1);
        return sb.toString();
    }

    public static int compress(char[] chars) {
        String str = String.valueOf(chars);
        StringBuilder compressed = new StringBuilder();
        int consecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            consecutive++;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(consecutive);
                consecutive = 0;
            }
        }
        return compressed.length();

    }

    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[2 * nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
            ans[i + nums.length] = nums[i];
        }
        return ans;
    }

    public static int numSplits(String s) {
        int rc[] = new int[26], lc[] = new int[26], l = 0, r = 0, res = 0;
        for (char c : s.toCharArray()) {
            if (rc[c - 'a']++ == 0) r++;
        }
        for (char c : s.toCharArray()) {
            if (lc[c - 'a']++ == 0) l++;
            if (--rc[c - 'a'] == 0) r--;
            if (l == r) res++;
        }
        return res;
    }

    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j))
                i++;
            else
                j++;

        }
        if (i == s.length()) return true;
        return false;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index1 = 0, index2 = 0, med1 = 0, med2 = 0;
        for (int i = 0; i <= (nums1.length + nums2.length) / 2; i++) {
            med1 = med2;
            if (index1 == nums1.length) {
                med2 = nums2[index2];
                index2++;
            } else if (index2 == nums2.length) {
                med2 = nums1[index1];
                index1++;
            } else if (nums1[index1] < nums2[index2]) {
                med2 = nums1[index1];
                index1++;
            } else {
                med2 = nums2[index2];
                index2++;
            }
        }
        if ((nums1.length + nums2.length) % 2 == 0) {
            return (float) (med1 + med2) / 2;
        }
        return (float) med2;
    }

    public static boolean isValid(String s) {
        char[] open = new char[]{'(', '{', ']'};
        char[] close = new char[]{')', '}', ']'};
        boolean isTrue;

        if (s.equals("()") || s.equals("{}") || s.equals("[]"))
            return true;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == open[i]) {
                stack.push(s.charAt(i));
            }
            if (s.charAt(i) == close[i]) {
                stack.pop();
            }
        }

        isTrue = stack.isEmpty();
        return isTrue;
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0], nums[nums.length - 1]);
    }

    public int[] sortArrayByParity(int[] nums) {
        Integer[] B = new Integer[nums.length];
        for (int t = 0; t < nums.length; ++t)
            B[t] = nums[t];

        Arrays.sort(B, (a, b) -> Integer.compare(a % 2, b % 2));

        for (int t = 0; t < nums.length; ++t)
            nums[t] = B[t];
        return nums;
    }

    public static int maxProduct2(int[] nums) {
        Arrays.sort(nums);
        return Math.abs((nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1));
    }

    public static int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        return Math.abs(nums[nums.length - 1] * nums[nums.length - 2] - nums[0] * nums[1]);
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }


    public static int minPairSum(int[] nums) {
        int res = Integer.MIN_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; ++i)
            res = Math.max(res, nums[i] + nums[nums.length - i - 1]);
        return res;
    }

    public static String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        String[] c = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            c[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(c, (a, b) -> (b + a).compareTo(a + b));
        if (c[0].equals("0"))
            return "";
        for (String s : c) {
            sb.append(s);
        }
        return sb.toString();
    }

    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0, h = n - 1;
        int max = 0;
        while (l <= h) {
            int curr_max = Math.min(height[l], height[h]) * (h - l);
            max = Math.max(curr_max, max);
            if (height[l] <= height[h])
                l++;
            else
                h--;
        }
        return max;
    }

    public static void buildSegmentTree(int[] arr, int[] tree, int start, int end, int treenode) {
        if (start == end) {
            tree[treenode] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        buildSegmentTree(arr, tree, start, mid, 2 * treenode);
        buildSegmentTree(arr, tree, mid + 1, end, 2 * treenode + 1);
        tree[treenode] = tree[treenode] + tree[2 * treenode + 1];

    }

    public static int[] sort(int arr[], int l, int r) {

        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
        return arr;
    }

    public static boolean isPalindrome(int x) {
        boolean istrue = false;
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }

    public static int[] merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
        return arr;
    }


    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int n = s.length();
        int res = map.get(s.charAt(n - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1)))
                res -= map.get(s.charAt(i));
            else
                res += map.get(s.charAt(i));
        }
        return res;
    }

    public static String intToRoman(int num) {

        int[] no = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] code = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < no.length; i++) {
            while (num >= no[i]) {
                sb.append(code[i]);
                num -= no[i];
            }
        }

        return sb.toString();
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == targetSum;

        return hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        //checking the subtrees
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

    public void recoverTree(TreeNode root) {
        backtrace(root);
        int num = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = num;
    }

    public void backtrace(TreeNode root) {
        if (root == null) return;
        backtrace(root.left);
        if (preNode == null || preNode.val <= root.val) preNode = root; //update the preNode
        else //we found the wrong node
        {
            if (firstNode == null) firstNode = preNode;
            secondNode = root;
        }
        backtrace(root.right);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        dp = new int[triangle.size()][triangle.size()];
        return helper(0, 0, triangle);

    }

    int helper(int row, int column, List<List<Integer>> triangle) {
        if (row == triangle.size())
            return 0;
        if (dp[row][column] != 0)
            return dp[row][column];
        return dp[row][column] = triangle.get(row).get(column) +
                Math.min(helper(row + 1, column, triangle), helper(row + 1, column + 1, triangle));
    }

    public static boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10000];
        for (int c : deck) {
            count[c]++;
        }
        int g = -1;
        for (int i = 0; i < 10000; i++) {
            if (count[i] > 0) {
                if (g == -1) {
                    g = count[i];
                } else {
                    g = gcd(g, count[i]);
                }
            }
        }
        return g >= 2;

    }

    public static int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
//        if (b>a)
//            return gcd(b,a);
//        if (b==0)
//                return a;
//       return gcd(b%a,b);
    }

    public int rob(int[] nums) {
        int cont = 0;
        if (nums.length == 3)
            return Math.max(nums[0], Math.max(nums[1], nums[2]));
        for (int i = 0; i < nums.length; i = i + 2) {
            cont += nums[i];
        }
        return cont;
    }

    public static void Sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            isPrime[i] = true;
        }
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i] == true) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }

        }
        int count = 0;
        for (int i = 0; i <= n; i++) {
            if (isPrime[i] == true)
                count++;
        }
        System.out.println(count);

    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        // Base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            // The first row element is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }

    public static int maxProduct(int[] nums) {
        int result = nums[0];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int mul = nums[i];
            result = Math.max(result, mul);
            for (int j = i + 1; j < n; j++) {
                mul *= nums[j];
                result = Math.max(result, mul);
            }
        }
        return result;
    }

    public static int maxSubArray(int[] nums) {
        int max = Integer.MAX_VALUE;

        int sum = 0;
        if (nums[0] == 1)
            return 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + nums[i + 1] > 0) {
                sum += nums[i + 1];
            }
        }
        return sum;
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        boolean isTrue = false;
        if (matrix[0][0] == target)
            return true;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == target)
                    isTrue = true;
                else
                    isTrue = false;
            }

        }
        return isTrue;
    }

    public void setZeroes(int[][] matrix) {
        Boolean isCol = false;
        int R = matrix.length;
        int C = matrix[0].length;

        for (int i = 0; i < R; i++) {

            if (matrix[i][0] == 0) {
                isCol = true;
            }

            for (int j = 1; j < C; j++) {
                // If an element is zero, we set the first element of the
                // corresponding row and column to 0
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Iterate over the array once again and using
        // the first row and first column, update the elements.
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // See if the first row needs to be set to zero as well
        if (matrix[0][0] == 0) {
            for (int j = 0; j < C; j++) {
                matrix[0][j] = 0;
            }
        }

        // See if the first column needs to be set to zero as well
        if (isCol) {
            for (int i = 0; i < R; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public boolean isValidSudoku(char[][] board) {
        Set<Integer> hs = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch == '.') continue;
                int val = ch - '0';
                int rowKey = 100 * (i + 1) + val;
                int colkey = 1000 * (j + 1) + val;
                int blockKey = 10000 * ((int) (i / 3) + 1) + 1000 * ((int) (j / 3) + 1) + val;
                if (!hs.add(rowKey) || !hs.add(colkey) || !hs.add(blockKey))
                    return false;

            }

        }
        return true;

    }

    public static int countPrimes(int n) {
        if (n == 0 || n == 1)
            return 0;
        int count = 0;

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if ((i * i) == 0) {
                    count += 1;
                } else {
                    count += 2;
                }
            }

        }
        if (count == 2) {
            return count;
        }

        return count;

    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        if (nums.length == 0 || nums.length == 1)
            return 0;
        int arr_l = nums.length;
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < arr_l && diff != 0; ++i) {
            int low = i + 1, high = arr_l - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                    if (sum < target)
                        ++low;
                    else
                        --high;
                }
            }
        }
        return target - diff;

    }

    public boolean isValidBST(TreeNode root) {
        TreeNode cur;
        if (root == null)
            return false;
        if (root.val < root.left.val && root.val > root.right.val)
            return false;
        else
            return isValidBST(root);

    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int dp[] = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = nums[i] + dp[i - 1];
            if (nums[i] == 0 && nums[i - 1] == 0) return true;
            if (dp[i] % k == 0) return true;
        }

        if (dp[n - 1] < k) return false;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 2; j < n; j++) {
                if ((dp[j] - dp[i]) % k == 0) return true;
            }
        }
        return false;
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i];
            if (sum == k)
                count++;
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        int[] ar = new int[2];
        for (int i = 0; i < len - 1; i++) { //Put into list at runtime dynamically
            if (nums[i] + nums[i + 1] == target) {
                list.add(i);
                list.add(i + 1);
            }
        }
        //Convert into array to return the result.
        for (int i = 0; i < list.size(); i++) {
            ar[i] = list.get(i);
        }

        return ar;
    }


    public static String removeDuplicateLetters(String s) {
        Set<Character> set = new HashSet<>();
        StringBuilder br = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        for (Character s1 : set) {
            br.append(s1);
        }
        return br.toString();
    }

    public static int candy(int[] ratings) {
        int len = ratings.length;
        int rating = 0, minus = 0;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                len += (++rating);
            } else if (ratings[i - 1] == ratings[i]) {
                rating = 0;
            } else {
                len += (minus++);
                if (i + 1 == ratings.length || ratings[i] <= ratings[i + 1])
                    len += Math.max(minus - rating, minus = rating = 0);
            }
        }
        return len;
    }

    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } else if (s.length() == 1) {
            return (s.charAt(0) == '0') ? 0 : 1;
        } else {
            // compute the 2 initial values of the array (intuitively)
            int[] decodingsUpToChar = new int[s.length()];
            if (s.charAt(0) == '0') {
                return 0;
            } else {
                decodingsUpToChar[0] = 1;
            }
            if (s.charAt(1) == '0') {
                if (s.charAt(0) == '1' || s.charAt(0) == '2') {
                    decodingsUpToChar[1] = 1;
                } else {
                    decodingsUpToChar[1] = 0;
                }
            } else if (Integer.valueOf(s.substring(0, 2)) > 26) {
                decodingsUpToChar[1] = 1;
            } else {
                decodingsUpToChar[1] = 2;
            }

            // compute the rest of the array (Dynamic Programming)
            for (int i = 2; i < s.length(); i++) {
                if (s.charAt(i) != '0') {
                    decodingsUpToChar[i] += decodingsUpToChar[i - 1];
                }
                int twoDigitValue = Integer.valueOf(s.substring(i - 1, i + 1));
                if (twoDigitValue <= 26 && twoDigitValue >= 10) {
                    decodingsUpToChar[i] += decodingsUpToChar[i - 2];
                }
            }
            return decodingsUpToChar[s.length() - 1];
        }
    }

    public static void icpcballon() {
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            int[] ar = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = fr.nextInt();
            }
            for (int i = ar.length - 1; i >= 0; i++) {
                if (ar[i] > 7)
                    System.out.println();
                else
                    System.out.println(ar.length - (ar.length - i) + 1);
            }

        }
    }

    public static void visa() {
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        while (t-- > 0) {
            int x1 = fr.nextInt();
            int x2 = fr.nextInt();
            int y1 = fr.nextInt();
            int y2 = fr.nextInt();
            int z1 = fr.nextInt();
            int z2 = fr.nextInt();

            if (x1 >= x2 && y1 >= y2 && z1 > z2)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }

    public int minDistance(String word1, String word2) {
        var dp = new int[word1.length() + 1][word2.length() + 1];
        int row = dp.length;
        int col = dp[0].length;
        for (int i = 1; i < row; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }

        }
        return dp[row - 1][col - 1];

    }

    public static int minPathSum(int[][] grid) {
        var row = grid.length;
        var col = grid[0].length;

        //row path sums
        for (var i = 1; i < row; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        //col path sums
        for (int i = 1; i < col; i++) {
            grid[0][i] += grid[0][i - 1];
        }

        for (var i = 1; i < row; i++) {
            for (var j = 1; j < col; j++) {
                int topval = grid[i - 1][j];
                int dowval = grid[i][j - 1];
                grid[i][j] += Math.min(topval, dowval);
            }

        }
        return grid[row - 1][col - 1];

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean isFound = false;
        return binarysearch(matrix, target, 0, 0, row - 1, col - 1);


    }

    private static boolean binarysearch(
            int[][] mat,
            int targ,
            int lox,
            int loy,
            int hix,
            int hiy
    ) {
        if (lox > hix || loy > hiy) return false;
        int i = lox + (hix - lox) / 2;
        int j = loy + (hiy - loy) / 2;
        if (mat[i][j] < targ) {
            return binarysearch(mat, targ, lox, j + 1, i, hiy)
                    || binarysearch(mat, targ, i + 1, loy, hix, j)
                    || binarysearch(mat, targ, i + 1, j + 1, hix, hiy);
        } else if (mat[i][j] > targ) {
            return binarysearch(mat, targ, lox, j, i - 1, hiy)
                    || binarysearch(mat, targ, i, loy, hix, j - 1)
                    || binarysearch(mat, targ, lox, loy, i - 1, j - 1);
        } else {
            return true;
        }
    }

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static int[] minOperations(String boxes) {
        char[] ch = boxes.toCharArray();
        int[] answer = new int[ch.length];
        int i = 0, j = 0;
        for (; i < ch.length && j < ch.length; i++, j++) {
            answer[i] = Math.abs(ch[i] - ch[j]);
        }
        return answer;
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int w = obstacleGrid.length;
        int h = obstacleGrid[0].length;
        //if obstacle at first cell.
        if (obstacleGrid[0][0] == 0 || obstacleGrid[w - 1][h - 1] == 1)
            return 0;
        obstacleGrid[0][0] = 1;
        for (int i = 1; i < h; i++) {
            if (obstacleGrid[0][i] == 1)
                obstacleGrid[0][i] = 0; //Replace 1 to 0 else take previous cell value.
            else
                obstacleGrid[0][i] = obstacleGrid[0][i - 1];
        }
        for (int i = 1; i < w; i++) {
            if (obstacleGrid[i][0] == 1)
                obstacleGrid[i][0] = 0;
            else
                obstacleGrid[i][0] = obstacleGrid[i - 1][0];
        }

        int count = 0;
        for (int row = 0; row < w; row++) {
            for (int col = 0; col < h; col++) {
                if (obstacleGrid[row][col] == 1) {
                    obstacleGrid[row][col] = 0;
                    continue;
                }
                //Every time taking previous cell values.
                obstacleGrid[row][col] = obstacleGrid[row - 1][col] + obstacleGrid[row][col - 1];
            }


        }
        return obstacleGrid[h - 1][w - 1];

    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];

    }

    public static void isPrimeByShiftOprter() {
        int n = 14;
        int r = (n >> 1) << 1;
        if (r == n)
            System.out.println("Even");
        else
            System.out.println("ODD");
        System.out.println(r);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        List<Integer> list = new ArrayList<>();
        while (cur != null || st.isEmpty() == false) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;

    }

    public static int jump(int[] nums) {
        int r = 0;
        int c = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            r = Math.max(r, nums[i] + i);
            int crnt = 0;
            if (crnt == i) {
                c++;
                crnt = r;
            }
        }

        return c;

    }

    public static boolean canJump(int[] nums) {
        int len = nums.length;
        int r = 0;

        for (int i = 0; i <= r; i++) {
            r = Math.max(r, i + nums[i]);
            if (r >= len - 1)
                return true;
        }
        return false;

    }

    public static int myAtoi(String s) {
        int pr = 0;
        s = s.trim();
        int len = s.length();
        int res = 0, start = 0;
        boolean ispostiv = true;
        if (s.startsWith("-")) {
            ispostiv = false;
            start = 1;
        } else if (s.startsWith("+")) {
            start = 1;
        }
        for (int i = start; i < len; i++) {
            int diff = s.charAt(i) - '0';
            if (diff > 0 && diff < 10) {
                if ((Integer.MAX_VALUE - diff) / 10 < res) {
                    if (ispostiv)
                        return Integer.MAX_VALUE;
                    return Integer.MIN_VALUE;
                }
                res = res * 10 + diff;
            } else {
                break;
            }

        }

        if (ispostiv) return res;
        return (-1) * res;
    }

    public static String mergeAlternately(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        StringBuilder merge = new StringBuilder();

        int i = 0, j = 0;
        for (; i < l1 && j < l2; ++i, ++j) {
            merge.append(word1.charAt(i));
            merge.append(word2.charAt(j));

        }
        if (i < l1)
            merge.append(word1.substring(i));
        if (j < l2)
            merge.append(word2.substring(j));
        return merge.toString();
    }

    public static int uniqueMorseRepresentations(String[] words) {
        StringBuilder translation = new StringBuilder();
        Set<String> mesg = new HashSet<>();
        String[] morseCode = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....",
                "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
                "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
                "-.--", "--.."};
        Character[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                'u', 'v', 'w', 'x', 'y', 'z'};
        HashMap<Character, String> translator = new HashMap<>();
        for (int i = 0; i < alphabet.length; i++) {
            translator.put(alphabet[i], morseCode[i]);
        }
        for (String word : words) {
            for (Object letter : word.toCharArray()) {
                translation.append(translator.get(letter));
            }
            mesg.add(translation.toString());
            translation.setLength(0);
        }
        return mesg.size();

    }

    public static int minDeletionSize(String[] strs) {
        int delete = 0;
        int strin_len = strs[0].length();

        for (int i = 0; i < strin_len; i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                if (strs[j].charAt(i) > strs[j + 1].charAt(i)) {
                    delete++;
                    break;
                }

            }

        }

        return delete;
    }

    public static int minOperations(int[] nums) {
        int len = nums.length;
        if (len == 0 || len == 1)
            return 0;
        int count = 0;
        int should = nums[0] + 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < should) {
                count += should - nums[i];
                should += 1;
            } else
                should = nums[i] + 1;
        }
        return count;

    }

    public static int countGoodRectangles(int[][] rectangles) {
        int maxLength = 0;
        int count = 0;
        for (int i = 0; i < rectangles.length; i++) {
            int l = Math.min(rectangles[i][0], rectangles[i][1]);
            if (l > maxLength) {
                maxLength = l;
                count = 1;
            } else if (l == maxLength)
                count++;
        }
        return count;
    }
}
