package algorithms;

import java.util.EmptyStackException;

public class StackVerTwo {
    private Integer[] arr;
    private int top;
    public StackVerTwo() {
        this.arr = new Integer[10000];
        this.top = 0;
    }

    public StackVerTwo(int size) {
        this.arr = new Integer[size];
        this.top = 0;
    }

    public void push(int value) {
        this.arr[this.top++] = value;
    }

    public Integer[] getArr() {
        return this.arr;
    }

    public int pop() {
        if (this.isEmpty()) throw new EmptyStackException();
        return this.arr[--this.top];
    }

    public boolean isEmpty() {
        return this.top == 0;
    }
}
