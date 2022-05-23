package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class StringDigit {
    public static void main(String[] args) {
        String str = "a123bc34d8ef34";
         getDigit(str);
        //System.out.println(r);

    }
    public static void getDigit(String str) {
        boolean found=false;
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c: chars){
            if (Character.isDigit(c)){
                sb.append(c);
                found =true;

            }else if (found){
                break;
            }

        }
        System.out.println(sb);
    }

    }

