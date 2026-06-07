package algorithms;

public class Algorithms {

    //Insertion sort: very simple sort algorithm with O(n^2) time complexity.
    //Starting at index 1, it continously goes through an array, checking if the current value is less or greater than the previous value.
    //If it is greater, it remains in front; if lesser, it is shifted down one element and compared with j-1, j-2... until it is sorted.
    public static <T extends Comparable<T>> T[] insertionSort(T[] arr) {
        //N and I are respectively the current/starting and ending points of the sort.
        int n = arr.length;
        int i = 1;

        while (i < n) {
            T current = arr[i];
            int j = i-1;
            //Note to self (been forever since I've used Java): compareTo returns a positive integer if greater than arg
            while (j >= 0 && arr[j].compareTo(current) > 0) {
                arr[j+1] = arr[j];
                j -= 1;
            }
            arr[j+1] = current;
            i += 1;
        }
        return arr;
    }

    //Binary search: well-known searching algorithm with O(log(n)) time complexity. Assumes a sorted array.
    //Beginning by finding the highest and lowest indexes, it calculates a middle index.
    //After checking if the target isn't at the middle index, it evaluates whether the target is greater/less
    //Than the middle index value. If it is greater, we exclude the half we know is less than the target and repeat our search.
    public static <T extends Comparable<T>> int BinarySearch(T[] arr, T target) {
        int highIndex = arr.length;
        int lowIndex = 0;
        
        //Loop runs until there are no more elements to check
        while (lowIndex <= highIndex) {
            int midIndex = (int) Math.floor((highIndex + lowIndex)/2);
            //Best case: median value is target
            if (arr[midIndex] == target) {
                return midIndex;
            }
            //Halves search area of target based on the target's value in relation to arr[midIndex] (median value).
            if (arr[midIndex].compareTo(target) < 0) {
                lowIndex = midIndex + 1;
            }
            else {
                highIndex = midIndex - 1;
            }
        }
        //Element not found
        return -1;
    }
}