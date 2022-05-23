package HackerRank;

import InfosysTQ.Collection;

import java.io.*;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static GFGSelfPaced.Sorting.*;


public class Solutions {
    public static int mod = 1000000007;    //  10^9+7 for large input data.
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(numberOfSteps(n));


        
//        Arrays.sort(arr);
//        List<Integer> a = new ArrayList<>();
//        a.add(arr[0]);
//        List<Integer> b = new ArrayList<>();
//        for (int i = 1; i < arr.length; i++) {
//            if (i % 2 != 0) {
//                a.add(arr[i]);
//            } else {
//                b.add(arr[i]);
//            }
//        }
//        Collections.sort(b, Collections.reverseOrder());
//        b.addAll(a);
//        System.out.println(b);


    }
    public static int numberOfSteps(int num) {
        int count=0;
        while (num !=0) {
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
    public static List<Integer> songPair(int rideD,List<Integer> songDuration){
        List<Integer> res = new ArrayList<>();
        Set<Integer> s = new HashSet<>(songDuration);
        int newRide = rideD-30;
        //For corner cases
        Integer[] arr = new Integer[]{-1,-1};
        List<Integer> res2 = Arrays.asList(arr);

        //Base Case
        if (songDuration.size()< 2 || rideD < 30)
            return res2;

        for (int i = 0; i < songDuration.size(); i++) {
            if (s.contains(Math.abs(newRide-songDuration.get(i)))){
                res.add(i);
            }
        }
        return res;
    }

    public static void shiftK(int[] arr, int k) {
        int n = arr.length;
        int[] res = new int[n];
        if (k == 0 || k >= n)
            return;
        res[0] = arr[0];
        int ind = 1;
        for (int i = n - k; i < n; i++) {
            res[ind++] = arr[i];
        }
        for (int i = 1; i < n - k; i++) {
            res[ind++] = arr[i];
        }
        System.out.println(Arrays.toString(res));
    }

    public static void sqr(int val1, int val2) {
        int res = 0;
        for (int i = val1; i < val2; i++) {
            int x = i;
            if (x * x == Math.sqrt(i)) {
                res += i;
            }

        }
        System.out.println(res);
    }

    public static void nextPermutation(int[] nums) {
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

    public static int birthdayCakeCandles(List<Integer> candles) {
        Collections.sort(candles);
        int last = candles.size() - 1;
        int sum = 0;
        for (int i = 0; i <= candles.size() - 1; i++) {
            if (candles.get(i) == last)
                sum++;
            else
                break;
        }
        return sum;
    }

    public static String superReducedString(String s) {

        StringBuffer sf = new StringBuffer(s);
        for (int i = 1; i < sf.length(); i++) {
            if (sf.charAt(i) == sf.charAt(i - 1)) {
                sf.delete(i - 1, i + 1);
                i = 0;
            }
        }
        if (sf.length() == 0) System.out.println("Empty String");
        else System.out.println(sf);

        return sf.toString();

    }

    public static String timeConversion(String s) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ssaa");
        DateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date time = null;
        String res = "";
        time = dateFormat.parse(s);
        res = format.format(time);
        return res;

    }

    public static void extraLongFactorials(int n) {
        BigInteger bg = new BigInteger("1");
        for (int i = 2; i <= n; i++) {
            bg = bg.multiply(BigInteger.valueOf(i));
        }
        System.out.println(bg);

    }


    public static void miniMaxSum(List<Integer> arr) throws IOException {

        long[] nums = new long[arr.size()];
        Collections.sort(arr);
        for (int i = 0; i < arr.size(); i++) {
            nums[i] = arr.get(i);
        }

        long max = arr.size() - 1, min = 0, sum = 0;

        for (int i = 1; i < 5; i++) {

            if (nums[i] > max) max = nums[i];
            if (nums[i] < min) min = nums[i];
            sum += nums[i];
        }
        System.out.println((sum - max) + " " + (sum - min));

    }

    public static void staircase(int n) {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++)
            builder.append(" ");
        int j = 0;

        for (int i = 1; i <= n; i++) {
            builder.replace(builder.length() - i,
                    builder.length() - j, "#");
            System.out.println(builder);
            j++;
        }
    }

    public static void plusMinus(List<Integer> arr) throws IOException {
        double cnt1 = 0, cnt2 = 0, cnt3 = 0;
        double r1 = 0, r2 = 0, r3 = 0;

        List<Integer> arr2 = new ArrayList<>();

        int[] ar = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            ar[i] = arr.get(i);
        }
        for (Integer i : ar) {
            arr2.add(i);
        }

        for (Integer integer : arr2) {
            if (integer > 0)
                cnt1++;
            if (integer < 0)
                cnt2++;
            if (integer == 0)
                cnt3++;
        }
        r1 = cnt1 / arr.size();
        r2 = cnt2 / arr.size();
        r3 = cnt3 / arr.size();

        System.out.printf("%.6f %n", r1);
        System.out.printf("%.6f %n", r2);
        System.out.printf("%.6f %n", r3);


    }

    public static int diagonalDifference(List<List<Integer>> arr) {

        int[][] arr2 = arr.stream().map(u -> u.stream().mapToInt(i -> i).toArray()).toArray(int[][]::new);
        int l = arr2.length;
        int sum = 0, r1 = 0, r2 = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                if (i == j) {
                    r1 += (int) arr2[i][j];
                }
                if (i == l - j - 1) {
                    r2 += (int) arr2[i][j];
                }
            }
        }
        sum = Math.abs(r1 - r2);
        return sum;
    }
}
