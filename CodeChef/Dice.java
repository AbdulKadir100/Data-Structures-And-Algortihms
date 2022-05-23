package CodeChef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dice {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int sum;
            int n = Integer.parseInt(br.readLine());
            sum = (n / 4) * 44; //each layer (4 dices) will contribute of 44 i,e: (5+6)*4
            int r = n % 4;
            if (n >= 4) {
                if (r == 0) { // perfect 2*2 pile
                    sum += 16;
                }
                if (r == 1) {
                    sum += 32;
                }
                if (r == 2) {
                    sum += 44;
                }
                if (r == 3) {
                    sum += 55;
                }
                System.out.println(sum);
            } else {
                // if there are less then 3 dice
                int res=0;
                if (r == 1) {
                    res = 20;
                }
                if (r == 2) {
                    res = 36;
                }
                if (r == 3) {
                    res = 51;
                }
                System.out.println(res);
            }
        }
    }
}
