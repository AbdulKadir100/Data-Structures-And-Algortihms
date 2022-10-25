package GFGSelfPaced;

import java.util.*;

public class Arrayss {
    public static void main(String[] args) {
        int[] speed = new int[]{2,10,3,1,5,8};
        int[] efficiency = new int[]{5,4,3,9,7,2};
        System.out.println(maxPerformance(6,speed,efficiency,2));
    }
    public static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] players = new int[n][2];
        for (int i=0; i<n; i++) {
            players[i][0] = efficiency[i];
            players[i][1] = speed[i];
        }
        // Sort the players based on efficiency in decreasing order, as for each iteration, we'll consider only players with higher efficiency.
        Arrays.sort(players, (p1, p2) -> (p2[0] - p1[0]));
        System.out.println(Arrays.deepToString(players));

        // Priority-Queue to maintain players with highest relative speeds with efficiencies greater than the one under iteration.
        PriorityQueue<Integer> speedQueue = new PriorityQueue<>(k);
        long teamPerformance = 0, teamSpeed = 0;

        for (int i=0; i<n; i++) {
            // This is because a team can have at most `k` players.
            if (speedQueue.size() >= k) {
                teamSpeed -= speedQueue.remove();
            }
            speedQueue.add(players[i][1]);
            teamSpeed += players[i][1];

            teamPerformance = Math.max(teamPerformance, teamSpeed * players[i][0]);
        }
        return (int) (teamPerformance % 1000000007);
    }
    public static boolean isEqualibirium(int[] arr) {
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        int left_sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (left_sum == sum - arr[i])
                return true;
            left_sum += arr[i];
            sum -= arr[i];

        }
        return false;
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prod = new int[n];
        int pre = 1, suf = 1;
        for (int i = 0; i < n; i++) {
            prod[i] = pre;
            pre *= nums[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            prod[i] *= suf;
            suf *= nums[i];
        }
        return prod;
    }

    public static int getPrefixSumArray(int[] arr, int l, int r) {
        int n = arr.length;
        int[] pre_fix = new int[n];
        pre_fix[0] = arr[0];
        for (int i = 1; i < n; i++) {           //Computing All Prefix element sum
            pre_fix[i] = pre_fix[i - 1] + arr[i];
        }
        if (l != 0) {                           //Querying : total Sum - prefix element(r - l)
            return pre_fix[r] - pre_fix[l - 1];
        } else {
            return pre_fix[r];
        }
    }

    public static int windowSlidingTechnique(int[] nums, int k) {
        int arr_sum = 0;
        for (int i = 0; i < k; i++) {
            arr_sum += nums[i];
        }
        int max_sum = arr_sum;
        for (int i = k; i < nums.length; i++) {
            arr_sum += (nums[i] - nums[i - k]);
            max_sum = Math.max(max_sum, arr_sum);
        }
        return max_sum;
    }

    public static int majorityOfElementEfficient(int[] nums) {
        int res = 0, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[res])
                count++;
            else
                count--;
            if (count == 0) {
                res = i;
                count = 1;
            }

        }
        count = 0;
        for (int num : nums) {
            if (nums[res] == num)
                count++;
        }
        if (count <= nums.length / 2)
            return -1;
        return count;

    }

    public static int majorityOfElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    count++;
            }
            if (count > nums.length / 2)
                return nums[i];
        }
        return -1;
    }

    public static int CircularArraySum(int[] nums) {
        int max_Sum = maxSumByKadane(nums);
        if (max_Sum < 0)
            return max_Sum;
        int arr_sum = 0;
        for (int i = 0; i < nums.length; i++) {
            arr_sum += nums[i];
            nums[i] = -nums[i];   // Inverting array.
        }
        int max_circuler = arr_sum + maxSumByKadane(nums);
        return Math.max(max_Sum, max_circuler);
    }

    public static int maxSumByKadane(int[] arr) {
        int res = arr[0], maxEnding = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEnding = Math.max(arr[i], maxEnding + arr[i]);
            res = Math.max(res, maxEnding);
        }
        return res;
    }

    public static int subarraySumleet(int[] nums, int k) {
        int s = 0, arr_sum = nums[0];
        for (int e = 1; e < nums.length; e++) {
            //Clean the previous window
            while (arr_sum > k && s < e - 1) {
                arr_sum -= nums[s];
                s++;
            }
            if (arr_sum == k)
                return arr_sum;
            if (e < nums.length)
                arr_sum += nums[e];
        }
        return arr_sum;
    }

    public static int maxEvenOddEfficient(int[] arr) {
        // Using Kadane's Algorithm
        int res = 1;
        int curr = 1;
        int n = arr.length;
        for (int i = 1; i < n; i++) {

            if ((arr[i] % 2 == 0 && arr[i - 1] % 2 != 0) || (arr[i] % 2 != 0 && arr[i - 1] % 2 == 0)) {
                curr++;
                res = Math.max(curr, res);
            } else {
                curr = 1;
            }
        }
        return res;
    }

    public static int maxEvenOdd(int[] arr) {
        int res = 1;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int curr = 1;
            for (int j = i + 1; j < n; j++) {
                if ((arr[j] % 2 == 0 && arr[j - 1] % 2 != 0) ||
                        (arr[j] % 2 != 0 && arr[j - 1] % 2 == 0)) {
                    curr++;
                } else {
                    break;
                }
            }
            res = Math.max(curr, res);
        }
        return res;
    }

    public static int maxSumSubArraySumEfficient(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        int maxEnding = nums[0];
        for (int i = 1; i < n; i++) {
            maxEnding = Math.max(maxEnding + nums[i], nums[i]);
            res = Math.max(maxEnding, res);
        }
        return res;
    }

    public static int maxSumSubArray(int[] arr) {
        int n = arr.length;
        int res = arr[0];
        for (int i = 0; i < n; i++) {
            int curr = 0;
            for (int j = i; j < n; j++) {
                curr = curr + arr[j];
                res = Math.max(res, curr);
            }
        }
        return res;
    }

    public static int maxConscutiveOneBinaryEfficient(int[] nums) {
        int res = 0, curr = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0)
                curr = 0;
            else {
                curr++;
                res = Math.max(curr, res);
            }

        }
        return res;
    }

    public static int maxConscutiveOneBinary(int[] arr) {
        int res = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int curr = 0;
            for (int j = i; j < n; j++) {
                if (arr[j] == 1)
                    curr++;
                else
                    break;
            }
            res = Math.max(curr, res);
        }
        return res;
    }

    public static int getTrappingRainWaterEfficient(int[] height) {
        // We can't store water at the rightmost and leftmost bar,so we have to start 1 to n-1.
        // Time and Space is : O(n).
        int res = 0;
        int n = height.length;
        int[] lmax = new int[n];
        int[] rmax = new int[n];
        lmax[0] = height[0];
        for (int i = 1; i < n; i++) {     // PreCompute leftmost.
            lmax[i] = Math.max(height[i], lmax[i - 1]);
        }
        rmax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {    //Precompute rightmost.
            rmax[i] = Math.max(height[i], rmax[i + 1]);
        }

        for (int i = 1; i < n - 1; i++) {
            res = res + (Math.min(lmax[i], rmax[i]) - height[i]);
        }
        return res;
    }

    public static int getTrappingRainWater(int[] height) {
        // We can't store water at the rightmost and leftmost bar,so we have to start 1 to n-1.
        // Time : O(n^2)
        int res = 0;
        int n = height.length;
        for (int i = 1; i < n - 1; i++) {
            int lmax = height[i];
            for (int j = 0; j < i; j++) {        // Find left bar
                lmax = Math.max(lmax, height[j]);
            }
            int rmax = height[i];
            for (int j = i + 1; j < n; j++) {      // Find Right bar
                rmax = Math.max(rmax, height[j]);
            }
            res = res + (Math.min(lmax, rmax) - height[i]);
        }
        return res;
    }

    public static int buyAndSellStock3Efficient(int[] arr) {
        int profit = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1])
                profit += (arr[i] - arr[i - 1]);
        }
        return profit;
    }

    public static int buyAndSellStock1(int[] price, int start, int end) {
        /*
        If the array is sorted we will get maximum profit.
        If the Array is descending order we will not get any profit
         */

        if (end <= start)
            return 0;
        int profit = 0;
        for (int i = start; i < end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (price[j] > price[i]) {
                    int curr_profit = price[j] - price[i] + buyAndSellStock1(price, start, i - 1) +
                            buyAndSellStock1(price, j + 1, end);
                    profit = Math.max(profit, curr_profit);
                }
            }
        }
        return profit;

    }

    public static void frequency(int[] arr) {
        int frq = 1, i = 1;
        while (i < arr.length) {
            while (i < arr.length && arr[i] == arr[i - 1]) {
                frq++;
                i++;
            }
            System.out.println(arr[i - 1] + " " + frq);
            i++;
            frq = 1;
        }
        if (arr.length == 1 || arr[i - 1] != arr[i - 2]) {
            System.out.println(arr[i - 1] + " " + 1);
        }
    }

    private static int maximumDiffEfficient(int[] arr) {
        int n = arr.length;
        int res = arr[1] - arr[0], minValue = arr[0];
        for (int i = 1; i < n; i++) {
            res = Math.max(res, arr[i] - minValue);
            minValue = Math.min(minValue, arr[i]);
        }
        return res;
    }

    public static int maximumDiff(int[] arr) {
        int n = arr.length;
        int res = arr[1] - arr[0];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                res = Math.max(res, arr[j] - arr[i]);
            }
        }
        return res;
    }

    public static void leaderProblem2(int[] nums) {
        int n = nums.length;               //    O(n) solution, left tp right approach.
        int curr_led = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            if (curr_led < nums[i]) {
                curr_led = nums[i];
                System.out.print(nums[i] + " ");
            }
        }
    }

    public static void leaderProblem(int[] nums) {
        int n = nums.length;                        //    O(n^2) solution.
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] <= nums[j]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.print(nums[i] + " ");
            }
        }
    }

    public static void leftRotate(int[] nums, int k) {
        //left rotate by k elements.
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = nums[i];
        }
        for (int i = k; i < nums.length; i++) {
            nums[i - k] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            nums[nums.length - k + i] = temp[i];
        }
        System.out.println(java.util.Arrays.toString(nums));
    }

    public static void leftRotateByOne(int[] nums) {
        int t = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }
        nums[nums.length - 1] = t;
        System.out.println(java.util.Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        /*if array already sorted, else we can use bool array marked present element
         -1 and whenever we saw -1 again we can skip that element
         */
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[res - 1] != nums[i]) {
                nums[res] = nums[i];
                res++;
            }
        }
        return res;
    }

    public static boolean checkSortedArray(int[] ar) {
        for (int i = 1; i < ar.length; i++) {
            if (ar[i] < ar[i - 1])
                return false;
        }
        return true;
    }

    public static int findKthLargest(int[] nums, int k) {
        int res = 0, val = 0;
        for (int i = 1; i < nums.length - k; i++) {
            if (nums[i] > nums[res]) {
                val = nums[i];
                res = i;
            }
        }
        return val;
    /*
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (nums[j] > nums[i]) {
                    flag = false;
                    return nums[j];
                }
            }
            if (flag == true) {
                return n;
            }
        }
        return -1;
     */
    }

}
