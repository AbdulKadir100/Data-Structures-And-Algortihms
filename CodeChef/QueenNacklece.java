package CodeChef;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class QueenNacklece {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 1, 4, 3, 4, 6};
        queen();
    }

    public static void queen() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int c = 0, i1 = 0;
        // boolean ans=true;

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i <= arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            Set<Integer> set = new HashSet<>();
            boolean ans = false;
            int i=0;
            while (i<n){
                int val = arr[i];
                int count = 1;
                int index = i+1;
                while (index<n && val == arr[index]){
                    count++;
                    index++;
                }
                i = index;
                if (set.contains(count)){
                    ans = true;
                    break;
                }
                set.add(count);
            }
            if (ans){
                System.out.println("No");
            }else {
                System.out.println("Yes");
            }


        }

    }
}
