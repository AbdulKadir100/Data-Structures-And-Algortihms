package NageswaraRao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Comprator {
    /*Class for ascending order print*/
    static abstract class Acsending implements Comparator<Integer> {

        public int compareTo(Integer i1, Integer i2) {
            return i1.compareTo(i2);
        }
    }

    static abstract class Descend implements Comparator<Integer> {

        public int compareTo(Integer i1, Integer i2) {
            return i2.compareTo(i1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new
                InputStreamReader(System.in));
        System.out.println("How many line ");
        int size = Integer.parseInt(br.readLine());
        Integer[] ar= new Integer[size];
        /*Convert obj into int*/
        for (int i = 0; i < ar.length; i++) {
            System.out.println("Enter int: ");
            ar[i]= Integer.parseInt(br.readLine());
        }
        //Sorting array in Ascending order
       // Arrays.sort(ar,new Acsending());
    }


}



