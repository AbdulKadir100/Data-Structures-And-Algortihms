package InfosysTQ;

public class ArrayTest {

    public static void insert(char[] ar, int pos, char val) {

        //Traversing the array from the last position to the position where the element has to be inserted
        for (int i = ar.length - 1; i >= pos - 1; i--) {
            ar[i] = ar[i - 1];

        }
        //Inserting value at specified.
        ar[pos-1] = val;
    }
    public static void delete(char[] ar, int pos){
        //Traversing the array from the position where the element has to be deleted to the end
        for(int i=pos-1;i<ar.length-1;i++){

            //Moving each element one position to the left
            ar[i] = ar[i+1];
        }
        //The space that is left at the end is filled with character '0'
        ar[ar.length-1]='0';
    }

    public static void main(String[] args) {
        char arr[]=new char[6];
        arr[0]='A';
        arr[1]='B';
        arr[2]='J';
        arr[3]='C';
        arr[4]='D';
        arr[5]='E';
        ArrayTest.delete(arr,1);
        for (char c : arr) {
            System.out.println(c);
        }
    }
}
