package CodeChef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class ArrayGame {
    public static void main(String[] args) throws IOException {
        getGameArray();

    }

    public static void getGameArray() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int resAman = 0, resRaju = 0;
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] ar = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = sc.nextInt();
            }
            HashSet<Integer> set = new HashSet<>();

            // Traverse an array element
            for (int i : ar)
                set.add(i);
            //return (set.size()%2==0)?1:2;
            if (set.size() % 2 == 0)
                System.out.println("Aman");
            else
                System.out.println("Raju");
        }
    }

    public static void getSubArray() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m, n, maxUnique = 0;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        int[] ar = new int[n];
        for (int l = 0; l < n; l++) {
            ar[l] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i <= n - m; i++) {
            int crntUnique = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int k = i; k < i + m; k++) {
                if (!map.containsKey(ar[k])) {
                    map.put(ar[i], 1);
                    crntUnique++;
                }
            }
            if (crntUnique > maxUnique)
                maxUnique = crntUnique;
        }
        System.out.println(maxUnique);
    }
}
