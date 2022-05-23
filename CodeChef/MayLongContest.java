package CodeChef;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MayLongContest {
    public static void main(String[] args) {
      doctorChef();
    }

    public static void validPaths(){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            
        }
    }
    public static void doctorChef(){
        Scanner sc = new Scanner(System.in);

        int ntc = sc.nextInt();

        StringBuilder str = new StringBuilder();

        while(ntc -- > 0){

            long N = sc.nextLong();

            long x = sc.nextLong();

            long [] population = new long[(int) N];

            for (int i = 0; i < N; i++) {
                population[i] = sc.nextLong();
            }

            Arrays.sort(population);

            long res = 0;

            int i = 0;

            while((i < N) && 2 * population[i] < x){
                i++;
                res++;
            }

            while(i < N){

                res++;
                if((x < population[i]) && (2 * (population[i] - x) >= population[i])){
                    x = x * 2;
                    continue;
                }
                if(population[i] <= x){
                    x = population[i];
                    i++;
                }
                x = 2 * x;
            }

            str.append(res).append("\n");

        }

        System.out.println(str.toString());

    }

    //May Cook Off 2021

    public static void getmarathon(){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int D = sc.nextInt();
            int d = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            int r = d * D;
            if (r >= 42)
                System.out.println(c);
            else if (r >= 21)
                System.out.println(b);
            else if (r >= 10)
                System.out.println(a);
            else
                System.out.println(0);
        }
    }

    //Real Life Problems Contest
    public static void largeSqure() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        double r = Math.sqrt(n);

        System.out.println(String.format("%.df", r) + " ");
    }

    public static void isomers() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int d = sc.nextInt();

            int r = 0;
            r = ((2 * n - 2) / 2);

        }
    }

    public static void allOperattions() {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int second = sc.nextInt();
        double add, mul, sub, mod;
        add = first + second;
        sub = first - second;
        mul = first * second;
        mod = (double) first / second;
        System.out.println(add + " " + sub + " " + mul + " " + String.format("%.1f", mod) + " ");
    }

    private static void xorEquility() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long x = 0;


        }
    }

    public static void golfCopy() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] golf = new int[m][n];
            int[][] count = new int[n - k + 1][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    golf[i][j] = sc.nextInt();
                }

            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m - k + 1; j++) {
                    int max = 0, ct = 0;
                    for (int l = j; l < j + k; l++) {
                        if (golf[l][i] > max) {
                            max = golf[l][i];
                            ct = 1;
                        } else if (golf[l][i] == max) {
                            ct++;
                        }
                    }
                    golf[j][i] = max;
                    count[j][i] = ct;

                }
            }
            for (int i = 0; i < m - k + 1; i++) {
                for (int j = 0; j < n - k + 1; j++) {
                    int max = 0, ct = count[i][j];
                    for (int l = j; l < j + k; l++) {
                        if (golf[l][i] > max) {
                            max = golf[l][i];
                            ct = count[l][i];
                        } else if (golf[l][i] == max) {
                            ct += count[l][i];
                        }
                    }
                    golf[i][j] = max;
                    count[i][j] = ct;
                }

            }
//            FOR(j,m-k+1){
//                FOR(y,n-k+1)
//                {
//                    printf("%d",golfcourse[i][j]);
//                    if(count[j][y]>1)printf("(%d)",count[j][y]);
//                    if(y!=n-k)printf(" ");
//                }
//                printf("\n");
//            }
//            printf("\n");
            System.out.println();
            for (int i = 0; i < m - k + 1; i++) {
                for (int j = 0; j < n - k + 1; j++) {
                    System.out.println(golf[i][j]);
                    if (count[i][j] > 1)
                        System.out.println(count[i][j]);
                    if (j != n - k)
                        System.out.print(" ");
                }
                System.out.print("");
            }
            System.out.print("");


        }
    }

    public static void sugerSolution() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int r = 0;
            if (b == 1)
                r = a + (100 - x);
            else
                r = a + (100 - x) * b;

            r = r * 10;
            System.out.println(r);
        }
    }
}
