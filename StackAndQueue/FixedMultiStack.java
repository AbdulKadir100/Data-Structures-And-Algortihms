package StackAndQueue;

import java.util.EmptyStackException;

public class FixedMultiStack {
    private static final int numberofStack = 3;
    private static int stackCapcity;
    private static int[] values;
    private static int[] sizes;

    public static void main(String[] args) {

        push(1,2);
        push(2,4);


    }

    public FixedMultiStack(int stackSize) {
        stackCapcity = stackSize;
        values = new int[stackSize * numberofStack];
        sizes = new int[numberofStack];

    }

    /*Push value onto stack*/
    public static void push(int stackNum, int value) throws StackOverflowError {
        if (isFull(stackNum)) {
            throw new StackOverflowError();
        }
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }

    /*Pop from the stack*/
    public static int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex];//Get top
        values[topIndex] = 0;//clear
        sizes[stackNum]--;
        return value;
    }

    /*Return top element*/
    public static int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        return values[indexOfTop(stackNum)];
    }

    /*Checking stack is empty*/
    public static boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    /*Check if stack is full or not*/
    public static boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapcity;
    }

    /*Returning top*/
    public static int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapcity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }
}
