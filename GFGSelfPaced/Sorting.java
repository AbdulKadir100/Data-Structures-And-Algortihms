package GFGSelfPaced;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] a = new int[]{7, 3, 2, 4, 9, 12, 56};

        System.out.println(chocoDistribute(a,3));

    }
    static void noOfPossibleTrianlge(int[] arr){
        int n = arr.length;
        if (n==3)
            System.out.println(1);
        int i=0,j=0;
        for (; i < n; i++) {
            for (; j < 3; j++) {
                System.out.print(arr[j]+" ");
            }
            i = j+1;
            System.out.println();
        }
    }
    public static void sortColors(int[] nums) {
 /*
        Using Dutch National Flag Algorithm,Extended version of Hoar's algorithm.
        Only One Traversal need to complete.
        Time O(n),Space constant.
         */
        int n = nums.length;
        int l = 0, h = n - 1, mid = 0;
        while (mid <= h) {
            if (nums[mid] == 0) {
                swap(nums[l], nums[mid]);
                l++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums[mid], nums[h]);
                h--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
    static void countingSorting(int[] arr){
        /*
        This algorithm based on number of occurrence not on comparison based.
        Time O(n),space O(n) algorithm.
         */
        int n = arr.length;
        int k= n;
        int[] count = new int[k];
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }
        for (int i = 1; i < k; i++) {
            count[i] = count[i-1]+count[i];
        }
        int[] output = new int[n];
        for (int i = n-1; i >= 0; i--) {
            output[count[arr[i]]-1] = arr[i];
            count[arr[i]]--;
        }
        for (int i = 0; i < n; i++) {
            arr[i]  = output[i];
        }
        System.out.println(Arrays.toString(arr));
    }
    static void heapSort(int[] arr){
        int n = arr.length;
        buildHeap(arr);
        for (int i = n-1; i >= 1 ; i--) {
            swap(arr[0],arr[i]);
            maxHeapify(arr,i);
        }
    }

    static void buildHeap(int[] arr){
        int n = arr.length;
        for (int i = (n-2)/2; i >= 0; i--) {
            maxHeapify(arr,i);
        }
    }

    static void maxHeapify(int[] arr, int i) {
        int n = arr.length;
        int largest = i, left = 2 * i + 1, right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(arr[largest], arr[i]);
            maxHeapify(arr, largest);
        }
    }

    static int maxGuest(int[] arr, int[] dep) {
        /*
        Assuming length is the same for both the arrays.
         */
        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 1, j = 0, res = 1, curr = 1;
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                curr++;
                i++;
            } else {
                curr--;
                j++;
            }
            res = Math.max(res, curr);
        }
        return res;
    }

    static int getMinDiff(int[] arr) {
        int res = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            res = Math.min(res, arr[i] - arr[i - 1]);
        }
        return res;
    }

    static int[] oneTwoSortDutchFlagAlgorithm(int[] arr) {
        /*
        Using Dutch National Flag Algorithm,Extended version of Hoar's algorithm.
        Just One Traversal need to complete.
        Time O(n),Space constant.
         */
        int n = arr.length;
        int l = 0, h = n - 1, mid = 0;
        while (mid <= h) {
            if (arr[mid] == 0) {
                swap(arr[l], arr[mid]);
                l++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr[mid], arr[h]);
                h--;
            }
        }
        return arr;
    }

    static void allNegOneside(int[] arr) {
        /*
        Using Hoar's Partition.
        It will work for the
        below represented array
        Binary Array
        [0,1,0,1,1,1,0,0,1]
         */
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
        }
    }

    static int chocoDistribute(int[] arr, int m) {
        int n = arr.length;
        if (m > n) return -1;
        Arrays.sort(arr);
        int res = arr[m - 1] - arr[0];
        for (int i = 1; i + m - 1 < n; i++) {
            res = Math.min(res, (arr[i + m - 1] - arr[i]));
        }
        return res;
    }

    static int kthSmallest(int[] arr, int k) {
        //Known As Quick Select Algorithm.

        int n = arr.length, l = 0, r = n - 1;
        while (l <= r) {
            int p = lomutoPartition(arr, l, r);
            if (p == k - 1)
                return arr[p];
            else if (p > k - 1)
                r = p - 1;
            else
                l = p + 1;
        }
        return -1;
    }

    static void quickSort(int[] arr, int l, int h) {
        if (l < h) {
            int pivot = lomutoPartition(arr, l, h);
            quickSort(arr, l, pivot - 1);
            quickSort(arr, pivot + 1, h);
        }
    }

    static int hoarsPartition(int[] arr, int l, int h) {
        /*
        Picking first element as a pivot and sent it to its correspond place.
         */
        int pivot = arr[l];
        int i = l - 1, j = h + 1;
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if (i >= j)
                return j;
            swap(arr[i], arr[j]);
        }
    }

    public static int lomutoPartition(int[] arr, int l, int h) {
        /*
        Picking last element as a pivot and sent it to its correspond place
         */
        int pivot = arr[h];
        int i = l - 1;
        for (int j = 0; j <= h - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr[i], arr[j]);
            }
        }
        swap(arr[i + 1], arr[h]);
        return i + 1;
    }

    static void partition(int[] arr, int l, int h, int p) {
        int[] temp = new int[h - l + 1];
        int index = 0;
        for (int i = l; i <= h; i++) {
            if (arr[i] <= arr[p]) {
                temp[index++] = arr[i];
            }
        }
        for (int i = l; i <= h; i++) {
            if (arr[i] > arr[p]) {
                temp[index++] = arr[i];
            }
        }
        for (int i = l; i <= h; i++)
            arr[i] = temp[i - l];
    }

    public static int countInversion(int[] arr, int l, int r) {
        int res = 0;
        if (l < r) {
            int m = l + (r - l) / 2;
            res = res + countInversion(arr, l, m);
            res += countInversion(arr, m + 1, r);
            res += countAndMerge(arr, l, m, r);
        }
        return res;
    }

    public static int countAndMerge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1, n2 = r - m;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for (int i = 0; i < n1; i++) {
            left[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[m + 1 + i];
        }
        int res = 0, i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
                res = res + (n1 - i);
            }
            k++;
        }

        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
        return res;
    }

    public static void unionOfSorted(int[] a, int[] b) {
        int m = a.length, n = b.length, i = 0, j = 0;
        while (i < m && j < n) {
            if (i > 0 && a[i] == a[i - 1]) {  //if we traverse already, don't need again.
                i++;
                continue;
            }
            if (j > 0 && a[j] == a[j - 1]) {  //if we traverse already, don't need again.
                j++;
                continue;
            }
            if (a[i] < b[j]) {
                System.out.print(a[i] + " ");
            } else if (a[i] > b[j]) {
                System.out.print(b[j] + " ");
            } else {
                System.out.print(a[i] + " ");
                i++;
                j++;
            }
            while (i < m && a[i] != a[i - 1]) {
                System.out.print(a[i] + " ");
                i++;
            }
            while (j < m && b[j] != b[j - 1]) {
                System.out.print(b[j] + " ");
                j++;
            }
        }
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (r > l) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            int[] ar = merge(arr, l, m, r);
            System.out.println(Arrays.toString(ar));
        }
    }

    public static int[] merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int i = low, j = mid+1, k = 0;
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i+=1;
                k+=1;
            } else {
                temp[k] = arr[j];
                j+=1;
                k+=1;
            }
        }
        while (i <= mid) {
            arr[k] = arr[i];
            i+=1;
            k+=1;
        }
        while (j <= high) {
            arr[k] = arr[j];
            j+=1;
            k+=1;
        }
        for (int l = 0; l < temp.length; l++) {
            arr[l] = temp[l];
        }
        return arr;
    }

    public static void merge(int[] a, int[] b) {
        int m = a.length, n = b.length;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (a[i] <= b[j]) {
                System.out.print(a[i] + " ");
                i+=1;
            } else {
                System.out.print(b[j] + " ");
                j+=1;
            }
        }
        while (i < n) {
            System.out.print(a[i] + " ");
            i+=1;
        }
        while (j < m) {
            System.out.print(b[j] + " ");
            j+=1;
        }

    }

    public static void intersectionTwoArrayEff(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] a = new int[m];
        int i = 0, j = 0;
        //It will work for if both array has same length.
        while (i < m && j < n) {
            if (i > 0 && nums1[i] == nums1[i - 1]) {
                i++;
                continue;
            }
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                System.out.print(nums1[i] + " ");
                i++;
                j++;
            }
        }

    }

    public static void intersectionTwoArray(int[] a, int[] b) {
        int m = a.length, n = b.length;
        for (int i = 0; i < m; i++) {
            if (i > 0 && a[i] == a[i - 1])
                continue;
            for (int j = 0; j < n; j++) {
                if (a[i] == b[j]) {
                    System.out.print(a[i] + " ");
                    break;
                }

            }
        }

    }

    public static void selectionSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int min_ind = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[min_ind]) {
                    min_ind = j;
                }
                swap(nums[i],nums[min_ind]);

            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void insertionSort(int[] arr){
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i-1;
            while (j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    void bubbleSort(int arr[]) {
        /*
        Bubble Sort	, Best Ω(n)	Avg Θ(n^2)	Worst O(n^2)
         */
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap arr[j+1] and arr[j]
                    swap(arr[j+1],arr[j]);
                }
    }

    public static void swap(int i, int j) {
        int t = i;
        i = j;
        j = t;
    }


    public static int[] topKFrequent(int[] nums, int k) {
         int[] res = new int[k];
         int l=0,r= nums.length-1,i=0;
        while (l <= r) {
            int p = lomutoPartition(nums, l, r);
            if (p == k) {
                if (nums[r]!=nums[r+1]) {
                    res[i] = nums[p];
                }
            }else if (p > k) {
                r = p - 1;
            }else {
                l = p + 1;
            }
            i++;
        }
        return res;
    }
}
