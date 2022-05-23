package final450;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import static GFGSelfPaced.Searching.BinarySearch;
import static GFGSelfPaced.Searching.itrativeBinarySearch;
import static GFGSelfPaced.Sorting.countAndMerge;

public class ArraysProb {
    public static void main(String[] args) {
        int[] arr1 = new int[]{10, 3, 5, 6, 2};

        System.out.println(Arrays.toString(productExceptSelf(arr1, arr1.length)));

    }
    public long findMinDiff (ArrayList<Long> a, long n, long m)
    {
        long res = 0;
        res = a.get((int) m-1) - a.get(0);
        for (int i = 1; i+m-1 < n; i++) {
            res = Math.min(res,a.get((int) (i + m - 1)) - a.get(i));
        }
        return res;
    }

    public static long[] productExceptSelf(int nums[], int n) {
        long[] p = new long[n];
        Arrays.fill(p,1);
        long l = nums[0], r = nums[n - 1];
        for (int i = 1; i < n; i++) {
            p[i] *= l;
            l *= nums[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            p[i] *= r;
            r *= nums[i];
        }
        return p;
    }

    static int medianOfArray(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int low = 0, hi = n - 1, mid = (low + hi) / 2;
        return arr[mid];
    }

    static int minSubArraySum(int[] nums, int target) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        prefix[0] = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int result = BinarySearch(prefix, 0, i, sum - target);
            if (result != -1) {
                int size = i - result + 1;
                minLen = Math.min(minLen, size);
            }
            prefix[i + 1] = sum;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    static int trappingRainWater(int[] arr) {
        int n = arr.length;
        int res = 0;
        int[] leftmax = new int[n];
        int[] rightmax = new int[n];
        leftmax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftmax[i] = Math.max(arr[i], leftmax[i - 1]);
        }
        rightmax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightmax[i] = Math.max(arr[i], rightmax[i + 1]);
        }
        for (int i = 1; i < n - 1; i++) {
            res = res + (Math.min(leftmax[i], rightmax[i]) - arr[i]);
        }
        return res;
    }

    static int elementmorethenk(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int[] apprcount = new int[n];
        int count = 1;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                count++;

            } else {
                count = 1;
            }
            apprcount[i] = count;
            //   count = 1;
        }
        System.out.println(Arrays.toString(apprcount));
        int res = 0;
        for (int i = 0; i < apprcount.length; i++) {
            if (apprcount[i] > n / k) {
                res++;
            }
        }
        return res;
    }

    static int longestConsecSubsequence(int[] arr) {
        int n = arr.length, count = 0;
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            set.add(arr[i]);
        }
        for (int i = 0; i < n; ++i) {
            if (!set.contains(arr[i] - 1)) {
                int j = arr[i];
                while (set.contains(j)) {
                    j++;
                }
                if (ans < j - arr[i]) {
                    ans = j - arr[i];
                }
            }
        }
        return ans;
    }

    static int maxSubarrayProduct(int[] arr) {
        int n = arr.length;
        int maxEndig = 1, minEnding = 1, max_so_far = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                maxEndig = maxEndig * arr[i];
                minEnding = Math.min(minEnding * arr[i], 1);
            } else if (arr[i] == 0) {
                maxEndig = 1;
                minEnding = 1;
            } else {
                int temp = maxEndig;
                maxEndig = Math.max(minEnding * arr[i], 1);
                minEnding = temp * arr[i];
            }
            if (max_so_far < maxEndig)
                max_so_far = maxEndig;
        }
        return max_so_far;
    }


    static void threeCommon(int[] a, int[] b, int[] c) {
        int na = a.length, nb = b.length, nc = c.length, i = 0, j = 0, k = 0;
        int[] ar = new int[na];
        while (i < na && j < nb) {
            if (i > 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            }
            if (a[i] > b[j]) {
                j++;
            } else if (a[i] < b[j]) {
                i++;
            } else {
                ar[k] = a[i];
                System.out.println(ar[k]);
                i++;
                j++;
                k++;

            }


        }
    }

    static int pairSum(int[] arr, int k) {
        int n = arr.length;
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] + arr[i - 1] == k) {
                count++;
            }
        }
        return count;
    }

    static int countInversion(int[] arr, int low, int high) {

        int res = 0;
        while (low < high) {
            int m = (low + high) / 2;
            res += countInversion(arr, low, m);
            res += countInversion(arr, m + 1, high);
            res += countAndMerge(arr, low, m, high);
        }
        return res;
    }

    static void nextPermutation(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] > nums[j]) {
                swap(nums[i], nums[j]);
                i++;
            } else {
                i++;
                swap(nums[i], nums[j]);
            }
            System.out.println(Arrays.toString(nums));
        }

    }

    public static void mergeWithoutExSpace(int[] arr1, int[] arr2) {
        int m = arr1.length, n = arr2.length;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (arr1[i] <= arr2[j]) {
                System.out.print(arr1[i] + " ");
                i++;
            } else {
                System.out.print(arr2[j] + " ");
                j++;
            }
        }
        while (i < m) {
            System.out.print(arr1[i] + " ");
            i++;
        }
        while (j < n) {
            System.out.print(arr2[j] + " ");
            j++;
        }
    }

    public static int minHeight(int[] arr, int k) {
        int[] nwarr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                nwarr[i] = arr[i] - k;
            } else {
                nwarr[i] = arr[i] + k;
            }
        }
        System.out.println(Arrays.toString(nwarr));
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nwarr[i];
        }
        Arrays.sort(arr);
        return Math.abs(arr[0] - arr[arr.length - 1]);
    }

    public static int maxSumByKadanes(int[] arr) {
        int res = arr[0];
        int maxEnd = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEnd = Math.max(arr[i], maxEnd + arr[i]);
            res = Math.max(res, maxEnd);
        }
        return res;
    }

    public static void allNegOneSide(int[] arr) {
        int n = arr.length;
        int i = -1, j = n;
        while (true) {
            do {
                i++;
            } while (arr[i] < 0);
            do {
                j--;
            } while (arr[j] >= 0);
            if (i >= j)
                return;
            swap(arr[i], arr[j]);
            System.out.println(Arrays.toString(arr));
        }

    }

    public static void sort012(int[] arr) {
        int i = -1, n = arr.length, j = n - 1;
        while (true) {
            do {
                i++;
            } while (arr[i] < 0);
            do {
                j--;
            } while (arr[j] >= 0);
            if (i >= j)
                return;
            swap(arr[i], arr[j]);

        }


    }

    public static int KthMin(int[] arr, int k) {
        int res = 0, val = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[res]) {
                if (val < arr[i]) {
                    val = arr[i];
                    res = i;
                }
            }
        }
        return val;
    }

    public static int KthMax(int[] arr, int k) {
        int res = 0, val = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[res]) {
                val = arr[i];
                res = i;
            }
        }
        return val;
    }

    static void swap(int i, int j) {
        int t = i;
        i = j;
        j = t;
    }

}
