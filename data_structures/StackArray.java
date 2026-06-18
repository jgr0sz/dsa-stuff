package data_structures;

import java.util.Arrays;

/*
Array-based stack:
[1, 2, 3, 5]
            top*/
public class StackArray<T> {
    int size;
    //top of the stack, increment every time we push, decrement when we pop
    int topIdx;
    T[] arr;

    //Default constructor
    @SuppressWarnings("unchecked")
    public StackArray() {
        //Indicates nothing in stack
        topIdx = -1;
        size = 0;
        //Default array size, will double
        arr = (T[]) new Object[10];
    }

    //Getter method for arr.
    public T[] getArr() {
        return this.arr;
    }

    //Method that checks if StackArray is full, resizes, then pushes a new value to the top.
    public void push(T value) {
        //If array is full, double size
        if (this.topIdx == this.arr.length - 1) {
            T[] resizedArr = Arrays.copyOf(this.arr, this.arr.length * 2);
            this.arr = resizedArr;
        }
        this.topIdx++;
        this.arr[this.topIdx] = value;
        this.size++;
    }

    //Method that removes a value from the top of the stack array and returns it.
    public T pop() {
        T value = null;
        //empty array check
        if (this.topIdx > -1) {
            value = this.arr[this.topIdx];
            this.arr[this.topIdx] = null;
            topIdx--;
            size--;
        }
        return value;
    }

    //Helper method to display the stack array in stdout
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<this.arr.length; i++) {
            sb.append(this.arr[i]);
            sb.append(", ");
        }
        return sb.toString();
    }
}
