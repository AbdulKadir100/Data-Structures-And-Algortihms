package CodeChef;/* package codechef; // don't place package name! */

import FastRead.FastReader;

import java.util.*;
import java.lang.*;
import java.io.*;
//abstract class A{
//    abstract void run();
//}
//class B extends A{
//
//    @Override
//    void run() {
//
//    }
//}
public class Main {
    public static void main(String[] args) throws IOException {

       FastReader f = new FastReader();
       int t = f.nextInt();
       while (t-->0){
           int n = f.nextInt();
           HashMap<String,Integer> map = new HashMap<>();
           map.put(f.next(),f.nextInt());
           for (int i = 1; i < 3*n; i++) {
               String str = f.next();
               int x= f.nextInt();
               if (map.containsKey(str)){
                   map.replace(str,map.get(str)+x);

               }else {
                   map.put(str,x);
               }
               List<Integer> arr = new ArrayList<>(map.values());
               Collections.sort(arr);
               for(Integer integer : arr){
                   System.out.println(integer+" ");
               }
               System.out.println();

           }

       }
}
    public static boolean isUniqueString(String isUnique){
        boolean[] c = new boolean[128];
        if (isUnique.length() > 128)
            return false;
        int count=0;
        for (int i = 0; i < isUnique.length(); i++) {
           int v = isUnique.charAt(i);
           if (c[v])
               return false;
           c[v] = true;

        }
        return true;
    }
    public static int getWinner(){
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        while (t-->0){
            int n = fr.nextInt();
            int m = fr.nextInt();
            int[] an = new int[n];
            for (int i = 0; i < n; i++) {
                an[i] = fr.nextInt();
            }
            int[] am = new int[n];
            for (int i = 0; i < n; i++) {
                am[i] = fr.nextInt();
            }
        }
        return 0;
    }
    public static void div3(){
        FastReader fr = new FastReader();
        int res=0, sum=0;;
        var t = fr.nextInt();
        while (t-->0){
            var n = fr.nextInt();
            var k = fr.nextInt();
            var d = fr.nextInt();
            int[] setter = new int[n];
            for (int i = 0; i < n; i++) {
                setter[i] = fr.nextInt();
            }
            for(int i=0;i<n;i++)
            {
                sum = sum + setter[i];
            }
            res = sum/k;
            System.out.println(Math.min(res, d));

        }
    }

    public static void getAllSubMatrix() {
        int[][] mat = new int[][]{
                {2, 2, 3}, {3, 4, 5}, {4, 5, 5}
        };
        int k = 4;
//        int[][] dp = getSum(mat);

    }

//    private static int[][] getSum(int[][] mat) {
//        int[][] dp = new int[mat.length + 1][mat[0].length + 1];
//        for (int i = 0; i < mat.length; i++) {
//            for (int j = 0; j < mat[0].length; j++) {
//                dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j + 1] - dp[i][j] + mat[i][j];
//            }
//        }
//        return dp;
//    }
}

