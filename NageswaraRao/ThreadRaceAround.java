package NageswaraRao;

public class ThreadRaceAround {
    int value;
    boolean flag= true;

   synchronized public int getValue() {
        int x = 0;
       while (flag!=false){
           try{  wait();}catch (Exception e){}
       }
        x = value;
       flag = true;
        return x;
    }

   synchronized public void setValue(int v) {
       while (flag!=true){
         try{  wait();}catch (Exception e){}
       }
       value = v;
       flag=false;
       notify();
    }

    static class Producer extends Thread {
        ThreadRaceAround data;

        public Producer(ThreadRaceAround d) {
            data = d;
        }

        public void run() {
            int count=1;
           while (true){
               data.setValue(count);
               System.out.println("Producer: "+count);
               count++;
           }
        }
    }

    static class Consumer extends Thread {
        ThreadRaceAround data;

        public Consumer(ThreadRaceAround d) {
            data = d;
        }

        public void run() {
            int val;
            while (true){
               val =  data.getValue();

                System.out.println("Consumer: "+val);
            }
        }
    }

    public static class CheckRace{
        public static void main(String[] args) {
            ThreadRaceAround th = new ThreadRaceAround();
            Producer p = new Producer(th);
            Consumer c = new Consumer(th);
            p.start();
            c.start();

        }

    }
}
