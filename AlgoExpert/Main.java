package AlgoExpert;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Node{
    int[] children;
    int name;
    Node(int name){
       this.name = name;
       children = new int[]{};
    }
    public void addChild(int name2){
        children[name] = name2;
    }
}

public class Main {

    public static void main(String[] args) {
        System.out.println(multiply("123456789","987654321"));
    }
    public static String multiply(String num1, String num2) {
         double n = Double.parseDouble(num1);
         double m = Double.parseDouble(num2);
         return new String(String.valueOf(m*n));
    }
    public static boolean balanceBrackets(String str){
        String openingbrackts = "([{";
        String closingbrackets = ")]}";
        Map<String,String> map = new HashMap<>();
        map.put(")","(");
        map.put("]","[");
        map.put("}","{");
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == openingbrackts.charAt(i)){
                stack.push(str.charAt(i));
            }else if (str.charAt(i)==closingbrackets.charAt(i)){
                if (stack.size()==0){
                    return false;
                }
//                if((stack.size()-1) == map.containsKey(closingbrackets)){
//
//                }
            }
        }
        return true;
    }
}
