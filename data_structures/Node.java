package data_structures;

//Node structure used for linked lists.
public class Node<T> {
    protected T data;
    protected Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}