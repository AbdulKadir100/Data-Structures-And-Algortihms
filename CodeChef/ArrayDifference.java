package CodeChef;

import java.util.Arrays;

public class ArrayDifference {
     public void findDiffernec(int[] arr){
         int j=0;
         Arrays.sort(arr);
         for(int i : arr){
             if (arr[i]>arr[i+1
                     ])
                 j = arr[i] - arr[i+1];
         }
         System.out.println(j);
     }
}
class JobSchedulling{

    int start,end,finish;

    public JobSchedulling(int start, int end, int finish) {
        this.start = start;
        this.end = end;
        this.finish = finish;
    }
    boolean compare(JobSchedulling a,JobSchedulling b){
        return a.finish < b.finish;
    }
}
