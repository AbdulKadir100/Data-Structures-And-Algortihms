package TCSPractice;

import java.util.*;

public class MyClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[2];
        for(int i=0;i< students.length;i++){
            int id = sc.nextInt();//sc.nextLine();
            double fees = sc.nextDouble();
            String name = sc.nextLine();
            students[i] = new Student(id,fees,name);
        }
        //sc.nextLine();
        String nam = sc.nextLine();
        sc.close();
        Student s = totalStd(students,nam);
        if(s==null){
            System.out.println("There is no student with cleared their dues");
        }else
            System.out.println(s.getName()+" "+s.getRoll()+" ");

    }
    public static Student totalStd(Student[] arr,String name){
        List<Student> list = new ArrayList<>();
        for(Student s : arr){
            if(s.getFees()==0){
                list.add(s);
            }
        }
        if(list.size()==0)
            return null;
        Collections.sort(list,new Comp2());
        return list.get(list.size()-2);
    }
}
class Comp2 implements Comparator<Student>{
    public int compare(Student s1,Student s2){
        return s1.getName().compareTo(s2.getName());
    }
}
class Student{
    private int roll;
    private double fees;
    private String name;

    public Student(int roll, double fees, String name) {
        this.roll = roll;
        this.fees = fees;
        this.name = name;
    }

    public boolean isPaid(){
        return fees==0;
    }
    public int getRoll() {
        return roll;
    }
    public double getFees() {
        return fees;
    }

    public String getName() {
        return name;
    }
}
