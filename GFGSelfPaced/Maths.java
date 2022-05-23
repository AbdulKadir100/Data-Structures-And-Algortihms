package GFGSelfPaced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Maths {
    public static void main(String[] args) throws IOException {

    }
    public static boolean armStrong(int n){
        int r=0,sum=0,temp=n;
        while (n > 0) {
            r = n % 10;
            sum = sum + (r * r * r);
            n = n / 10;
        }
        return temp == sum;
    }
    public static boolean isPrime(int n) {
        // 0 and 1 are neither prime nor composite numbers
        if (n == 0 || n == 1) {
            return false;
        }
        // 2 is a prime number
        if (n == 2) {
            return true;
        }
        // every composite number has a prime factor
        // less than or equal to its square root.
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;

    }
    static void printDivisors(int n) {
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0)
                System.out.print(i + " ");
            if (i != n / i)
                System.out.print(n / i + " ");
        }
    }

    static int lcm(int a, int b) {
        return (a * b) / gcdEuclid(a, b);
    }

    static int gcdEuclid(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcdEuclid(b, a % b);
    }

    static int gcd(int a, int b) {
        /*
        GCD with euclid algorithm
        if(a>b)
            a = a-b;
        else
            b=b-a;
        return (a==b) a or b;
         */
        int res = Math.min(a, b);
        while (res > 0) {
            if (a % res == 0 && b % res == 0) {
                break;
            }
            res--;
        }
        return res;
    }

    static int countTrailing0Eff(int n) {
        int res = 0;
        for (int i = 5; i <= n; i = i * 5) {
            res = res + n / i;
        }
        return res;
    }

    static int countTrailingZeros(int n) {
        //Overflow issues with data types to avoid this we can use double.
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        int res = 0;
        while (fact % 10 == 0) {
            res++;
            fact /= 10;
        }
        return res;
    }

    static boolean reverseNumber(int n) {
        int rev = 0;
        int temp = n;
        while (temp != 0) {
            int ld = temp % 10;
            rev = rev * 10 + ld;
            temp = temp / 10;
        }
        return (rev == n);

    }

    static int counDigit(int x) {
        int res = 0;
        while (x > 0) {
            x = x / 10;
            res++;
        }
        return res;
    }
}
