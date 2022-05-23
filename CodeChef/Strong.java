package CodeChef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Strong {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] arr = br.readLine().trim().split(" ");
            int n = Integer.parseInt(arr[0]);
            int k = Integer.parseInt(arr[1]);
            String s = br.readLine();
            int count = 0;
            boolean is = false;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i) == '*'){
                    count++;
                }else{
                    count = 0;
                }
                if(count == k){
                    is = true;
                    break;
                }
            }
            if(is){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }
}
