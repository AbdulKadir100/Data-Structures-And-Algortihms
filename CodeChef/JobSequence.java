package CodeChef;

import java.util.Arrays;

public class JobSequence {
    private final int start;
    private final int finish;
    private static int profit;

    public JobSequence(int start, int finish, int profit) {
        this.start = start;
        this.finish = finish;
        this.profit = profit;
    }

    boolean compare(JobSequence a, JobSequence b) {
        return a.finish < b.finish;
    }
    private static int findMProfit(int[][] arr, int n){
   //     Arrays.sort(arr);
        int[] dp = new int[n];
        dp[0] = profit;

        for (int i=0;i<n;i++){
            int including  = arr[i].length;
            int lNconflict = -1;

            for (int j = i-1; j >0 ; j--) {
                if (arr[j].length >= arr[j].length){
                    lNconflict = j;
                    break;
                }
            }

            if (lNconflict != -1){
                including += dp[lNconflict];
            }
            dp[i] = Math.max(including,dp[i-1]);

        }
        return dp[n-1];
    }


    public static void main(String[] args) {
        int[][] arr = new int[][]{{2,5,50},{1,2,20},{6,9,70},{2,50,400}};
       int r = findMProfit(arr,4);
        System.out.println(r);
    }
}
