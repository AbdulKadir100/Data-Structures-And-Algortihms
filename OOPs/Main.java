package OOPs;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Patient patient = new Patient("Saket",20,
                new Eye("Left Eye","Short sighted","blur",true),
                new Eye("Right Eye","Normal","blue",true),
                new Heart("Heart","Normal",65),
                new Stomach("Stomach","normal",false),
                new Skin("Skin","Normal","white",40));
        System.out.println("Name "+patient.getName());
        System.out.println("Age "+patient.getAge());

        Scanner scanner = new Scanner(System.in);
        boolean shouldfinish=false;
        while (!shouldfinish){
            System.out.println("Choose an option:"+
                    "\n\t1. Left Eye" +
                    "\n\t2. Right Eye" +
                    "\n\t3. Heart" +
                    "\n\t4. Stomach" +
                    "\n\t5. Skin" +
                    "\n\t6. Quit");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    patient.getLefteye().getDetails();
                    if (patient.getLefteye().isOpend()){
                        System.out.println("\t\t1. Closed the Eye");
                        if (scanner.nextInt() == 1){
                            patient.getLefteye().close();
                        }else {
                            continue;
                        }
                    }else {
                        System.out.println("\t\t1. Open the eye");
                        if (scanner.nextInt() == 1){
                            patient.getLefteye().open();
                        }else {
                            continue;
                        }
                    }
                    break;
                case 2:
                    patient.getRighteye().getDetails();
                    if (patient.getRighteye().isOpend()){
                        System.out.println("\t\t1. Closed the Eye");
                        if (scanner.nextInt() == 1){
                            patient.getRighteye().close();
                        }else {
                            continue;
                        }
                    }else {
                        System.out.println("\t\t1. Open the eye");
                        if (scanner.nextInt() == 1){
                            patient.getRighteye().open();
                        }else {
                            continue;
                        }
                    }
                    break;
                case 3:
                    patient.getHeart().getDetails();
                    System.out.println("\t\t1. Change the heart rate: ");
                    if (scanner.nextInt() == 1){
                        System.out.println("Enter the new heart rate: ");
                        int newrate = scanner.nextInt();
                        patient.getHeart().setRate(newrate);
                        System.out.println("Heart rate changed to: "+patient.getHeart().getRate());

                    }else {
                        continue;
                    }
                    break;
                case 4:
                    patient.getStomach().getDetails();
                    System.out.println("\t\t1. Digest");
                    if (scanner.nextInt() == 1){
                        patient.getStomach().digest();
                    }else {
                        continue;
                    }
                    break;
                case 5:
                    patient.getSkin().getDetails();
                    break;
                default:
                    shouldfinish = true;
                    break;


            }
        }


//        Car mercedes = new Car("Mercedz am", 2, "Silver", new Engine("Renault", 8000));
//        System.out.println(mercedes.getName());
//        Engine e = mercedes.getEngine();
//        System.out.println("Engine Model: " + e.getName() + "  Round per minute is: " + e.getRpm());

//        Animal bird = new Animal("Nina","Golden",2,true,2);
//        System.out.println(bird.getName());
//        bird.eat("Meet");
//        System.out.println(bird.getWings());


//        Phone iPhone = new Phone("iPhone 11", 5, 8, 8);
//
//        System.out.println(iPhone.getName());
//
//        Phone pixal = new Phone("Pixal 3", 6);
//        System.out.println(pixal.getName());


//        iPhone.setCamera(9);
//        System.out.println(iPhone.getCamera());
//        iPhone.setMemoryRam(6);
//        iPhone.setScreenSize(6);
//        System.out.println(iPhone.getMemoryRam());
    }
}
