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
        System.out.printf("Linked list:\n%s\n", linkedList.toString());
    }
}
