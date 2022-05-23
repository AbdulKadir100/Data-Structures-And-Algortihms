package StackAndQueue;

class Calculator {

    public  float average(int a,int b,int c){
        return ((float)(a+b+c)/3);
    }
}

class Tester {

    public static void main(String args[]) {
        Calculator calculator = new Calculator();
        float ans = calculator.average(12,8,15);
        System.out.printf("%.2f",ans);
    }
}