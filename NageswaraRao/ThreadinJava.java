package NageswaraRao;

import java.io.IOException;
import java.util.Scanner;

public class ThreadinJava {

        public static void main(String[] args) throws IOException {
            Demo obj = new Demo();
            Thread t = new Thread(obj);
            t.start();
            System.in.read();
            obj.stop = true;

        }

    }
    class Demo extends Thread{
        boolean stop = false;

        public void run(){
            for (int i = 1; i < 100; i++) {
                System.out.print(" "+i);
                if (stop) return;
            }
    }


       public static void main(String[] args) {
           Scanner sc = new Scanner(System.in);
           String s = sc.nextLine();

       }
}
