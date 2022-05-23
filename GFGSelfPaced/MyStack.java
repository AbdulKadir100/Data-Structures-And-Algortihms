package GFGSelfPaced;

import java.util.ArrayList;
import java.util.Stack;

public class MyStack {
   ArrayList<Integer> al = new ArrayList<>();
   public static void main(String[] args) {

    }
    boolean isBalaced(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++){
            if (str.charAt(i)=='(' || str.charAt(i)=='[' || str.charAt(i)=='{'){
                s.push(str.charAt(i));
            }else {
                if (s.isEmpty()){
                    return false;
                }else if (!matching(s.peek(),str.charAt(i))){
                    return false;
                }else {
                    s.pop();
                }
            }
        }
        return (s.isEmpty());
    }
    boolean matching(char a, char b){
       return ((a=='(' && b==')')||(a=='[' && b==']')||(a=='{' && b=='}'));
    }
    void push(int x){
       al.add(x);
    }
    int pop(){
        if(!al.isEmpty()) {
            int res = al.get(al.size() - 1);
            al.remove(al.size() - 1);
            return res;
        }
        return -1;
    }
    int peek(){
        return al.get(al.size()-1);
    }
    int size(){
        return al.size();
    }
    boolean isEmpty(){
        return al.isEmpty();
    }


}
