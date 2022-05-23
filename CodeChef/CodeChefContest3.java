package CodeChef;


import java.math.BigDecimal;
import java.util.*;
import java.util.Scanner;

public class CodeChefContest3 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boardExam();
    }


    public static void longSubstring(){
        String s = "abbba";
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        

    }
    public static void boardExam(){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int x= sc.nextInt();
            int y = sc.nextInt();
            BigDecimal b = new BigDecimal(factorial(n));
            BigDecimal b1 = new BigDecimal(factorial(n-x));
            BigDecimal b2 = new BigDecimal(factorial(n-y));
            
            System.out.println(b+" "+b1+" "+b2);

        }
    }
    public static int factorial(int n){
        int result = 1;
        if (n <= 0) return 0;
        for (int i = 2; i <=n ; i++) {
            result  *= i;
        }
        return result;
    }
    public static void todo(){
        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] arr = new int[n];
        int sum=0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum+=arr[i];
        }
        sum+=x;
        if (sum<=24)
            System.out.println("Yes");
        else
            System.out.println("No");

    }
    public static void hiringTest() {
        int t = sc.nextInt();
        while (t-- > 0) {
            int f = 0, u = 0, p = 0;
            int n = sc.nextInt();
            int m = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            char[] str = new char[m];

            while (n-->0) {
                while (m-- > 0) {
                    str = sc.next().toCharArray();
                    if (str[m] == 'F') {
                        f++;
                    }
                    if (str[m] == 'U') {
                        u++;
                    }
                    if (str[m]=='P') {
                        p++;
                    }
                }
                    if (f >= x || f >= x - 1 && p >= y) {
                        System.out.print("1");
                    } else {
                        System.out.print("0");
                    }

            }

            System.out.println(str);
        }
    }
    public static void island() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int xr = sc.nextInt();
            int yr = sc.nextInt();
            int d = sc.nextInt();

            int res = 0, sum = 0, min1 = 0, min2 = 0;
            min1 = x / xr;
            min2 = y / yr;
            sum = Math.min(min1, min2);
            if (sum >= d) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }


        }
    }
    public static int sumBase(int n, int k) {
        int res = 0;
        while (n !=0){
            res += n % k;
            n  /=  k;
        }

        return res;
    }
    public static void listOfBooks() {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> barr = new ArrayList<>();
        ArrayList<Integer> biarr = new ArrayList<>();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            barr.add(sc.nextInt());
        }
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            biarr.add(sc.nextInt());
        }
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < biarr.size(); j++) {
                System.out.println(barr.get(biarr.get(j) - 1));
                barr.remove(biarr.get(j) - 1);
            }
        }
    }
}
