package GFGSelfPaced;

import java.util.*;
import java.util.Arrays;

import static GFGSelfPaced.Strings.isPalindrome;

class Activity {

    int start;
    int finish;

    Activity(int s, int f) {
        start = s;
        finish = f;
    }

    static int maxActivity(Activity[] arr) {
        Arrays.sort(arr, new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                return o1.finish - o2.finish;
            }
        });
        int res = 1;
        int prev = 0;
        for (int curr = 1; curr < arr.length; curr++) {
            if (arr[curr].start >= arr[prev].finish) {

                res++;
                prev = curr;
            }
        }
        return res;

    }
    /*
    public static void main(String[] args) {
        Activity[] activity = {
                new Activity(12, 25),
                new Activity(10, 20),
                new Activity(20, 30)
        };
        int r = Activity.maxActivity(activity);
        System.out.println(r);
    }
     */
}

class CityPairs {
    int north, south;

    CityPairs(int north, int south) {
        this.north = north;
        this.south = south;
    }
}

/*
   Dynamic Programming is paradigm or a way to tackle down a problems that have
   multiple solns with DP we can get efficient solns in much efficient manner
   Strategy behind DP Recursion -> Memoization -> Dynamic Programming.
   Recursion means Top to Down
   Memoization/Tabulation means Bottom to Up
 */
