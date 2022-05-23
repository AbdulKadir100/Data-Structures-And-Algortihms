package GFGSelfPaced;

import java.util.Arrays;
import java.util.*;

import static GFGSelfPaced.Sorting.swap;

public class Recursion {
    static int[] arr = new int[]{3, 1, 2};

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    private static int climbStairs(int indx){
        if (indx==0 || indx==1)
            return 1;
        int left = climbStairs(indx-1);    // left recursion
        int right = climbStairs(indx-2);   // right recursion
        return left+right;
    }
    public static void powerSetAllSubsequence(String s) {
        int n = s.length();
    /*
       if(n & (1<<i)) != 0 so bit is set, otherwise bit is not set.
       1<<n-1 is equal to 2^n-1.
    */
        for (int num = 0; num < (1 << n)-1; num++) {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n-1;i++){
                if ((num & (1<<i)) != 0){
                    sb.append(s.charAt(i));
                }
            }
            System.out.println(sb);
        }
    }
    public static void allKindPatterns(int ind,List<Integer> ds,int s,int sum,
                                       int[] arr,int n){
        if (ind==n){
            if (sum==s){
                for(int i : ds){
                    System.out.println(i);
                }
                return;
            }
        }
        ds.add(arr[ind]);
        s+=arr[ind];
        allKindPatterns(ind+1, ds, s, sum, arr, n);
        s-=arr[ind];
        ds.remove(arr[ind]);
        allKindPatterns(ind+1, ds, s, sum, arr, n);
    }
    public static void printAllSubSeq(int ind, List<Integer> ds, int[] arr, int n) {
        if (n == ind) {
            for (int it : ds) {
                System.out.print(" " + it);
            }
            if (ds.size() == 0) {
                System.out.println("{ }");
            }
            System.out.println();
            return;
        }
        //Take or pick the perticular subsqnce
        ds.add(arr[ind]);
        printAllSubSeq(ind + 1, ds, arr, n);
        ds.remove(arr[ind]);
        //Not pick
        printAllSubSeq(ind + 1, ds, arr, n);


    }

    public static void fun2(int i) {
        // Using single pointer to reverse the array
        if (i >= arr.length / 2)
            return;
        swap(arr[i], arr[arr.length - i - 1]);
        fun2(i + 1);
    }

    public static void fun(int l, int r) {
    /*
    Applying recursion to reverse the array using two pointer l and r
     */
        if (l >= r)
            return;
        swap(arr[l], arr[r]);
        fun(l + 1, r - 1);
    }
}
