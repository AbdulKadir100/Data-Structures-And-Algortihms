package CodeChef;

import java.util.Scanner;

public class PuppySum {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t,d,n;
         t = sc.nextInt();

        while (t-- > 0) {
            d = sc.nextInt();
            n = sc.nextInt();
            while (d-- > 0) {
                n = getsum(n);
            }
            System.out.println(n);
        }
        sc.close();

    }

    public static int getsum(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}
