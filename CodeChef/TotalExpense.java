package CodeChef;

import java.util.Scanner;

public class TotalExpense {
    public static void main(String[] args) {
        getTotalExpens();

    }

    public static void getTotalExpens() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        double total_expense = 0.0;
        double d = 0.0, m, n;

        while (t-- > 0) {
            int quantity = sc.nextInt();
            int price = sc.nextInt();

            if (quantity > 1000) {
                d = quantity * price;
                m = d * .10;
                total_expense = d - m;
            } else {
                total_expense = quantity * price;
            }
            System.out.println(total_expense);

        }
    }
}
