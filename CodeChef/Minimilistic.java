package CodeChef;

import java.util.Scanner;

public class Minimilistic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int move = 0;
        while (t-- > 0) {
            int n = sc.nextInt();
            while (n > 0) {
                if ((n - 3) == 2) {
                    move++;
                    n -= 3;
                    break;

                } else if (n % 5 == 2) {
                    n /= 5;
                    move++;
                    break;
                } else if (n % 5 == 0) {
                    n /= 5;
                } else {
                    n -= 3;
                }
                move++;
            }
//            System.out.println(n);
             if (n == 2) {
                 System.out.println(-1);
             }else{
                 System.out.println(move);
             }

        }

    }
}
