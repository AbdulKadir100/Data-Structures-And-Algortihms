package GFGSelfPaced;

import java.util.*;

public class Searching {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,2,4,1,4};
        System.out.println(minPags(arr,3));

    }

    public static int minPags(int[] arr, int k) {
        int sum = 0, mx = 0;
        for (int j : arr) {
            sum += j;
            mx = Math.max(mx, j);
        }
        int low = mx, high = sum, res = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isFesiable(arr, k, mid)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;

            }
        }
        return res;
    }

    public static boolean isFesiable(int[] arr, int k, int mid) {
        int req = 1, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] > mid) {
                req++;
                sum = arr[i];
            } else {
                sum += arr[i];
            }
        }
        return (req <= k);
    }

    public static int findRepeat(int[] nums) {
        // Constraints is array could not be modified.

        int slow = nums[0], fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static boolean pairSum(int[] ar, int x) {
        /*
        If the array is sorted then we would go for two pointer approach
        If Not Sorted then we have to move on hashing.
         */
        int low = 0, high = ar.length - 1;
        while (low < high) {
            int sum = ar[low] + ar[high];
            if (sum == x)
                return true;
            else if (sum > x)
                high--;
            else
                low++;
        }
        return false;
    }

    public static int peakElement(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((mid == 0 || nums[mid - 1] <= nums[mid]) && (mid == n - 1 || nums[mid + 1] <= nums[mid]))
                return mid;
            if (mid > 0 && nums[mid - 1] >= nums[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public int searchInRotated(int[] nums, int target) {
        int low = 0, n = nums.length, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[low] < nums[mid])
                if (target >= nums[low] && target < nums[mid])
                    high = mid - 1;
                else
                    low = mid - 1;
            else if (target > nums[mid] && target <= nums[high])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
//    public int singleNonDuplicate(int[] nums) {
//        int n = nums.length;
//        int low=0,high = n-1;
//        while (low<= high){
//            int mid = (low+high)/2;
//            if ()
//        }
//    }
    public static int searchInfiniteArray(int[] arr, int x) {
        if (arr[0] == x)
            return 0;
        int i = 1;
        while (arr[i] < x) {
            i = i * 2;
            if (arr[i] == x)
                return i;
            return itrativeBinarySearch(arr, x);
        }
        return 0;
    }

    public static int countOne1(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == 0)
                low = mid + 1;
            else {
                if ((mid == 0) || arr[mid - 1] == 0)
                    return n - mid;
                else
                    high = mid - 1;


            }
        }
        return 0;
    }

    private static int numberOfOccurance(int[] arr, int x) {
        int n = arr.length;
        int first = firstOccuranceEff(arr, x);
        if (first == -1)
            return 0;
        else
            return (LastOccuranceEff(arr, x) - first + 1);

    }

    private static int LastOccuranceEff(int[] arr, int x) {
        int n = arr.length;
        int low = 0, high = n - 1;
        if (low > high)
            return -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < x)
                low = mid + 1;
            else if (x < arr[mid])
                high = mid - 1;
            else {
                if (mid == n - 1 || arr[mid] != arr[mid + 1])
                    return mid;
                else
                    low = mid + 1;
            }
        }
        return -1;
    }

    private static int firstOccuranceEff(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        if (low > high)
            return -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (x > arr[mid])
                low = mid + 1;
            else if (x < arr[mid])
                high = mid - 1;
            else {
                if (mid == 0 || arr[mid - 1] != arr[mid])
                    return mid;
                else
                    return mid - 1;
            }
        }
        return -1;
    }

    private static int firstOccurance(int[] arr, int low, int high, int x) {
        if (low > high)
            return -1;
        int mid = low+(high-low) / 2;
        if (x > arr[mid])
            return firstOccurance(arr, mid + 1, high, x);
        else if (x < arr[mid])
            return firstOccurance(arr, low, mid - 1, x);
        else if (mid == 0 || arr[mid - 1] != arr[mid])
            return mid;
        else
            return firstOccurance(arr, low, mid - 1, x);
    }
    public static int BinarySearch(int[] arr, int low,int high,int key) {
        int oldlow = low;
        int olhigh = high;
        while (low <= high) {
            int mid = low + (high-low) / 2;
            if (arr[mid] == key)
                return mid;
            else if (arr[mid] > key)
                high = mid - 1;
            else
                low = mid + 1;
        }
//        low -=1;
//        if (low>=oldlow && low <= olhigh)return low;
//        else
           return high+1;
    }
    public static int itrativeBinarySearch(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low +( high-low) / 2;
            if (arr[mid] == x)
                return mid;
            else if (arr[mid] > x)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = firstOccuranceEff(nums, target);
        res[1] = LastOccuranceEff(nums, target);
        return res;
    }


}
