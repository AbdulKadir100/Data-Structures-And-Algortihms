package GFGSelfPaced;

import java.util.*;
import java.lang.*;
import java.util.Arrays;

//class MyHash {
//    int bucket;
//    ArrayList<LinkedList<Integer>> table;
//
//    MyHash(int b) {
//        bucket = b;
//        table = new ArrayList<>();
//        for (int i = 0; i < b; i++) {
//            table.add(new LinkedList<>());
//        }
//    }
//
//    boolean search(int key) {
//        int i = key % bucket;
//        return table.get(i).contains(key);
//    }
//
//    void remove(int key) {
//        int i = key % bucket;
//        table.get(i).remove(i);
//    }
//
//    void insert(int key) {
//        int i = key % bucket;
//        table.get(i).add(key);
//    }
//}

public class Hashing {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int r= sc.nextInt();
       int[] ar = new int[n];
       Set<Integer> set = new HashSet<>();



    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4)
            return new ArrayList();
        List<List<Integer>> set = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            int l = n - 2;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k] + nums[l];
                if (sum == target)
                    set.add(Arrays.asList(nums[i], nums[j++], nums[k--] + nums[l--]));
                else if (sum > target)
                    k--;
                else
                    j++;
            }
        }
        return new ArrayList(set);
    }

    public int[] intersectionHash(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (Integer n : nums1) set1.add(n);
        HashSet<Integer> set2 = new HashSet<>();
        for (Integer n : nums2) set2.add(n);

        set1.retainAll(set2);

        int[] output = new int[set1.size()];
        int idx = 0;
        for (int s : set1) output[idx++] = s;
        return output;
    }

    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : nums) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > 1) {
                res += e.getKey();
            }
        }
        return res;
    }

    static int[] moreThanNbyKOccurence(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : arr) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }
        int i = 0;
        int[] ar = new int[k];
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > n / k) {
                // System.out.print(e.getKey() + " ");
                ar[i++] = e.getKey();
            }
        }
        return ar;

    }

    ArrayList<Integer> countDistinct(int[] A, int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        // Collections.sort(list,Collections.reverseOrder());
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i <= n - k; i++) {
            set.add(A[i]);
            list.add(set.size());
        }
        return list;
    }

    static int countDistinictElement(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(arr[i], i);
        }
        for (int i = k; i < n; i++) {
            map.put(arr[i], i);
            //map.put(arr[i-k],i--);
            if (arr[i - k] == 0)
                map.remove(arr[i - k]);
            if (!map.containsKey(arr[i]))
                map.put(arr[i], i);
            else
                map.put(arr[i], i++);
        }
        return map.size();
    }

    static int longConscSubseqnc(int[] arr) {
        int n = arr.length;
        int res = 0, curr;
        HashSet<Integer> map = new HashSet<>();
        for (int j : arr) {
            map.add(j);
        }
        for (int i = 0; i < n; i++) {
            //If it have previous value e.g,{3,8,4,5,7} 4-1=3
            // which it has,so it would start from 3
            if (!map.contains(arr[i] - 1)) {
                curr = 1;
                while (map.contains(arr[i] + curr)) {
                    curr++;
                }
                //Update the result
                res = Math.max(res, curr);
            }
        }
        return res;
    }

    static int twoBinarySum(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = arr1[i] - arr2[i];
        }
        return longestSum(temp, 0);
    }

    static int longest01Sum(int[] arr, int sum) {
        int n = arr.length;
        HashMap<Integer, Integer> m = new HashMap<>();
        int pre_sum = 0, res = 0;
        for (int k = 0; k < n; k++) {
            if (arr[k] == 0) {  //If see any 0 replace with -1.
                arr[k] = -1;
            }
            pre_sum += arr[k];
            if (pre_sum == sum)
                res = k + 1;
            if (!m.containsKey(pre_sum))
                m.put(pre_sum, k);
            //Update the result if 'pre_sum - sum' is present.
            if (m.containsKey(pre_sum - sum)) {
                if (res < k - m.get(pre_sum - sum))
                    res = k - m.get(pre_sum - sum);
            }
        }
        return res;
    }

    static int longestSum(int[] arr, int sum) {
        int n = arr.length;
        HashMap<Integer, Integer> m = new HashMap<>();
        int pre_sum = 0, res = 0;
        for (int k = 0; k < n; k++) {
            pre_sum += arr[k];
            if (pre_sum == sum)
                res = k + 1;
            if (!m.containsKey(pre_sum))
                m.put(pre_sum, k);
            if (m.containsKey(pre_sum - sum)) { //if so then update res.
                if (res < k - m.get(pre_sum - sum))
                    res = k - m.get(pre_sum - sum);
            }
        }
        return res;
    }

    static boolean subarrayGivenSum(int[] arr, int sum) {
        HashSet<Integer> h = new HashSet<>();
        int pre_sum = 0;
        for (int j : arr) {
            pre_sum += j;
            if (pre_sum == sum)
                return true;
            if (h.contains(pre_sum - sum))
                return true;
            h.add(j);
        }
        return false;
    }

    static boolean zeroSumSubarray(int[] arr) {
        HashSet<Integer> h = new HashSet<>();
        int pre_sum = 0;
        for (int j : arr) {
            pre_sum += j;
            if (h.contains(pre_sum))
                return true;
            if (pre_sum == 0)
                return true;
            h.add(pre_sum);
        }
        return false;
    }

    static boolean pairSum(int[] arr, int sum) {
        HashSet<Integer> s = new HashSet<>();
        for (int j : arr) {
            if (s.contains(sum - j))
                return true;
            s.add(j);
        }
        return false;
    }

    static int union(int[] arr, int[] brr) {
        HashSet<Integer> set = new HashSet<>();
        for (int j : arr) {
            set.add(j);
        }
        for (int i : brr) {
            set.add(i);
        }
        return set.size();
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> al = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j : nums1) {
            if (!map.containsKey(j))
                map.put(j, 0);
            map.put(j, map.get(j) + 1);
        }
        for (int j : nums2) {
            if (map.containsKey(j) && map.get(j) > 0) {
                al.add(j);
                map.put(j, map.get(j) - 1);
            }
        }
        int[] arr = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            arr[i] = al.get(i);
        }
        return arr;
    }

    static int intersection(int[] arr, int[] brr) {
        int[] r = new int[arr.length];
        HashSet<Integer> set = new HashSet<>();
        for (int j : arr) {
            set.add(j);
        }
        int res = 0;
        for (int i : brr) {
            if (set.contains(i)) {
                res++;
                set.remove(i);
            }
        }
        return res;
    }

    static void freqcy(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int x : arr) {
            hm.put(x, hm.getOrDefault(x, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }

}
