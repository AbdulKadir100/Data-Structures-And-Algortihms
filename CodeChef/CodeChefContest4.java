package CodeChef;

import java.util.Arrays;
import java.util.Scanner;

public class CodeChefContest4 {

    public static void main(String[] args) {
       twoDivisibleThree();
    }

    public static void twoDivisibleThree() {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int s1 = sc.nextInt();//4
            int s2 = sc.nextInt();//2
            int s3 = sc.nextInt();//1
            if (s2 > s3)
                System.out.println(s1 + s3 + (s2 - s3) / 3);
            else if (s3 > s2)
                System.out.println(s1 + s2 + (s3 - s2) / 3);
            else
                System.out.println(s1 + s2);
        }
    }

    public static void chefCPL() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();

            if (str.contains("I")) {
                System.out.println("INDIAN");
            } else if (str.contains("N") && !(str.contains("Y")) && !(str.contains("I"))) {
                System.out.println("NOT SURE");
            } else {
                System.out.println("NOT INDIAN");
            }

        }
    }

    public static void chefHeaven() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            double life = (double) n / 2;
            life = Math.round(life);
            int good = 0, bad = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    good++;
                } else {
                    bad++;
                }
            }
            if (good >= life) {
                System.out.println("Yes");
            } else
                System.out.println("NO");


        }
    }

    public static void eqionixString() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            long a = sc.nextLong();
            long b = sc.nextLong();
            sc.nextLine();
            long sarthak = 0, anuradha = 0;
            for (int i = 0; i < n; i++) {
                String str = sc.nextLine();
                str.trim();
                str.toUpperCase();
                char ch = str.charAt(0);
                if (ch == 'E' || ch == 'Q' || ch == 'U' || ch == 'I' || ch == 'N' || ch == 'O' || ch == 'X')
                    sarthak += a;
                else
                    anuradha += b;
            }
            if (anuradha == sarthak)
                System.out.println("DRAW");
            else if (anuradha > sarthak)
                System.out.println("ANURADHA");
            else
                System.out.println("SARTHAK");
        }
    }

    public static void tripSong() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int m = sc.nextInt();
            int s = sc.nextInt();
            int r = 0;
            r = m / s;
            System.out.println(r);
        }
    }

    static int gcdFun(int a, int b) {
        if (b == 0) return a;
        return gcdFun(b, a % b);
    }

    public static void cuttingRecipe() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int gcd = arr[0];

            for (int j = 1; j < n; j++) {
                gcd = gcdFun(arr[j], gcd);


            }
            for (int k = 0; k < n; k++) {
                System.out.print((arr[k] / gcd) + " ");
            }
            System.out.println();
        }
    }

    public static String find5() {
        boolean flag = false;
        String s = "";
        int[] arr = new int[]{12, 65, 4, 67, 987, 234, 87, 89,
                6745, 567, 987, 476, 708, 36, 5587, 798, 884, 671, 7889};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 5 == 0) {
                s = "Hello World!";
            } else
                s = "there is no 5 in the array";
        }
        return s;
    }

    public static int tetrahedral(int n) {
        return (2 * n + 1) * (n * n + n + 3) / 3;
    }

    public static void multipleOFConsecutive() {
        int sum = 1;
        int[] ar = new int[]{3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        for (int i = 0; i < ar.length; i++) {
            sum = sum * ar[i];
        }
        System.out.println(sum);
    }

    public static void triangle() {
        int h = 10;
        int b = 6;
        int a = Math.abs(h * b) / 2;
        System.out.println(a);
    }
}
