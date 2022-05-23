package Numbers;

public class Number {
    public static void main(String[] args) {
        divisibleByThree(5);
    }
    public static void divisibleByThree(int n){
        int d=0;

        for(int i=0;i<n;i++)

            for(int j=0;j<n;j++)

                for(int k=0;k<n;k++) {

                    if (((i+j+k) % 3)==0)

                        d=d+1;

                }
        System.out.println(d);
    }
}
