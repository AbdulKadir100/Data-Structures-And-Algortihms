package AbdulBariNetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ReverseEchoNetwork {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(2000);
        Socket skt = ss.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(skt.getInputStream()));
        PrintStream ps = new PrintStream(skt.getOutputStream());

        String msg;
        StringBuilder sb;
        do {
            msg = br.readLine();
            sb = new StringBuilder(msg);
            sb.reverse();
            msg = sb.toString();
            ps.println(msg);
        }while (!msg.equals("dne"));

    }
}

class Client {
    public static void main(String [] args) throws Exception{

            Socket skt = new Socket("localhost",2000);

            BufferedReader keyB = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader br = new BufferedReader(new InputStreamReader(skt.getInputStream()));
            PrintStream ps = new PrintStream(skt.getOutputStream());

            String msg;

            do {
                msg = keyB.readLine();
                ps.println(msg);
                msg = br.readLine();
                System.out.println("From Server: "+msg);
            }while (!msg.equals("dne"));


    }
}
