package algorithms;

import java.util.Arrays;

public class StackImplementation {
    private int[] stack = new int[10000];
    private int valuePos;

    public StackImplementation() {
        this.valuePos = 0;
    }

    public StackImplementation(int size) {
        this.stack = new int[size];
        this.valuePos = 0;
    }

    public void push(int value) {
        stack[valuePos] = value;
        valuePos++;
    }

    public void printStack() {
        System.out.println(Arrays.toString(stack));
    }

    public int[] getStack() {
        return stack;
    }
}
