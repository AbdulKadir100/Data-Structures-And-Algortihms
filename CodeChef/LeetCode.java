package CodeChef;

import java.util.Arrays;

public class LeetCode {
    public static void main(String[] args) {
        int[] candies = new int[]{1,4,7,9,3,6,4,5};
        int n = candies.length/2;
        int [] arr = shuffle(candies,n);
        System.out.println(Arrays.toString(arr));
    }
    public static int[] shuffle(int[] nums, int n) {
        int N = n-1;
        int[] arr = new int[2*n];
        for(int i=0;i<2*n;i++){
            if((i+1) % 2 == 0){
                arr[i] = nums[i];
            }
            else{
                arr[i] = nums[N++];
            }
        }
        return arr;

    }
}
