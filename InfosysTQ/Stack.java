package InfosysTQ;

import static StackAndQueue.FixedMultiStack.pop;

class Stack {

    private int top;
    private int maxSize;
    private int[] arr;

    Stack(int maxSize) {
        this.top = -1;
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        if (top >= (maxSize - 1)) {
            return true;
        }
        return false;
    }

    public boolean push(int data) {
        if (isFull()) {
            return false;
        }
        else {
            arr[++top] = data;
            return true;
        }
    }

    public int peek() {
        if (isEmpty())
            return Integer.MIN_VALUE;
        else
            return arr[top];
    }

    public void display() {
        if (isEmpty())
            System.out.println("Stack is empty!");
        else {
            System.out.println("Displaying stack elements");
            for (int index = top; index >= 0; index--) {
                System.out.println(arr[index]); // accessing element at position index
            }
        }
    }

    public boolean isEmpty() {
        if (top < 0) {
            return true;
        }
        return false;
    }

    public int pop() {
        if (isEmpty())
            return Integer.MIN_VALUE;
        else
            return arr[top--];
    }
}


class Tester {

    public static void main(String args[]) {

        Stack stack = new Stack(10);
        stack.push(15);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        calculateSum(stack);

        System.out.println("Updated stack");
        stack.display();
    }

    public static void calculateSum(Stack stack) {

        int sum =0;
        if (!stack.isEmpty()) {
            while (stack != null) {
                sum += stack.pop();
            }
            System.out.println("Sum is "+sum);
        }
    }
    public static void stackSum(Stack stack){

    }
}





