import java.util.Arrays;
import algorithms.Algorithms;

public class Main {
    public static void main(String[] args) {
        Integer[] nums = {24, 97, 56, 1, 12};

        //Insertion sort
        System.out.printf("Insertion Sort\nBefore: %s\nAfter: %s\n\n", 
        Arrays.toString(nums), Arrays.toString(Algorithms.insertionSort(nums)));

        //Sorted nums with insertion sort for binary search
        System.out.printf("Binary Sort\nTarget: 56 (index 3)\nRetrieved: %d\n\n",
        Algorithms.BinarySearch(Algorithms.insertionSort(nums), 56));
    }
}
