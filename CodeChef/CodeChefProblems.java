package CodeChef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.lang.Math.abs;

public class CodeChefProblems {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        System.out.printf("%d" +
                "", LCM(120, 140));
    }

    public static int GCD(int a, int b) {

        return (b == 0) ? a : GCD(b, (a % b));
    }
    public static int LCM(int a,int b){
        return (a==0) ? b : a*b/GCD(a,b);
    }
    public static void billiardsWinner() {
        int n = 5;
        int[] scr = new int[]{};
        int[] scr2 = new int[]{};

        while (n > 0) {
            System.out.println("Enter Score of si: ");
            int si = sc.nextInt();
            System.out.println("Enter score of ti: ");
            int ti = sc.nextInt();
            if (abs(scr[si]) > abs(scr2[ti])) {
                int s = scr[si] - scr2[ti];
                System.out.println(s + " is winner, scored: " + scr[si]);
                break;
            } else {
                int t = scr2[ti] - scr[si];
                System.out.println(t + " is winner, scored: " + scr2[ti]);
                break;
            }

        }
    }
    public static void findSqrtOfAValue() {
        System.out.println("ENter a value to find sqrt: ");
        int n = sc.nextInt();
        int r = (int) Math.sqrt(n);
        System.out.println("Sqrt is : " + r);
    }
    public static void ReverseNumber() {
        System.out.println("Enter a number to reverse: ");
        int n = sc.nextInt();
        int t = 10, r = 0;
        while (t-- > 0 && n > 0) {
            r = (r * 10) + (r % 10);
            n = n / 10;
            System.out.println(r);
        }


    }
    public static void find4InList() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter element: ");
        int n = sc.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int r = n % 10;
            if (r == 4)
                count++;
            n = n / 10;
        }
        System.out.println(count + ": times four");


    }
    public static void addFirstAndLast() {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        int ar[] = new int[T];
        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            int last_digit = N % 10;
            int L = (Integer.toString(N)).length();
            int first_digit = N / (int) Math.pow(10, (L - 1));
            ar[i] = first_digit + last_digit;
        }
        for (int element : ar)
            System.out.println(element);


//        int n, l = 0, first = 0, last = 0;
//        System.out.println("Enter number to find last digit: ");
//        first = sc.nextInt();
//        int f = first % 10;
//        System.out.println("Last digit is: " + f);
//
//        System.out.println("Enter number to find first digi: ");
//        last = sc.nextInt();
//        while (last >= 10) {
//            last = (last / 10);
//
//        }
//        System.out.println("First digit is: " + last);
//
//        n = (first + last) % 10;
//
//        System.out.println("Sum of the first and last : " + n);

    }
    public static void sortArray(int[] A, int n) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[]{Integer.parseInt(String.valueOf(br.read()))};
        int k = 0, j = 0;
        for (int i = 0; i < n - 1; i++) {
            for (j = k = i; j < n; j++) {
                if (A[j] < A[k])
                    k = j;
            }

            int temp = A[i];
            A[i] = A[k];
            A[k] = temp;
        }

    }
    public static void sortArray2() throws IOException {
        int A[] = new int[]{5, 3, 6, 7, 1};
        int n = A.length;
        int k = 0, j = 0;
        for (int i = 0; i < n - 1; i++) {
            for (j = k = i; j < n; j++) {
                if (A[j] < A[k])
                    k = j;
            }

            int temp = A[i];
            A[i] = A[k];
            A[k] = temp;
        }
        System.out.println(Arrays.toString(A));
    }
    public static void swap(int x, int y, int[] A) {
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }
    public static int Factorial(int n) {
        // System.out.println("Enter the number to find fact: ");
        if (n == 0)
            return 1;
        return Factorial(n - 1) * n;
    }
    public static void remainderOfDigit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first: ");
        int a = sc.nextInt();
        System.out.println("Enter Second: ");
        int b = sc.nextInt();
        int r = a % b;
        System.out.println("Remainder is: " + r);

    }
    public static void sumOfDigit() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter values to sum: ");
        int a = br.read();

        int res = 0;
        while (a > 0) {
            res = res + a;
            //  a++;
            System.out.println(res);
        }

    }
    public static void Add() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int ans = 0;
        while (n > 0) {
            int x = sc.nextInt();
            if (x % k == 0) {
                ans++;
                n--;
            }
        }
        System.out.println(ans);

    }
    public static void Intest() throws IOException {
        Scanner sc = new Scanner(System.in);
        InputStream inputStream = System.in;
        InputStreamReader in = new InputStreamReader(inputStream);
        int n = in.read();
        int k = in.read();
        int result = 0;
        int m = Integer.parseInt(String.valueOf(in.read()));

        for (int i = 0; i < n; i++) {
            int x = in.read();
            if (x % k == 0) {
                result++;
            }
        }
        System.out.println(result);

    }
    public static void ATm() {
        Scanner sc = new Scanner(System.in);
        int amntWithd;
        double bal;
        System.out.println("Entre amount to withdraw: ");
        amntWithd = sc.nextInt();
        bal = sc.nextDouble();

        if (bal >= amntWithd + 0.5) {
            if (amntWithd % 5 == 0) {
                bal = bal - (amntWithd + 0.5);
                System.out.println(bal);
            } else {
                System.out.println(bal);
            }

        } else {
            System.out.println(bal);
        }
    }

}
