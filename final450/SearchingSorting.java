package final450;

import java.util.ArrayList;
import java.util.*;

import static GFGSelfPaced.Searching.findRepeat;
import static GFGSelfPaced.Sorting.insertionSort;
import static final450.ArraysProb.*;

public class SearchingSorting {
    public static void main(String[] args) {
        int[] ar = new int[]{11, 13, 15, 17};
        System.out.println(findMin(ar));

    }
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        int[] res = new int[n+m];
        int i=0,j=0,d=0;
        while (i<n && j<m){
            if (arr1[i]<arr2[j]){
                res[d++] = arr1[i++];
            }else {
                res[d++] = arr2[j++];
            }
        }
        while (i<n){
            res[d++] = arr1[i++];
        }

        while (j<m){
            res[d++] = arr2[j++];
        }

        return res[k-1];
//        int left=0,right=o-1;
//        int mid = left+(right-left)/2;
//        if (mid==k-1){
//            return res[mid];
//        }
//        if (mid>k-1){
//            right = mid-1;
//        }else {
//            left = mid+1;
//        }
//      return -1;
    }

    public static int findMin(int[] nums) {
        int low = 0, n = nums.length, high = n - 1;

        //Corner Cases.
        if (n == 1) {
            return nums[0];
        }
        if (nums[high] > nums[0]) {
            return nums[0];
        }
        //Simple Binary Search
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[mid] > nums[0]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return -1;
    }

    public int[] topKFrequent(int[] arr, int k) {
        if (k == arr.length)
            return arr;
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Queue<Integer> heap = new PriorityQueue<>(
                (n1, n2) -> map.get(n1) - map.get(n2));
        // 2. keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for (int n1 : map.keySet()) {
            heap.add(n1);
            if (heap.size() > k) heap.poll();
        }
        // 3. build an output array
        // O(k log k) time
        int[] top = new int[k];
        for (int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }

    static void sortBySetCount(int[] arr) {
        int n = arr.length;
        int[] aux = new int[n];
        for (int i = 0; i < n; i++) {
            aux[i] = countBits(arr[i]);
        }
        sortBySetBitCount(arr, n);
    }

    static void sortBySetBitCount(int[] arr, int n) {
        ArrayList<ArrayList<Integer>> count = new ArrayList<ArrayList<Integer>>();

        // Iterate over all values and
        // insert into multimap
        for (int i = 0; i < n; ++i) {
            count.add(new ArrayList<Integer>(Arrays.asList((-1) * countBits(arr[i]), arr[i])));
        }

        Collections.sort(count, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });

        for (int i = 0; i < count.size(); i++) {
            System.out.print(count.get(i).get(1) + " ");
        }

    }

    static int countBits(int a) {
        int count = 0;
        while (a > 0) {
            if ((a & 1) > 0)
                count += 1;
            a = a >> 1;
        }
        return count;
    }

    static int zeroSumSubarray(long[] arr) {
        int n = arr.length, count = 0;
        HashSet<Integer> h = new HashSet<>();
        int pre_sum = 0;
        for (int i = 0; i < n; i++) {
            pre_sum += arr[i];
            if (h.contains(pre_sum))
                count++;
            if (pre_sum == 0)
                count++;
            h.add(pre_sum);
        }
        return count;
    }

    public static int FindMaxSum(int arr[], int x, int k) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x && arr[mid] - arr[mid - 1] == k && arr[mid] - arr[mid + 1] == k)
                return mid;
            else if (arr[mid] > x) {
                if (arr[mid + 1] == x)
                    return mid + 1;
                high = mid - 1;
            } else if (arr[mid] < x)
                low = mid + 1;
            else
                return high;
        }
        return -1;
    }

    public static int maximumGap(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 0;
        Arrays.sort(nums);
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            int curr = nums[i] - nums[i - 1];
            if (curr > res) {
                res = curr;
            }
        }
        return res;
    }

    static int[] findTwoElement(int arr[], int n) {

        int mis = 0, duplicate = 0;
        for (int i = 0; i < n; i++) {
            int index = Math.abs(arr[i]);
            if (arr[index - 1] > 0)
                arr[index - 1] = -arr[index - 1];
            else
                duplicate = index;
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0)
                mis = i + 1;
        }

        return new int[]{duplicate, mis};
    }

    static int[] find(int arr[], int n, int x) {
        int[] ar = new int[2];
        int l = 0, h = n - 1;
        ar[0] = firstIndex(arr, l, h, x, n);
        ar[1] = lastIndex(arr, l, h, x, n);
        return ar;
    }

    static int firstIndex(int[] arr, int low, int high, int x, int n) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == 0 || arr[mid - 1] < x && arr[mid] == x)
                return mid;
            if (arr[mid] < x)
                return firstIndex(arr, mid + 1, high, x, n);
            else
                return firstIndex(arr, low, mid - 1, x, n);
        }
        return -1;
    }

    static int lastIndex(int[] arr, int low, int high, int x, int n) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == n - 1 || arr[mid + 1] > x && arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                return lastIndex(arr, low, mid - 1, x, n);
            else
                return lastIndex(arr, mid + 1, high, x, n);
        }
        return -1;
    }
}
