import java.util.Arrays;
import algorithms.*;
import data_structures.*;

public class Main {
    public static void main(String[] args) {
        Integer[] nums = {24, 97, 56, 1, 12};

        //Insertion sort
        System.out.printf("Insertion Sort\nBefore: %s\nAfter: %s\n\n", 
        Arrays.toString(nums), Arrays.toString(Algorithms.insertionSort(nums)));

        //Sorted nums with insertion sort for binary search
        System.out.printf("Binary Sort\nTarget: 56 (index 3)\nRetrieved: %d\n\n",
        Algorithms.BinarySearch(Algorithms.insertionSort(nums), 56));

        //Linked list operations
        data_structures.LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.append(67);
        linkedList.insert(linkedList.getHead(), 0, 18);
        linkedList.append(45);
        linkedList.delete(linkedList.getHead(), 1);
        System.out.printf("Linked list:\n%s\n\n", linkedList.toString());

        //StackArray operations
        StackArray<Integer> stackArray = new StackArray<>();
        stackArray.push(12);
        stackArray.push(16);
        System.out.printf("Stack array:\n%s\nPopped value (top): %d\n\n", 
        stackArray.toString(), stackArray.pop());

        //StackLinkedList operations
        StackLinkedList<String> linkedstack = new StackLinkedList<>();
        linkedstack.push("Foo");
        linkedstack.push("Bar");
        System.out.printf("Stack linked list:\n%s\nPopped value (top): %s\n\n", 
        linkedstack.getList().toString(), linkedstack.pop());
    }
}
