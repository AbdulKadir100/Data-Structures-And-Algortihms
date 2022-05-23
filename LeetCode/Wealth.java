package LeetCode;

import java.util.Arrays;
import java.util.Scanner;

class Wealth {
    public static void main(String[] args) {
        int[] a = new int[]{1, 3};
        int[] b = new int[]{2,7};
       float r  = medianOfTwoArrat(a, b);
        System.out.println(r);
//        int[][] ar = new int[][]{{1,5}, {7, 3},{3,5}};
//        int ans = maximumWealth(ar);
//        System.out.println(ans);
    }

    public static int maximumWealth(int[][] accounts) {
        int sumRow = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < accounts.length; i++) {
            sumRow = 0;
            for (int j = 0; j < accounts[0].length; j++) {
                sumRow += accounts[i][j];

            }
            if (sumRow > maxSum) {
                maxSum = sumRow;

            }
        }
        return maxSum;
    }

    public static float medianOfTwoArrat(int[] nums1, int[] nums2) {
        float mid = 0;
        int la = nums1.length;
        int lb = nums2.length;
        int c = la + lb;
        int[] c1 = new int[c];
        System.arraycopy(nums1, 0, c1, 0, la);
        System.arraycopy(nums2, 0, c1, la, lb);

        Arrays.sort(c1);
        System.out.println(Arrays.toString(c1));
        int sum=0;
        for (int i=0;i<=c1.length;i++){
            sum+=i;
        }
        System.out.println(sum);
        mid = (float) (c1[0] + (c1[c1.length-1-c1[0]])/sum);
        return mid;
    }

}


