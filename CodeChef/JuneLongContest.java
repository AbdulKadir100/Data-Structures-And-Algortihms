package CodeChef;

import FastRead.FastReader;

import java.util.*;
import java.io.*;

public class JuneLongContest {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            int k = fr.nextInt();
            int[] ar = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = fr.nextInt();
            }
            int[] setBit = new int[31];
            int count;
            for (int bit = 0; bit <= 30 ; bit++) {
                count=0;
                    for(int i : ar){
                        if (i%2==0){
                            count++;
                        }
                        i/=2;
                    }
                    setBit[bit] = count;
            }
            int ans=0;
            for (int bit = 0; bit <= 30 ; bit++) {
                if (setBit[bit]%2==k){
                    ans+=setBit[bit]/k;
                }else{
                    ans+=setBit[bit]/k+1;
                }
            }
            System.out.println(ans);
        }


    }


    public static void chefBank() {

        FastReader fr = new FastReader();
        int t = fr.nextInt();
        while (t-- > 0) {
            long D = fr.nextLong();
            long d = fr.nextLong();
            long p = fr.nextLong();
            long q = fr.nextLong();
            long remain = D % d;
            long div = D / d;
            long sum = 0;
            sum += (d * (p * div + (q * (div - 1) * div / 2)));
            sum += remain * (p + div * q);
            System.out.println(sum);
        }
    }

    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        for (int t = 2; t <= cost.length; t++) {
            dp[t] = Math.min(cost[t - 1] + dp[t - 1], cost[t - 2] + dp[t - 2]);
        }

        return dp[cost.length];
    }

    public static void shortroute() {
        FastReader f = new FastReader();
        int t = f.nextInt();
        while (t-- > 0) {
            int n = f.nextInt();
            int m = f.nextInt();
            int[] cities = new int[n];
            for (int i = 0; i < n; i++) {
                cities[i] = f.nextInt();
            }
            int[] travellers = new int[m];
            for (int i = 0; i < m; i++) {
                travellers[i] = f.nextInt();
            }
            int closest = Integer.MAX_VALUE;
            int[] one = new int[n];
            int[] two = new int[n];
            for (int i = 0; i < n; i++) {
                if (cities[i] == 1) {
                    closest = i;
                }
                one[i] = closest;
            }
            closest = Integer.MAX_VALUE;
            for (int i = n - 1; i >= 0; i--) {
                if (cities[i] == 2) {
                    closest = i;
                }
                two[i] = closest;
            }
            for (int i = 0; i < m; i++) {
                if (one[travellers[i] - 1] == Integer.MAX_VALUE && two[travellers[i] - 1] == Integer.MAX_VALUE) {
                    System.out.print(-1 + " ");
                } else if (one[travellers[i] - 1] == Integer.MAX_VALUE) {
                    System.out.print(Math.abs(two[travellers[i] - 1] - travellers[i] + 1) + " ");
                } else if (two[travellers[i] - 1] == Integer.MAX_VALUE) {
                    System.out.print(Math.abs(travellers[i] - 1 - one[travellers[i] - 1]) + " ");
                } else {
                    System.out.print(Math.min(Math.abs(one[travellers[i] - 1] - travellers[i] - 1), Math.abs(two[travellers[i] - 1] - travellers[i] + 1)));
                }
            }
            System.out.println();
        }

    }

    public static void chefcoconut() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int xa = sc.nextInt();
            int xb = sc.nextInt();
            int Xa = sc.nextInt();
            int Xb = sc.nextInt();
            int typeA = Xa / xa;
            int typeB = Xb / xb;
            System.out.println(typeA + typeB);
        }
    }

}