public class DP {
    static int mod = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

    }
    private static int LIS4(int[] arr,int n){
        int[] next = new int[n+1],curr = new  int[n+1];

        for(int ind=n-1;ind>=0;ind--){
            for(int prev_ind=ind-1;prev_ind>=-1;prev_ind--){
                int len = next[prev_ind+1];//Not Take

                //Checking the previous element in the array
                if (prev_ind == -1 || arr[ind] > arr[prev_ind])
                    len = Math.max(len, 1 + next[ind]+1);//Take
                curr[prev_ind + 1] = len;
            }
            curr = next;
        }
        return next[-1+1];

    }
    private static int LIS3(int[] arr,int n){
        int[][] dp = new int[n+1][n+1];

        for(int ind=n-1;ind>=0;ind--){
            for(int prev_ind=ind-1;prev_ind>=-1;prev_ind--){
                int len = dp[ind + 1][prev_ind+1];//Not Take

                //Checking the previous element in the array
                if (prev_ind == -1 || arr[ind] > arr[prev_ind])
                    len = Math.max(len, 1 + dp[ind + 1][ind]+1);//Take
                dp[ind][prev_ind + 1] = len;
            }
        }
        return dp[0][-1+1];

    }
    private static int LIS2(int ind, int prev_ind, int[] arr, int n, int[][] dp) {
        /*
        So inorder to store -1,we have to perform cordinate change in the array.
        that's why dp[ind][prev+1]
         */
        if (ind == n) return 0;
        if (dp[ind][prev_ind + 1] != -1) return dp[ind][prev_ind + 1];

        int len = LIS2(ind + 1, prev_ind, arr, n, dp);//Not Take

        //Checking the previous element in the array
        if (prev_ind == -1 || arr[ind] > arr[prev_ind])
            len = Math.max(len, 1 + LIS2(ind + 1, ind, arr, n, dp));//Take

        return dp[ind][prev_ind + 1] = len;
    }

    private static int LIS(int ind, int prev, int[] arr, int n) {
        if (ind == n) return 0;

        int len = LIS(ind + 1, prev, arr, n);//Not Take
        if (prev == -1 || arr[ind] > arr[prev])
            len = Math.max(len, 1 + LIS(ind + 1, ind, arr, n));//Take
        return len;
    }

    private static int BuyAndSellStockCoolDown4(int[] val, int n) {
        int[][] dp = new int[n + 2][2];
        int[] front1 = new int[2], front2 = new int[2], cur = new int[2];
        for (int ind = n - 1; ind >= 0; ind--) {

            //   Buying Stocks (-val)
            cur[1] = Math.max(-val[ind] + front1[0],//Take
                    front1[1]);//Not Take
            // Selling Stocks
            cur[0] = Math.max(val[ind] + front2[1],//Sell
                    front1[0]);//Not Sell
            front2 = front1;
            front1 = cur;
        }
        return cur[1];
    }

    private static int BuyAndSellStockCoolDown3(int[] val, int n) {
        /*
        You are given an array prices where prices[i] is the price of a given stock
        on the ith day.
        After you sell your stock, you cannot buy stock on the next day
        (i.e., cooldown one day).
        Note: You may not engage in multiple transactions simultaneously
        (i.e., you must sell the stock before you buy again).
         */
        int[][] dp = new int[n + 2][2];
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    //   Buying Stocks (-val)
                    dp[ind][buy] = Math.max(-val[ind] + dp[ind + 1][0],//Take
                            0 + dp[ind + 1][1]);//Not Take
                    // Selling Stocks
                } else {
                    dp[ind][buy] = Math.max(val[ind] + dp[ind + 2][1],//Sell
                            dp[ind + 1][0]);//Not Sell
                }
            }
        }
        return dp[0][1];

    }

    private static int BuyAndSellStockCoolDown2(int ind, int buy, int[] val, int n, int[][] dp) {
        /*
        You are given an array prices where prices[i] is the price of a given stock
        on the ith day.
        After you sell your stock, you cannot buy stock on the next day
        (i.e., cooldown one day).
        Note: You may not engage in multiple transactions simultaneously
        (i.e., you must sell the stock before you buy again).
         */
        if (ind >= n) return 0;
        if (dp[ind][buy] != -1) return dp[ind][buy];
        int profit = 0;
        if (buy == 1) {
            //   Buying Stocks (-val)
            dp[ind][buy] = Math.max(-val[ind] + BuyAndSellStockCoolDown2(ind + 1, 0, val, n, dp),//Take
                    0 + BuyAndSellStockCoolDown2(ind + 1, 1, val, n, dp));//Not Take
            // Selling Stocks
        } else {
            dp[ind][buy] = Math.max(val[ind] + BuyAndSellStockCoolDown2(ind + 2, 1, val, n, dp),//Sell
                    BuyAndSellStockCoolDown2(ind + 1, 0, val, n, dp));//Not Sell
        }
        return dp[ind][buy];

    }

    private static long BuyAndSellStockCoolDown(int ind, int buy, long[] val, int n) {
        /*
        You are given an array prices where prices[i] is the price of a given stock
        on the ith day.
        After you sell your stock, you cannot buy stock on the next day
        (i.e., cooldown one day).
        Note: You may not engage in multiple transactions simultaneously
        (i.e., you must sell the stock before you buy again).
         */
        if (ind == n) return 0;
        long profit = 0;
        if (buy == 1) {
            //   Buying Stocks (-val)
            profit = Math.max(-val[ind] + BuyAndSellStock2(ind + 1, 0, val, n),//Take
                    0 + BuyAndSellStock2(ind + 1, 1, val, n));//Not Take
            // Selling Stocks
        } else {
            profit = Math.max(val[ind] + BuyAndSellStock2(ind + 2, 1, val, n),//Sell
                    BuyAndSellStock2(ind + 1, 0, val, n));//Not Sell
        }
        return profit;

    }

    private static int BuyAndSellStock6UptoK4(int[] val, int n) {
        /*
        Space optimized
        PS: If cap==0,ind and buy can be anything
        If  ind==n,ind and cap can be anything
        */

        int[][] after = new int[2][3];
        int[][] cur = new int[2][3];


        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    if (buy == 1) {
                        //   Buying Stocks (-val)
                        cur[buy][cap] = Math.max(-val[ind] + after[0][cap],//Buy
                                0 + after[1][cap]);//Not Buy
                        // Selling Stocks
                    } else {
                        cur[buy][cap] = Math.max(val[ind] + after[1][cap - 1],//Sell
                                after[0][cap]);//Not Sell
                    }
                }
            }
            after = cur;
        }
        return after[1][2];
    }

    private static int BuyAndSellStock6UptoK3(int[] val, int n) {
        /*
        PS: If cap==0,ind and buy can be anything
        If  ind==n,ind and cap can be anything
         */
        int[][][] dp = new int[n + 1][2][3];

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    if (buy == 1) {
                        //   Buying Stocks (-val)
                        dp[ind][buy][cap] = Math.max(-val[ind] + dp[ind + 1][0][cap],//Buy
                                0 + dp[ind + 1][1][cap]);//Not Buy
                        // Selling Stocks
                    } else {
                        dp[ind][buy][cap] = Math.max(val[ind] + dp[ind + 1][1][cap - 1],//Sell
                                dp[ind + 1][0][cap]);//Not Sell
                    }
                }
            }
        }
        return dp[0][1][2];
    }

    private static int BuyAndSellStock6UptoK2(int ind, int buy, int[] val, int n, int cap,
                                              int[][][] dp) {
        if (cap == 0 || ind == n) return 0;
        if (dp[ind][buy][cap] != -1) return dp[ind][buy][cap];

        if (buy == 1) {
            //   Buying Stocks (-val)
            dp[ind][buy][cap] = Math.max(-val[ind] + BuyAndSellStock6UptoK2(ind + 1, 0, val, n, cap, dp),//Buy
                    BuyAndSellStock6UptoK2(ind + 1, 1, val, n, cap, dp));//Not Buy
            // Selling Stocks
        } else {
            dp[ind][buy][cap] = Math.max(val[ind] + BuyAndSellStock6UptoK2(ind + 1, 1, val, n, cap - 1, dp),//Sell
                    BuyAndSellStock6UptoK2(ind + 1, 0, val, n, cap, dp));//Not Sell
        }
        return dp[ind][buy][cap];
    }

    private static long BuyAndSellStock6UptoK(int ind, int buy, long[] val, int n, int cap) {
        if (cap == 0 || ind == n) return 0;

        long profit = 0;
        if (buy == 1) {
            //   Buying Stocks (-val)
            profit = Math.max(-val[ind] + BuyAndSellStock6UptoK(ind + 1, 0, val, n, cap),//Buy
                    0 + BuyAndSellStock6UptoK(ind + 1, 1, val, n, cap));//Not Buy
            // Selling Stocks
        } else {
            profit = Math.max(val[ind] + BuyAndSellStock6UptoK(ind + 1, 1, val, n, cap - 1),//Sell
                    BuyAndSellStock6UptoK(ind + 1, 0, val, n, cap));//Not Sell
        }
        return profit;

    }

    private static long BuyAndSellStock5(long[] val, int n) {
        //long[][] dp = new long[n+1][2];
        long[] ahed = new long[2], cur = new long[2];
        ahed[0] = 0;

        long profit = 0;
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    //Buying Stocks
                    profit = Math.max(-val[ind] + ahed[0], ahed[1]);
                } else {
                    //Selling Stocks
                    profit = Math.max(val[ind] + ahed[1], ahed[0]);
                }
                cur[buy] = profit;
            }
            ahed = cur;
        }
        return ahed[1];
    }

    private static long BuyAndSellStock4(long[] val, int n) {
        long[][] dp = new long[n + 1][2];
        dp[n][0] = dp[n][1] = 0;
        long profit = 0;
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    //Buying Stocks
                    profit = Math.max(-val[ind] + dp[ind + 1][0], dp[ind + 1][1]);
                } else {
                    //Selling Stocks
                    profit = Math.max(val[ind] + dp[ind + 1][1], dp[ind + 1][0]);
                }
                dp[ind][buy] = profit;
            }
        }
        return dp[0][1];
    }

    private static long BuyAndSellStock3(int ind, int buy, long[] val, int n, long[][] dp) {
        if (ind == n) return 0;
        long profit = 0;
        if (dp[ind][buy] != -1) return dp[ind][buy];
        if (buy == 1) {
            //Buying Stocks
            profit = Math.max(-val[ind] + BuyAndSellStock3(ind + 1, 0, val, n, dp),//Buy
                    BuyAndSellStock3(ind + 1, 1, val, n, dp));//Not Buy
        } else {
            //Selling Stocks
            profit = Math.max(val[ind] + BuyAndSellStock3(ind + 1, 1, val, n, dp),//Sell
                    BuyAndSellStock3(ind + 1, 0, val, n, dp));//Not Sell
        }
        return dp[ind][buy] = profit;
    }

    private static long BuyAndSellStock2(int ind, int buy, long[] val, int n) {
        if (ind == n) return 0;
        long profit = 0;
        if (buy == 1) {
            //   Buying Stocks (-val)
            profit = Math.max(-val[ind] + BuyAndSellStock2(ind + 1, 0, val, n),//Take
                    0 + BuyAndSellStock2(ind + 1, 1, val, n));//Not Take
            // Selling Stocks
        } else {
            profit = Math.max(val[ind] + BuyAndSellStock2(ind + 1, 1, val, n),//Sell
                    BuyAndSellStock2(ind + 1, 0, val, n));//Not Sell
        }
        return profit;

    }

    private static int BuyAndSellStock(ArrayList<Integer> prices) {
        // Write your code here.
        int mini = prices.get(0);
        int profit = 0;
        int n = prices.size();
        for (int i = 1; i < n; i++) {
            int cost = prices.get(i) - mini;
            profit = Math.max(profit, cost);
            mini = Math.min(mini, prices.get(i));
        }
        return profit;
    }

    private int LCSDistinict4(String s, String t) {
        /*
        Space optimized
        TC -> O(NxM)
        SC -> O(M)

         */
        int n = s.length();
        int m = t.length();

        int[] cur = new int[m + 1], prev = new int[m + 1];
        cur[0] = prev[0] = 0;


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    cur[j] = prev[j - 1] + prev[j];
                else
                    cur[j] = prev[j];
            }
            prev = cur;
        }
        return prev[m];
    }

    private int LCSDistinict3(String s, String t) {
        /*
        TC -> O(NxM)
        SC -> O(NxM)
         */

        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = 1;
        // for(int j=1;j<=m;j++)dp[0][j]=0;//by default initialize zero


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][m];
    }

    private int LCSDistinict2(int i, int j, String s, String t, int[][] dp) {
        /*
        TC -> O(MxN)
        SC -> O(NxM)+O(N+M)
        In the main method or wherever from you calling this method.
         int[][] dp = new int[i][j];
         for(int[] row : dp){
             Arrays.fill(row,-1);
         }
         */
        if (j < 0) return 1;
        if (i < 0) return 0;
        if (s.charAt(i) == t.charAt(j)) {
            return LCSDistinict2(i - 1, j - 1, s, t, dp) + LCSDistinict2(i - 1, j, s, t, dp);
        }
        return dp[i][j] = LCSDistinict2(i - 1, j, s, t, dp);
    }

    private int LCSDistinict(int i, int j, String s, String t) {
        /*
        A string's subsequence is a new string formed from the original string
        by deleting some (can be none) of the characters without disturbing
        the remaining characters' relative positions.
        (i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).
        Input: s = "rabbbit", t = "rabbit"
        Output: 3
        Explanation:
        As shown below, there are 3 ways you can generate "rabbit" from S.
        rabbbit
        rabbbit
        rabbbit
        TC -> O(expo)
        SC -> O(n+m)+ ASS
         */
        if (j < 0) return 1;
        if (i < 0) return 0;
        if (s.charAt(i-1) == t.charAt(j-1)) {
            return LCSDistinict(i - 1, j - 1, s, t) + LCSDistinict(i - 1, j, s, t);
        }
        return LCSDistinict(i - 1, j, s, t);
    }

    private String LCSshortestCommonSupersequence(String s, String t) {
        /*
    Input: str1 = "abac", str2 = "cab"
    Output: "cabac"
    Explanation:
    str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
    str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
    The answer provided is the shortest such string that satisfies these properties.
         */
        int n = s.length(), m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        StringBuilder ans = new StringBuilder();
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (s.charAt(i - 1) == t.charAt(j - 1)) {
                ans.append(s.charAt(i - 1));  // Same row and Col
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                ans.append(s.charAt(i - 1));   // previous row
                i--;
            } else {
                ans.append(t.charAt(j - 1));
                j--;
            }
        }

        while (i > 0) {
            ans.append(s.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            ans.append(t.charAt(j - 1));
            j--;
        }
        ans.reverse();
        return ans.toString();
    }

    private static int LCSConvertAtoB(String s, String ptr) {
        /*
        Problem: Minimum number of insertion and deletion required to make string same.
        Logic: Length of string s + Length of ptr - 2 * LCS3(String s,String ptr)
        */
        return s.length() + ptr.length() - 2 * LCS3(s, ptr);
    }

    private static int LCSInsertion(String s) {
        /*
        Problem: Minimum number of insertion required to make string palindrome.
        Logic: Length of string - LCPalindromicSubstring(String s)
        */
        return s.length() - LCPalindromicSubstring(s);
    }

    private static int LCPalindromicSubstring(String s) {
        /*
        Hint: res = LCS(String s,reverse(String t));
         */
        StringBuilder t = new StringBuilder(s);
        t.reverse();

        return LCS3(s, t.toString());
    }

    private static int LCSubstring(String s, String t) {
        /*
        Ex:- s = "abcd", t = "abed"
        ans = "ab"

        Tabulation
        TC -> O(n * m)
        SC -> O(M*N)
         */
        int n = s.length(), m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = Math.max(ans, dp[i][j]);
                } else
                    dp[i][j] = 0;
            }
        }

        return ans;
    }

    private static int LCS5(String s, String t) {
        /*
        Printing LCS
        Tabulation
        TC -> O(n * m)
        SC -> O(M*N)
         */
        int n = s.length(), m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        int len = dp[n][m];
        int i = n;
        int j = m;

        int index = len - 1;
        String str = "";
        for (int k = 1; k <= len; k++) {
            str += "$"; // dummy string
        }
        StringBuilder ss = new StringBuilder(s);
        StringBuilder str2 = new StringBuilder(str);
        while (i > 0 && j > 0) {
            if (ss.charAt(i - 1) == t.charAt(j - 1)) {
                str2.setCharAt(index, ss.charAt(i - 1));
                index--;
                i--;
                j--;
            } else if (s.charAt(i - 1) > t.charAt(j - 1)) {
                i--;
            } else j--;
        }
        System.out.println(str2);

        return dp[n][m];
    }

    private static int LCS4(String s, String t) {
        /*
        Tabulation + Space Optimzed
        TC -> O(n * m)
        SC -> O(M+N)
         */
        int n = s.length(), m = t.length();
        int[] prev = new int[m + 1], cur = new int[m + 1];

        // we need only just previous row in order to compute next row or res.
        for (int i = 0; i <= m; i++) {
            prev[i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    cur[j] = 1 + prev[j - 1];
                else
                    cur[j] = Math.max(prev[j], cur[j - 1]);
            }
            prev = cur;
        }
        return prev[m];
    }

    private static int LCS3(String s, String t) {
        /*
        Tabulation
        TC -> O(n * m)
        SC -> O(M*N)
         */
        int n = s.length(), m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }

    private static int LCS2(int i, int j, String s, String t, int[][] dp) {
        /*
        Memoized
        TC -> O(2^n * 2^m)
        SC -> O(M*N)+O(N+M)
         */
        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        if (s.charAt(i - 1) == t.charAt(j - 1))
            return 1 + LCS2(i - 1, j - 1, s, t, dp);
        return dp[i][j] = Math.max(LCS2(i - 1, j, s, t, dp), LCS2(i, j - 1, s, t, dp));
    }

    private static int LCS(int i, int j, String s, String t) {
        if (i < 0 || j < 0) return 0;
        if (s.charAt(i - 1) == t.charAt(j - 1))
            return 1 + LCS(i - 1, j - 1, s, t);
        return Math.max(LCS(i - 1, j, s, t), LCS(i, j - 1, s, t));
    }

    private static int minCuts4(int n, int N, int[] price) {
        /*
        Tabulation + Space optimized
        TC -> O(N*ind)
        SC -> O(N)
         */
        int[] prev = new int[N + 1], cur = new int[N + 1];
        // Base case
        for (int ind = 0; ind <= N; ind++) {
            prev[ind] = ind * price[0];
        }
        for (int ind = 1; ind < n; ind++) {
            for (int cut = 0; cut <= N; cut++) {
                int notTake = prev[cut];
                int take = Integer.MIN_VALUE;
                int rod = ind + 1;
                if (rod <= cut) {
                    take = price[ind] + cur[cut - rod];
                }
                cur[cut] = Math.max(take, notTake);
            }
            prev = cur;
        }
        return prev[N];
    }

    private static int minCuts3(int n, int N, int[] price) {
        /*
        Tabulation
        TC -> O(N*ind)
        SC -> O(N*ind)
         */
        int[][] dp = new int[n][N + 1];

        // Base case
        for (int ind = 0; ind <= N; ind++) {
            dp[0][ind] = ind * price[0];
        }
        for (int ind = 1; ind < n; ind++) {
            for (int cut = 0; cut <= N; cut++) {
                int notTake = dp[ind - 1][cut];
                int take = Integer.MIN_VALUE;
                int rod = ind + 1;
                if (rod <= cut) {
                    take = price[ind] + dp[ind][cut - rod];
                }
                dp[ind][cut] = Math.max(take, notTake);
            }
        }
        return dp[n - 1][N];
    }

    private static int minCuts1(int ind, int N, int[] price, int[][] dp) {
        /*
        Memoization
        TC -> O(N*ind)
        SC -> O(N*ind)+stack
        */
        if (ind == 0) {
            return N * price[0];
        }
        if (dp[ind][N] != -1) return dp[ind][N];
        int notTake = minCuts1(ind - 1, N, price, dp);
        int take = Integer.MIN_VALUE;
        int rod = ind + 1;
        if (rod <= N) {
            take = price[ind] + minCuts1(ind, N - rod, price, dp);
        }
        return dp[ind][N] = Math.max(take, notTake);
    }

    private static int minCuts(int ind, int N, int[] price) {
        /*
        N = need to perform cuts on rod
        TC -> O(~2^N)
        SC -> O(N*ind)+O(W) Stack space
         */
        if (ind == 0) {
            return N * price[0];
        }
        int notTake = minCuts(ind - 1, N, price);
        int take = Integer.MIN_VALUE;
        int rod = ind + 1;
        if (rod <= N) {
            take = price[ind] + minCuts(ind, N - rod, price);
        }
        return Math.max(take, notTake);
    }

    private int coinChange7(int n, int T, int[] arr) {
        /*
        Coin change for infinite coin supply
        */
        int[] prev = new int[T + 1], curr = new int[T + 1];
        //Initializing base condition
        for (int i = 0; i <= T; i++) {
            if (i % arr[0] == 0) prev[i] = 1;
            // Else condition is automatically fulfilled,
            // as dp array is initialized to zero
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= T; target++) {
                int notTake = prev[target];
                int take = 0;
                if (arr[ind] <= target) {
                    take = curr[target - arr[ind]];
                }
                curr[target] = take + notTake;
            }
            prev = curr;
        }
        return prev[T];
    }

    private int coinChange6(int n, int T, int[] arr) {
        /*
        Coin(T) change for infinite coin supply
         */
        int[][] dp = new int[n][T + 1];

        //Initializing base condition
        for (int i = 0; i <= T; i++) {
            if (i % arr[0] == 0)
                dp[0][i] = 1;
            // Else condition is automatically fulfilled,
            // as dp array is initialized to zero
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= T; target++) {
                int notTake = dp[ind - 1][target];
                int take = 0;
                if (arr[ind] <= target) {
                    take = dp[ind][target - arr[ind]];
                }
                dp[ind][target] = take + notTake;
            }
        }
        return dp[n - 1][T];
    }

    private int coinChange5(int ind, int T, int[] arr, int[][] dp) {
        /*
        Coin change for infinite coin supply
        to make it finite just use add 1 to take.
        take = 1 + coinChange5(ind, T - arr[ind], arr, dp);
        */
        if (ind == 0) {
            if (T % arr[0] == 0) return 1;
            else return 0;
        }
        if (dp[ind][T] != -1) return dp[ind][T];

        int notTake = coinChange5(ind - 1, T, arr, dp);
        int take = 0;
        if (T >= arr[ind]) {
            take = coinChange5(ind, T - arr[ind], arr, dp);
        }
        return dp[ind][T] = take + notTake;
    }

    private int coinChange4(int ind, int sum, int[] arr) {
        /*
        Coin change for infinite coin supply
         */
        if (ind == 0) {
            if (sum % arr[0] == 0) return 1;
            else return 0;
        }

        int notTake = coinChange4(ind - 1, sum, arr);
        int take = 0;
        if (sum >= arr[ind]) {
            take = coinChange4(ind, sum - arr[ind], arr);
        }
        return take + notTake;
    }

    private static int coinChange3(int[] arr, int n, int sum) {
        int[][] dp = new int[n][sum + 1];

        //Filling Base case
        for (int ind = 0; ind <= sum; ind++) {
            if (ind % arr[0] == 0) dp[0][ind] = ind / arr[0];
            else dp[0][ind] = (int) Math.pow(10, 9);
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= sum; target++) {
                int notTaken = dp[ind - 1][target];

                int taken = (int) Math.pow(10, 9);
                if (arr[ind] <= target)
                    taken = 1 + dp[ind][target - arr[ind]];

                dp[ind][target] = Math.min(notTaken, taken);
            }
        }
        int ans = dp[n - 1][sum];
        // if (ans >= (int) Math.pow(10, 9)) return -1;
        return ans >= (int) Math.pow(10, 9) ? -1 : ans;
    }

    private static int coinChange2(int[] arr, int ind, int sum, int[][] dp) {
        if (ind == 0) {
            if (sum % arr[0] == 0) return sum / arr[0];
            else return (int) Math.pow(10, 9);
        }

        if (dp[ind][sum] != -1) return dp[ind][sum];

        int notTaken = coinChange2(arr, ind - 1, sum, dp);

        int taken = (int) Math.pow(10, 9);
        if (arr[ind] <= sum)
            taken = 1 + coinChange2(arr, ind, sum - arr[ind], dp);

        return dp[ind][sum] = Math.min(notTaken, taken);
    }

    private static int coinChange1(int ind, int sum, int[] coins) {

        // base case
        if (ind == 0) {
            if (sum % coins[0] == 0)
                return sum / coins[0];
            else
                return (int) Math.pow(10, 9);

        }
        int notPick = coinChange1(ind - 1, sum, coins);
        int pick = (int) Math.pow(10, 9);
        if (coins[ind] <= sum)
            pick = 1 + coinChange1(ind, sum - coins[ind], coins);
        return Math.min(pick, notPick);
    }

    private int knapSack01_5(int n, int maxw, int[] wt, int[] val) {
        /*
        Tabualtion + Space optimized version,Just single array required
        TC -> O(N * W)
        SC -> O(N)
         */
        int[] prev = new int[maxw + 1];


        // For all wt[0]<=w
        for (int i = wt[0]; i < maxw; i++) {
            prev[i] = val[0];
        }
        for (int ind = 1; ind < n; ind++) {
            for (int W = maxw; W >= 0; W--) { //just moving right to left
                int notTake = prev[W];
                int take = Integer.MIN_VALUE;
                if (wt[ind] <= W) {
                    take = prev[W - wt[ind]];
                }
                prev[W] = Math.max(take, notTake);
            }
        }
        return prev[maxw];
    }

    private int knapSack01_4(int n, int maxw, int[] wt, int[] val) {
        /*
        Tabualtion + Space optimized version
        TC -> O(N * W)
        SC -> O(N * W)
         */
        int[] prev = new int[maxw + 1], cur = new int[maxw + 1];


        // For all wt[0]<=w
        for (int i = wt[0]; i < maxw; i++) {
            prev[i] = val[0];
        }
        for (int ind = 1; ind < n; ind++) {
            for (int W = 0; W <= maxw; W++) {
                int notTake = prev[W];
                int take = Integer.MIN_VALUE;
                if (wt[ind] <= W) {
                    take = prev[W - wt[ind]];
                }
                cur[W] = Math.max(take, notTake);
            }
            prev = cur;
        }
        return prev[maxw];
    }

    private int knapSack01_3(int n, int maxw, int[] wt, int[] val) {
        /*
        Tabualtion
        TC -> O(N * W)
        SC -> O(N * W)
         */
        //Base case
        int[][] dp = new int[n][maxw];
        // For all wt[0]<=w
        for (int i = wt[0]; i < maxw; i++) {
            dp[0][i] = val[0];
        }
        for (int ind = 1; ind < n; ind++) {
            for (int W = 0; W <= maxw; W++) {
                int notTake = dp[ind - 1][W];
                int take = Integer.MIN_VALUE;
                if (wt[ind] <= W) {
                    take = dp[ind - 1][W - wt[ind]];
                }
                dp[ind][W] = Math.max(take, notTake);
            }
        }
        return dp[n - 1][maxw];
    }

    private int knapSack01_2(int ind, int w, int[] wt, int[] val, int[][] dp) {
        /*
        Memoization
        int[][] dp = new int[ind][w+1]
        TC -> O(N * W)
        SC -> O(N * W) + O(N) stack space
         */
        //Base case
        if (ind == 0) {
            if (wt[0] <= w) return val[0];
            else return 0;
        }
        if (dp[ind][w] != -1)
            return dp[ind][w];

        int notTake = knapSack01_2(ind - 1, w, wt, val, dp);
        int take = Integer.MIN_VALUE;
        if (wt[ind] <= w) {
            take = val[ind] + knapSack01_2(ind - 1, w - wt[ind], wt, val, dp);
        }
        return dp[ind][w] = Math.max(take, notTake);
    }

    private int knapSack01(int ind, int w, int[] wt, int[] val) {
        /*
        w - is the capacity of the knapsack/Bag.
        wt - is the weight array of item's weight
        val - is the correspond values of an item
         */

        //Base case
        if (ind == 0) {
            if (wt[0] <= w) return val[0];
            else return 0;
        }

        int notTake = knapSack01(ind - 1, w, wt, val);
        int take = Integer.MIN_VALUE;
        if (wt[ind] <= w) {
            take = val[ind] + knapSack01(ind - 1, w - wt[ind], wt, val);
        }
        return Math.max(take, notTake);
    }

    private static int partitoinUptoDifD(int n, int d, int[] arr) {
        int totSum = 0;
        for (int i : arr) totSum += i;
        if (totSum - d < 0 || (totSum - d) % 2 != 0) return 0;
        return subsetSumEqualToK4(n, (totSum - d) / 2, arr);
    }

    private static int subsetSumEqualToK4(int n, int k, int[] arr) {
        /*
        Tabulation + Space Optimized
        TC -> O(N*K)
        SC -> O(N*K)
         */

        int[] prev = new int[k + 1], curr = new int[k + 1];
        prev[0] = curr[0] = 1;

        //if there is only one value
        if (n == 0) {
            if (arr[n] <= k) prev[arr[0]] = 1;
        }
        for (int ind = 1; ind < n; ind++) {
            for (int s = 0; s <= k; s++) {

                int notTaken = prev[s];
                int taken = 0;
                if (arr[ind] <= s)
                    taken = prev[s - arr[ind]];

                curr[s] = notTaken + taken;
            }
            prev = curr;
        }
        return prev[k];
    }

    private static int subsetSumEqualToK3(int n, int target, int[] arr) {
        /*
        1 <= index <= arr.length
        Tabulation
        TC -> O(N*K)
        SC -> O(N*K)
         */
        int[][] dp = new int[n][target + 1];

        if (arr[0] == 0) dp[0][0] = 2;  // 2 cases -pick and not pick
        else dp[0][0] = 1;  // 1 case - not pick

        if (arr[0] != 0 && arr[0] <= target) dp[0][arr[0]] = 1;  // 1 case -pick


        for (int ind = 1; ind < n; ind++) {
            for (int s = 0; s <= target; s++) {
                int notTaken = dp[ind - 1][s];
                int taken = 0;
                if (arr[ind] <= s)
                    taken = dp[ind - 1][s - arr[ind]];

                dp[ind][s] = notTaken + taken;
            }
        }
        return dp[n - 1][target - 1];
    }

    private static int subsetSumEqualToK2(int ind, int sum, int[] arr) {
        /*
        Memoization
        TC -> O(N*K)
        SC -> O(N*K)+O(N)Stack space
         */
        int[][] dp = new int[ind][sum + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        // If we assuming that indexing 0<=ind<=arr.length;
        if (ind == 0) {
            if (sum == 0 && arr[0] == 0) return 2;
            if (sum == 0 || sum == arr[0]) return 1;
        }
        if (dp[ind][sum] != -1) return dp[ind][sum];
        int notPick = subsetSumEqualToK2(ind - 1, sum, arr);
        int pick = 0;
        if (arr[ind] <= sum) {
            pick = subsetSumEqualToK2(ind - 1, sum - arr[ind], arr);
        }
        return dp[ind][sum] = pick + notPick;
    }

    private static int subsetSumEqualToK(int ind, int k, int[] arr) {

        if (k == 0) return 1;
        if (ind == 0) {
            if (arr[ind] == k) return 1;
            else return 0;
        }
        int notPick = subsetSumEqualToK(ind - 1, k, arr);
        int pick = 0;
        if (arr[ind] <= k) {
            pick = subsetSumEqualToK(ind - 1, k - arr[ind], arr);
        }
        return pick + notPick;
    }

    private static boolean subsetSumToK2(int n, int k, int[] arr) {
        /*
        TC -> O(N*target)
        Sc -> O(target)
         */
        boolean[] prev = new boolean[k + 1], curr = new boolean[k + 1];
        prev[0] = curr[0] = true;
        prev[arr[0]] = true;
        boolean dp[][] = new boolean[n][k + 1];
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {

                boolean notTaken = prev[target];

                boolean taken = false;
                if (arr[ind] <= target)
                    taken = prev[target - arr[ind]];

                curr[target] = notTaken || taken;
            }
            prev = curr;
        }

        return prev[k];
    }

    private static boolean subsetSumToK(int n, int k, int[] arr) {
       /*
       TC -> O(N * target)
       SC -> O(N * target)
        */
        boolean dp[][] = new boolean[n][k + 1];
        // Corner case
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (arr[0] <= k)
            dp[0][arr[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {

                boolean notTaken = dp[ind - 1][target];
                boolean taken = false;
                if (arr[ind] <= target)
                    taken = dp[ind - 1][target - arr[ind]];

                dp[ind][target] = notTaken || taken;
            }
        }

        return dp[n - 1][k];
    }

    private boolean subsetSumEqualToTarget(int ind, int target, int[] arr) {
        /*
        You are given an array/list ‘ARR’ of ‘N’ positive integers and an integer ‘K’.
        Your task is to check if there exists a subset in ‘ARR’ with a sum equal to ‘K’.
        Note: Return true if there exists a subset with sum equal to ‘K’. Otherwise, return false.
        For Example :
        If ‘ARR’ is {1,2,3,4} and ‘K’ = 4, then there exists 2 subsets with sum = 4.
        These are {1,3} and {4}. Hence, return true.
         */

        if (target == 0) return true;
        if (ind == 0) return target == arr[0];

        boolean notTake = subsetSumEqualToTarget(ind - 1, target, arr);
        boolean take = false;
        if (target >= arr[ind])
            take = subsetSumEqualToTarget(ind - 1, target - arr[ind], arr);
        return take | notTake;
    }

    private int minFallingPathSum3(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] dp = new int[n][m];
        for (int j = 0; j < n; j++) {
            dp[0][j] = arr[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int u = arr[i][j] + dp[i - 1][j];
                int ld = arr[i][j];
                if (j - 1 >= 0)
                    ld += dp[i - 1][j - 1];
                else
                    ld += (int) Math.pow(10, 9);

                int rd = arr[i][j];
                if (j + 1 < m)
                    rd += dp[i - 1][j + 1];
                else
                    rd += (int) Math.pow(10, 9);

                dp[i][j] = Math.min(u, Math.min(ld, rd));
            }
        }

        int maxi = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            maxi = Math.min(maxi, dp[n - 1][j]);
        }
        return maxi;
    }

    private int fallingPathSum2(int i, int j, int[][] arr) {
        /*
        Memoization
        TC -> O(3^n) exponential
        SC -> O(N)
         */
        int[][] dp = new int[i + 1][j + 1];
        /* initialize with -1 to dp array*/
        for (int row[] : dp)
            Arrays.fill(row, -1);

        int m = arr[0].length;
        if (j < 0 || j >= m)
            return Integer.MIN_VALUE;
        if (i == 0)
            return arr[0][j];
        if (dp[i][j] != -1)
            return dp[i][j];
        int s = arr[i][j] + fallingPathSum(i - 1, j, arr);
        int d = arr[i][j] + fallingPathSum2(i - 1, j - 1, arr);
        int rd = arr[i][j] + fallingPathSum2(i - 1, j + 1, arr);
        return dp[i][j] = Math.max(s, Math.max(d, rd));


    }

    private int fallingPathSum(int i, int j, int[][] arr) {
        /*
        This method will find out minimum and maximum falling path sum on a grid
        Recursion
        TC -> O(3^n) exponential
        SC -> O(N)
         */
        int m = arr[0].length;
        if (j < 0 || j >= m)  //out side the boundary
            return Integer.MIN_VALUE;
        if (i == 0)           // if its only single value
            return arr[0][j];
        int s = arr[i][j] + fallingPathSum(i - 1, j, arr);
        int d = arr[i][j] + fallingPathSum(i - 1, j - 1, arr);
        int rd = arr[i][j] + fallingPathSum(i - 1, j + 1, arr);
        return Math.max(s, Math.max(d, rd));


    }

    private int trianglePathSum2(int i, int j, int[][] arr) {
        /*
        Memoization
        TC -> O(m*n)
        SC -> O(n)+O(m*n)
         */
        int n = arr.length;
        int m = arr[0].length;
        int[][] dp = new int[n][m];
        //Initializing 2d array with -1.
        for (int[] row : dp)
            Arrays.fill(row, -1);

        if (dp[i][j] != -1)
            return dp[i][j];

        if (i == n - 1)
            return arr[n - 1][j];
        int d = arr[i][j] + trianglePathSum2(i + 1, j, arr);
        int dg = arr[i][j] + trianglePathSum2(i + 1, j + 1, arr);
        return dp[i][j] = Math.min(d, dg);
    }

    private int trianglePathSum(int i, int j, int[][] arr) {
        /*
        Given a triangle array, return the minimum path sum from top to bottom.
        For each step, you may move to an adjacent number of the row below.
        More formally, if you are on index i on the current row, you may move to
        either index i or index i + 1 on the next row.
         */
        int n = arr.length;
        if (i == n - 1)
            return arr[n - 1][j];
        int d = arr[i][j] + trianglePathSum(i + 1, j, arr);
        int dg = arr[i][j] + trianglePathSum(i + 1, j + 1, arr);
        return Math.min(d, dg);
    }

    private int minPathSumInGrid4(int m, int n, int[][] grid) {
        /*
       Space optimized version
       TC -> O(m*n)
       SC -> O(n)
         */
        int[] prev = new int[m];

        for (int i = 0; i < m; i++) {
            int[] curr = new int[m];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    curr[j] = grid[0][0];
                else {
                    int up = grid[i][i];
                    if (i > 0)
                        up += prev[j];
                    else
                        up = Integer.MAX_VALUE;


                    int left = grid[i][j];
                    if (j > 0)
                        left += curr[j - 1];
                    else
                        left = Integer.MAX_VALUE;

                    curr[j] = Math.min(up, left);
                }
            }
            prev = curr;
        }
        return prev[m - 1];
    }

    private int minPathSumInGrid3(int m, int n, int[][] grid) {
        /*
        Tabulation
         */
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = grid[0][0];
                else {
                    int up = grid[i][i];
                    if (i > 0)
                        up += dp[i - 1][j];
                    else
                        up = Integer.MAX_VALUE;


                    int left = grid[i][j];
                    if (j > 0)
                        left += dp[i][j - 1];
                    else
                        left = Integer.MAX_VALUE;

                    dp[i][j] = Math.min(up, left);
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    private int minPathSumInGrid2(int m, int n, int[][] ar) {
        /*
        Memoization
         */
        int[][] dp = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        if (m == 0 && n == 0)
            return ar[0][0];
        if (m < 0 || n < 0)
            return Integer.MAX_VALUE;
        if (dp[m][n] != -1) return dp[m][n];
        int up = ar[m][n] + minPathSumInGrid(m - 1, n, ar);
        int left = ar[m][n] + minPathSumInGrid(m, n - 1, ar);
        return dp[m][n] = Math.min(up, left);
    }

    private int minPathSumInGrid(int m, int n, int[][] ar) {
        if (m == 0 && n == 0)
            return ar[0][0];
        if (m < 0 || n < 0)
            return Integer.MAX_VALUE;
        int up = ar[m][n] + minPathSumInGrid(m - 1, n, ar);
        int left = ar[m][n] + minPathSumInGrid(m, n - 1, ar);
        return Math.min(up, left);
    }

    private static int obstaclesGridPath(int m, int n, int[][] mat) {
    /*
    Tabulation
    TC -> O(m*n)
    SC -> O(m*n)
     */
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == -1) dp[i][j] = 0;
                else if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    int up = 0;
                    int left = 0;
                    if (i > 0) up = dp[i - 1][j];
                    if (j > 0) left = dp[i][j - 1];
                    dp[i][j] = (up + left) % mod;
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    private static int uniqueGridPath3(int m, int n) {
    /*
    Tabulation
    TC -> O(m*n)
    SC -> O(m*n)
     */
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    int up = 0;
                    int left = 0;
                    if (i > 0) up = dp[i - 1][j];
                    if (j > 0) left = dp[i][j - 1];
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    private static int uniqueGridPath2(int row, int col) {
    /*
    Memoization

     */
        int[][] dp = new int[row + 1][col + 1];

        for (int[] row1 : dp) {
            Arrays.fill(row1, -1);
        }
        if (row == 0 && col == 0)
            return 1;
        if (row < 0 || col < 0)
            return 0;
        if (dp[row][col] != -1) return dp[row][col];

        int up = uniqueGridPath2(row - 1, col);
        int left = uniqueGridPath2(row, col - 1);
        return dp[row][col] = up + left;
    }

    private static int uniqueGridPath(int row, int col) {
        if (row == 0 && col == 0)
            return 1;
        if (row < 0 || col < 0)
            return 0;
        int up = uniqueGridPath(row - 1, col);
        int left = uniqueGridPath(row, col - 1);
        return up + left;
    }

    private static int ninjaTraining(int day, int last, int points[][], int[][] dp) {
        /*
        Ninja is planing this ‘N’ days-long training schedule.
        Each day, he can perform any one of these three activities.
        (Running, Fighting Practice or Learning New Moves).
        Each activity has some merit points on each day.
        As Ninja has to improve all his skills, he can’t do the same activity
        in two consecutive days. Can you help Ninja find out
        the maximum merit points Ninja can earn?
        You are given a 2D array of size N*3 ‘POINTS’ with the points corresponding
        to each day and activity. Your task is to calculate the maximum number of
        merit points that Ninja can earn.
         */
        if (day == 0) {
            int maxi = 0;
            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    maxi = Math.max(points[0][task], maxi);
                }
            }
            return maxi;
        }
        int maxi = 0;
        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int point = points[day][task] + ninjaTraining(day - 1, task, points, dp);
                maxi = Math.max(maxi, point);
            }
        }
        return dp[day][last] = maxi;
    }

    private int houseRobber2(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int[] temp1 = new int[n];
        int[] temp2 = new int[n];
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                temp1[i] = nums[i];
            }
            if (i != n - 1) {
                temp2[i] = nums[i];
            }
        }
        return Math.max(maxSumSubsequence4(temp1), maxSumSubsequence4(temp2));
    }

    private static int maxSumSubsequence4(int[] arr) {
    /*
        ** Tabulation **
    Finding max sum in all the subsequences in the array
    Constraints: You cant pick adjacent element i,i+1,i+2....etc
    TC -> O(2^n)
    SC -> O(N)
     */
        int n = arr.length;
        int prev = arr[0], prev2 = 0;
        for (int i = 1; i < n; i++) {
            int take = arr[i];
            if (i > 1) take += prev2;
            int notTake = prev;
            int curri = Math.max(take, notTake);
            prev2 = prev;
            prev = curri;
        }
        return prev;

    }

    private static int maxSumSubsequence3(int ind, int[] arr) {
    /*
                  ** Tabulation **
    Finding max sum in all the subsequences in the array
    Constraints: You can't pick adjacent element i,i+1,i+2....etc
    TC -> O(2^n)
    SC -> O(N)
     */
        int[] dp = new int[ind];
        dp[0] = 0;

        int pick = 0;
        for (int i = 1; i < ind; i++) {
            pick = arr[ind];
            if (i > 1)
                pick += dp[i - 2];
            int notPick = dp[i - 1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[ind - 1];
    }

    private static int maxSumSubsequence2(int ind, int[] arr) {
    /*
    Finding max sum in all the subsequences in the array
    Constraints: You cant pick adjacent element i,i+1,i+2....etc
    TC -> O(2^n)
    SC -> O(N)
     */
        int[] dp = new int[ind + 1];
        Arrays.fill(dp, -1);
        if (ind == 0) return arr[ind];
        if (ind < 0) return 0;
        if (dp[ind] != -1)
            return dp[ind];
        int pick = arr[ind] + maxSumSubsequence2(ind - 2, arr);
        int notPick = maxSumSubsequence2(ind - 1, arr);
        return dp[ind] = Math.max(pick, notPick);
    }

    private static int maxSumSubsequence(int ind, int[] arr) {
    /*
    Finding max sum in all the subsequences in the array
    Constraints: You cannot pick adjacent element i,i+1,i+2....etc
    TC -> O(2^n)
    SC -> O(N)
     */
        //Base cases
        if (ind == 0) return arr[ind];
        if (ind < 0) return 0;

        //Main Code
        int pick = arr[ind] + maxSumSubsequence(ind - 2, arr);
        int notPick = maxSumSubsequence(ind - 1, arr);
        return Math.max(pick, notPick);
    }

    private static int frogJumpUptoK(int n, int[] arr, int k) {
    /*
    Using memoization bottom to up
    TC -> O(N);
    SC -> O(N);
     */
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int minStep = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {    /* if there is no negative index in the array */
                    int jump = dp[i - j] + Math.abs(arr[i] - arr[i - j]);
                    minStep = Math.min(jump, minStep);
                }
            }
            dp[i] = minStep;
        }
        return dp[n - 1];
    }

    private static int frogJump4(int n, int[] arr) {
    /*
    Using memoization bottom to up
    TC -> O(N);
    SC -> O(1);
    */
        int pre1 = 0, pre2 = 0;
        for (int i = 1; i < n; i++) {
            int fs = pre1 + Math.abs(arr[i] - arr[i - 1]);
            int ss = Integer.MAX_VALUE;
            if (i > 1)  /* if there is only one value in the array */
                ss = pre2 + Math.abs(arr[i] - arr[i - 2]);
            int curri = Math.min(fs, ss);
            pre1 = curri;
            pre2 = pre1;
        }
        return pre1;
    }

    private static int frogJump3(int n, int[] arr) {
    /*
    Using memoization bottom to up
    TC -> O(N);
    SC -> O(N);
     */
        int[] dp = new int[n];
        dp[0] = 0;
        int fs = 0, ss = 0;
        for (int i = 1; i < n; i++) {
            fs = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);
            ss = Integer.MAX_VALUE;
            if (i > 1)     /* if there is only one value in the array */
                ss = dp[i - 2] + Math.abs(arr[i] - arr[i - 2]);
            dp[i] = Math.min(fs, ss);
        }
        return dp[n - 1];
    }

    private static int frogJump2(int ind, int[] arr, int[] dp) {
    /*
    Using memoization bottom to up
    TC -> O(N);
    SC -> O(N)+O(N);
     */
        Arrays.fill(dp, -1);
        if (dp[ind] != -1) return dp[ind];
        int right = Integer.MAX_VALUE;
        if (ind == 0)
            return 0;
        int left = frogJump2(ind - 1, arr, dp) + Math.abs(arr[ind] - arr[ind - 1]);
        if (ind > 1)
            right = frogJump2(ind - 2, arr, dp) + Math.abs(arr[ind] - arr[ind - 2]);
        return dp[ind] = Math.min(left, right);

    }

    private static int frogJump(int ind, int[] arr) {
    /*
    Frog Jump using recursion
    Constraints: Frog can jump to only 1 index or 2 index at a time.
    TC -> O(2^n,exponential)
    SC -> O(N)
     */
        int right = Integer.MAX_VALUE;
        if (ind == 0)
            return 0;
        int left = frogJump(ind - 1, arr) + Math.abs(arr[ind] - arr[ind - 1]);
        if (ind > 1)
            right = frogJump(ind - 2, arr) + Math.abs(arr[ind] - arr[ind - 2]);
        return Math.min(left, right);
    }

    private static int climbStairs3(int n) {
    /*
    Using Tabulation method bottom to up
    TC -> O(N)
    SC -> O(1)
    */
        int prev2 = 0, prev = 1;
        for (int i = 2; i <= n; i++) {
            int curroi = prev + prev2;
            prev2 = prev;
            prev = curroi;
        }
        return prev;
    }

    private static int climbStairs2(int n) {
    /*
    Using Tabulation method bottom to up
    TC -> O(N)
    SC -> O(N)
    */
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    private static int climbStairs(int indx) {
        if (indx == 0 || indx == 1)
            return 1;
        int left = climbStairs(indx - 1);    // left recursion
        int right = climbStairs(indx - 2);   // right recursion
        return left + right;
    }

    static int minPagesToRead(int[] arr, int n, int k) {

        if (k == 1)
            return sum(arr, 0, n - 1);
        if (n == 1)
            return arr[0];
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            res = Math.min(res, Math.max(minPagesToRead(arr, i, k - 1),
                    sum(arr, i, n - 1)));
        }
        return res;
    }

    static int sum(int[] arr, int b, int e) {
        int s = 0;
        for (int i = b; i <= e; i++) {
            s += arr[i];
        }
        return s;
    }

    static int palinPartition(String s, int i, int j) {
        if (isPalindrome(s))
            return 0;
        int res = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            res = Math.min(res, 1 + palinPartition(s, i, k) +
                    palinPartition(s, k + 1, j));
        }
        return res;
    }

    static int matrixChainMul(int[] arr, int i, int j) {
        if (i + 1 == j) return 0;
        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            res = Math.min(res, matrixChainMul(arr, i, k) +
                    matrixChainMul(arr, k, j) + arr[i] * arr[j] * arr[k]);
        }
        return res;
    }

    static int countBST(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    static int eggDrop(int e, int f) {
        int[][] dp = new int[e + 1][f + 1];
        for (int i = 1; i <= e; i++) {
            dp[1][i] = 1;
            dp[0][i] = 0;
        }
        for (int i = 1; i <= f; i++) {
            dp[i][1] = i;
        }
        for (int i = 2; i <= f; i++) {
            for (int j = 2; j <= e; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x <= i; x++) {
                    dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[x - 1][j - 1], dp[i - x][j]));
                }
            }
        }
        return dp[f][e];
    }

    static int maxSumSpaceEff(int[] arr) {
        if (arr.length == 1) return arr[0];
        int prev_prev = arr[0];
        int prev = Math.max(arr[0], arr[1]);
        int res = prev;
        for (int i = 3; i <= arr.length; i++) {
            res = Math.max(prev, prev_prev + arr[i - 1]);
            prev_prev = prev;
            prev = res;
        }
        return res;
    }

    static int maxSumDP(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        if (n == 1) return arr[0];
        dp[1] = arr[0];
        dp[2] = Math.max(arr[0], arr[1]);
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i - 1]);
        }
        return dp[n];
    }

    static int maxSum(int[] arr, int n) {
        if (n == 1) return arr[0];
        if (n == 2) return Math.max(arr[0], arr[1]);
        else
            return Math.max(maxSum(arr, n - 1),
                    maxSum(arr, n - 2) + arr[n - 1]);
    }

    static int optimalStratergyGame(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = Math.max(arr[i], arr[i + 1]);
        }
        for (int gap = 3; gap < n; gap = gap + 2) {
            for (int i = 0; i + gap < n; i++) {
                int j = i + gap;
                dp[i][j] = Math.max(arr[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]),
                        arr[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]));
            }
        }
        return dp[0][n - 1];
    }

    static int knapsack01DP(int w, int[] wt, int[] val) {
        int n = wt.length;
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 0; i <= w; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (wt[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                }
            }
        }
        return dp[n][w];
    }

    static int knapsack01(int w, int[] wt, int[] val, int n) {
        if (n == 0 || w == 0)
            return 0;
        if (wt[n - 1] > w)
            return knapsack01(w, wt, val, n - 1);
        else
            return Math.max(knapsack01(w, wt, val, n - 1), val[n - 1] +

                    knapsack01(w - wt[n - 1], wt, val, n - 1));
    }

    static int minJumpToEndEfficient(int[] arr) {
        /*
        Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
        Output: 3 (1-> 3 -> 9 -> 9)
        Explanation: Jump from 1st element
        to 2nd element as there is only 1 step,
        now there are three options 5, 8 or 9.
        If 8 or 9 is chosen then the end node 9
        can be reached. So 3 jumps are made.

         */
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] + j >= i) {
                    dp[j] = 0;             //by me
                    if (dp[j] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        return dp[n - 1];
        /*
        Much efficient ever.
        int r=0;
        int c=0;
        int crnt=0;
        for (int i = 0; i < nums.length-1; i++) {
            r = Math.max(r,nums[i]+i);

            if (crnt == i){
               c++;
               crnt = r;
            }
        }

        return c;
        2. From GFG
         // jumps[n-1] will hold the
        int jumps[] = new int[n];
        // result
        int i, j;

        // if first element is 0,
        if (n == 0 || arr[0] == 0)
            return Integer.MAX_VALUE;
        // end cannot be reached

        jumps[0] = 0;

        // Find the minimum number of jumps to reach arr[i]
        // from arr[0], and assign this value to jumps[i]
        for (i = 1; i < n; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for (j = 0; j < i; j++) {
                if (i <= j + arr[j] && jumps[j]!= Integer.MAX_VALUE) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                    break;
                }
            }
        }
        return jumps[n - 1];
         */
    }

    static int minJumpToReachEnd(int[] arr, int n) {
        if (n == 1)
            return 0;
        int res = Integer.MAX_VALUE; //infinite
        for (int i = 0; i <= n - 2; i++) {
            if (i + arr[i] >= n - 1) {
                int sub_res = minJumpToReachEnd(arr, i + 1);
                if (sub_res != Integer.MAX_VALUE) {
                    res = Math.min(res, sub_res + 1);
                }
            }
        }
        return res;
    }

    static int minCostToMakeValueTabular(int[] coins, int val) {
        int n = coins.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 0; i <= val; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= val; i++) {
            for (int j = 0; j < n; j++) {
                if (coins[j] <= i) {
                    int sub_res = dp[i - dp[j]];
                    if (sub_res != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], sub_res);
                    }
                }
            }
        }
        return dp[val];
    }

    static int minCostToMakeValue(int[] coins, int val) {
        int n = coins.length;
        if (val == 0)
            return 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (coins[i] <= val) {
                int sub_res = minCostToMakeValue(coins, val - coins[i]);
                if (sub_res != Integer.MAX_VALUE) {
                    res = Math.min(res, sub_res + 1);
                }
            }
        }
        return res;
    }

    static int maxCuts(int n, int a, int b, int c) {
        /*
        Given a rod of length n inches and an array of prices that includes prices of
        all pieces of size smaller than n. Determine the maximum value obtainable
        by cutting up the rod and selling the pieces. For example,
        if the length of the rod is 8 and the values of different pieces are given
        as the following, then the maximum obtainable value is 22
        (by cutting in two pieces of lengths 2 and 6).

        length   | 1   2   3   4   5   6   7   8
        --------------------------------------------
        price    | 1   5   8   9  10  17  17  20

        And if the prices are as following, then the maximum obtainable value is 24
        (by cutting in eight pieces of length 1)
         */
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = -1;
            if (i - a >= 0) {
                dp[i] = Math.max(dp[i], dp[i - a]);
            }
            if (i - b >= 0) {
                dp[i] = Math.max(dp[i], dp[i - b]);
            }
            if (i - c >= 0) {
                dp[i] = Math.max(dp[i], dp[i - c]);
            }
            if (dp[i] != -1) {
                dp[i]++;
            }
        }
        return dp[n];
    }

    public static int buildindBridge(CityPairs[] pairs, int n) {
        int[] LIS = new int[n];
        // By default single city has LIS = 1.
        Arrays.fill(LIS, 1);

        // Arrays.sort(pairs, new MyCamp()); // Sorting->
        int[] tail = new int[n];
        tail[0] = pairs[0].north;
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (pairs[i].south > tail[len - 1]) {
                tail[i] = pairs[i].north;
                len++;
            } else {
                int c = ceilIndx(tail, 0, len - 1, pairs[i].north);
                tail[c] = pairs[i].north;
            }
        }
        return len;

    }

    public static int maxSumLIS(int[] arr) {
    /*
     Write a program to find the sum of maximum sum subsequence of the given array
     such that the integers in the subsequence are sorted in increasing order.
     For example, if input is {1, 101, 2, 3, 100, 4, 5},
     then output should be 106 (1 + 2 + 3 + 100),
     if the input array is {3, 4, 5, 10}, then output should be 22 (3 + 4 + 5 + 10)
     and if the input array is {10, 5, 4, 3}, then output should be 10
    */
        int[] msis = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            msis[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    msis[i] = Math.max(msis[i], arr[i] + msis[j]);
                }
            }
        }
        int res = msis[0];
        for (int i = 1; i < arr.length; i++) {
            res = Math.max(res, msis[i]);
        }
        return res;
    }

    public static int LISwithBS(int[] arr) {
        int n = arr.length;
        int[] tail = new int[n];
        tail[0] = arr[0];
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > tail[len - 1]) {
                tail[i] = arr[i];
                len++;
            } else {
                int c = ceilIndx(tail, 0, len - 1, arr[i]);
                tail[c] = arr[i];
            }
        }
        return len;
    }

    public static int ceilIndx(int[] tail, int l, int r, int x) {
    /*
    Finding only above to middle that's why ceil.
     */
        while (l < r) {
            int m = l + (r - l) / 2;
            if (tail[m] >= x) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return r;
    }

    public static int LIS(int[] arr) {
        int n = arr.length;
        int[] lis = new int[n];
        lis[0] = 1;
    /*
    Filling the lis array with count how many greatest element in the array.
    e.g, array = [3,10,2,1,20]
    LIS is lis = [3,10,20] , which is length 3.
     */
        for (int i = 1; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i])
                    lis[i] = Math.max(lis[i], lis[j] + 1);
            }
        }
        int res = lis[0];
        /* In this loop we taking greatest num. */
        for (int i = 0; i < n; i++) {
            res = Math.max(res, lis[i]);
        }
        return res;
    }

    static int editDistance(String s1, String s2) {
    /*
    Given two strings str1 and str2 and below operations that can performed on str1.
    Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
    e.g, str= "abdul", str2= "abdel" o/p=1; (e to u).
    */
        int row = s1.length(), col = s2.length();
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 0; i <= row; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= col; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],
                            Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[row][col];
    }

    static int editDistanceRecursive(String s1, String s2, int m, int n) {
    /*
    Given two strings str1 and str2 and below operations that can performed on str1.
    Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
    e.g, str= "abdul", str2= "abdel" o/p=1; (e to u).
    */

        if (m == 0 || n == 0)
            return 0;
        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return editDistanceRecursive(s1, s2, m - 1, n - 1);
        else
            return 1 + Math.min(editDistanceRecursive(s1, s2, m - 1, n - 1),
                    Math.min(editDistanceRecursive(s1, s2, m - 1, n),
                            editDistanceRecursive(s1, s2, m, n - 1)));

    }

    public static int coinChangeEff(int[] coins, int sum) {
        /*
        Given a value N, if we want to make change for N cents,
        and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
        how many ways can we make the change? The order of coins doesn't matter.
        For example, for sum = 4 and S = {1,2,3},
        there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.
        So output should be 4.
         */
        int n = coins.length;
        int[][] dp = new int[sum + 1][n + 1];
        if (sum == 0)
            return 0;
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i <= sum; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                if (coins[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[sum][n];
    }

    public static int coinChange(int[] S, int m, int n) {
        // table[i] will be storing the number of solutions for
        // value i. We need n+1 rows as the table is constructed
        // in bottom up manner using the base case (n = 0)
        int[] table = new int[n + 1];

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[] values
        // after the index greater than or equal to the value of the
        // picked coin
        for (int i = 0; i < m; i++)
            for (int j = S[i]; j <= n; j++)
                table[j] += table[j - S[i]];

        return table[n];
    }

    public static int coinChange(int[] coins, int sum) {
        int n = coins.length;
        if (sum == 0)
            return 1;
        if (n == 0)
            return 0;
        int res = coinChange(coins, sum);  // StackOverFlow Exception
        if (coins[n - 1] <= sum)
            res = res + coinChange(coins, sum - coins[n - 1]);
        return res;
    }

    public static int lcsTabulation(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    public static int lcsMemoization(String s1, String s2, int m, int n) {
        int[][] memo = new int[m + 1][n + 1];
        Arrays.fill(memo, -1);
        if (memo[m][n] != -1)
            return memo[m][n];
        if (m == 0 || n == 0)
            memo[m][n] = 0;
        else {
            if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
                memo[m][n] = 1 + lcsMemoization(s1, s2, m - 1, n - 1);
            } else {
                memo[m][n] = Math.max(lcsMemoization(s1, s2, m - 1, n),
                        lcsMemoization(s1, s2, m, n - 1));
            }
        }
        return memo[m][n];
    }

    public static int lcsRecursive(String s1, String s2, int m, int n) {
        // int m = s1.length(),n = s2.length();
        /*
        LCS Problem Statement: Given two sequences, find the length of longest
        subsequence present in both of them. A subsequence is a sequence that
        appears in the same relative order, but not necessarily contiguous.
        For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc
        are subsequences of “abcdefg”.
        */
        if (m == 0 || n == 0)
            return 0;
        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return 1 + lcsRecursive(s1, s2, m - 1, n - 1);
        else
            return Math.max(lcsRecursive(s1, s2, m - 1, n),
                    lcsRecursive(s1, s2, m, n - 1));
    }

    public static int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        String s2 = new String(sb);
        return lcsTabulation(s, s2);
    }
}
