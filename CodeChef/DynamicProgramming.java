package CodeChef;

import java.util.Arrays;
import java.util.Scanner;

public class DynamicProgramming {
    public static void main(String[] args) {
        int[] a = new int[]{1,-2,3,4};
        chefAndString();
    }

    public static void chefOfGroups(){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (sc.hasNext()){

            String s = sc.nextLine();
            int count=0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1')
                    count++;
            }
            System.out.println(count);
        }
    }
    public static void noTimeToWait(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();
        int x = sc.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }
        boolean isTrue = false;
        for (int i = 0; i < n-1; i++) {
            if (ar[i] + x >= h || ar[i + 1] + x >= h) {
                isTrue = true;
                break;
            }
        }
        if (isTrue)
            System.out.println("YES");
        else
            System.out.println("NO");

    }
    public static int maxSubArraySum(int[] arr,int n){
        int current_sum=0,best_sum=0;
        for (int i = 0; i < n; i++) {
            current_sum+=arr[i];
            if (current_sum>best_sum)
                best_sum=current_sum;
        }
        if (current_sum < 0)
            current_sum=0;
        return best_sum;
    }
    public static void maxSubarray() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int[] b = new int[n];
            Arrays.fill(b,1);
            for (int i = 1; i < n; i++) {
                if (arr[i] >= arr[i-1])
                    b[i] = b[i-1]+1;
                else
                    b[i] = 1;
            }
            int sum=0;
            for (int i = 0; i < n; i++) {
                sum+=b[i];
            }
            System.out.println(sum);
        }
    }
    public static void chefAndString() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            String str = sc.nextLine();
            str.toLowerCase();
            int count = 0, count2 = 0;
            for (int i = 0; i < str.length(); i++) {

                if (str.charAt(i) == 'x' && str.charAt(i + 1) == 'y' ||
                        str.charAt(i) == 'y' && str.charAt(i) == 'x')
                    count++;
                i++;

            }

            System.out.println(count);


        }
    }
}
