package data_structures;

//Linked list-based stack
public class StackLinkedList<T> {
    //Reusing the linked list class
    private LinkedList<T> list;

    public StackLinkedList() {
        list = new LinkedList<>();
    }

    //Helper method to return the internal linked list used.
    public LinkedList<T> getList() {
        return this.list;
    }

    //Method that pushes a value by adding it to a node at the top of the stack.
    public void push(T value) {
        //Though LinkedList's insert() at index 0 works, creating a new head node and wiring both is also O(1).
        Node<T> newNode = new Node<>(value);
        newNode.next = list.getHead();
        list.setHead(newNode);
    }

    //Method that removes the head node and rewires the nodes. 
    public T pop() {
        T value = null;
        if (list.getHead() != null) {
            //Our old head is stored in value, then disconnected, the next node becoming head.
            //This allows the garbage collector to free its memory.
            value = list.getHead().data;
            list.setHead(list.getHead().next);
        }
        return value;
    }
}
