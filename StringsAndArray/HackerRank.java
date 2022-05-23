package StringsAndArray;

import java.time.LocalDate;
import java.util.Scanner;

public class HackerRank {
    static Scanner sc = new Scanner(System.in);
    static int B = sc.nextInt();
    static int H = sc.nextInt();
    static boolean flag = true;
    private static int age;
    static {
        try {
            if (H <= 0 || B <= 0) {
                flag = false;
                throw new Exception("Breadth and height must be positive");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


   // public HackerRank(int initialAge) {
        // Add some more code to run some checks on initialAge
    //    age = initialAge;
  //  }

    public static void amIOld() {
        // Write code determining if this person's age is old and print the correct statement:
        if (age <= 0) {
            System.out.println("Age is not valid, setting age to 0.");
            yearPasses();

        } else if (age > 3 && age < 13) {
            System.out.println("You are young");
            yearPasses();
        } else if (age > 13 && age < 18)
            System.out.println("You are teenager");
        else
            System.out.println("You are old");
    }

    public static void yearPasses() {
        // Increment this person's age.
        ++age;
    }

    static void solve(double meal_cost, int tip_percent, int tax_percent) {

        double tip = (meal_cost * tip_percent / 100);
        double tax = (meal_cost * tax_percent / 100);
        double totalCost = meal_cost + tip + tax;
        System.out.println(Math.round(totalCost));

    }

    public static void OddEven(int n) {

        if (n % 2 != 0)
            System.out.println("Weird");
        else if (n >= 2 && n <= 5)
            System.out.println("Not Weird");
        else if (n % 2 == 0 && n >= 6 && n <= 20)
            System.out.println("Not Weird");
        else if (n % 2 == 0 && n > 20)
            System.out.println("Weird");
    }

    public static void Convert(int n){

        String m= String.valueOf(n);
//        if (m == Integer.parseInt(n))
//            System.out.println("Good Job");
        System.out.println(m);
    }

    public static String Date(){
        Scanner sc  = new Scanner(System.in);

        int mm = sc.nextInt();
        int dd = sc.nextInt();
        int yy = sc.nextInt();
        sc.close();
//        LocalDate dt = LocalDate.of(yy,mm,dd);
//        System.out.println(dt.getDayOfWeek());
        return LocalDate.of(yy, mm, dd).getDayOfWeek().name();

    }

    public static void main(String[] args) {
        String input = "1 fish 2 fish red fish blue fish";
        System.out.println(input);
//        Scanner s = new Scanner(input).useDelimiter("\\s*fish\\s*");
//        System.out.println(s.nextInt());
//        System.out.println(s.nextInt());
//        System.out.println(s.next());
//        System.out.println(s.next());
//        s.close();

    }


}
