package NageswaraRao;

import java.util.HashSet;
import java.util.Iterator;

public class Hashset {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();
        hs.add("India");
        hs.add("America");
        hs.add("Mexico");
        hs.add("Aus");
       // hs.clear();
        System.out.println("Hash Set is : "+hs);
        for (String s : hs) {
            System.out.print(" "+s);
        }

    }
}
