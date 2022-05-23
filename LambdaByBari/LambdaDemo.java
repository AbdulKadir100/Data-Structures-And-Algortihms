package LambdaByBari;

@FunctionalInterface
interface MyLambda {
    void display();
}
//class My implements MyLambda{
//    public void display(){
//        System.out.println("hi there! im in interface");
//    }

public class LambdaDemo {
    public static void main(String[] args) {
        MyLambda m = () -> { System.out.println("hi there! im in interface");
                             System.out.println("Second statement in lambda");
        };
        m.display();

    }
}
