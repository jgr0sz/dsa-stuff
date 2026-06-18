package data_structures;

//Simplest dynamic data structure, using nodes containing pointers and data.
public class LinkedList<T> {
    private Node<T> head;

    //Simple getter to access the head instance variable.
    public Node<T> getHead() {
        return this.head;
    }

    //Simple setter to modify the head variable in linked list stacks.
    public void setHead(Node<T> node) {
        this.head = node;
    }

    //Simple O(n) operation adding a new node to the end of a linked list, or as the head if no nodes present.
    public void append(T data) {
        Node<T> newNode = new Node<>(data);

        //Becomes head node if none is present
        if (head == null) {
            head = newNode;
            return;
        }

        //Retaining head node for traversal to end.
        Node<T> tmp = head;
        while(tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }

    //Simple O(n) to find and return a node at a given index.
    public Node<T> search(Node<T> head, int idx) {
        Node<T> curr = head;
        int count = 0;

        //Iterates through linked list as long as we haven't passed the element position or have reached the final connected node.
        while (count < idx && curr != null) {
            curr = curr.next;
            count++;
        }
        return curr;
    }

    //O(1) simple insertion by reassigning the previous node's pointer and assigning the new node's to the next node.
    private void insertIntoList(Node<T> prev, Node<T> newNode) {
        newNode.next = prev.next;
        prev.next = newNode;
    }

    //O(1) insertion into any part of the linked list.
    public Node<T> insert(Node<T> head, int idx, T value) {
        //Case where we are inserting a new head
        if (idx == 0) {
            Node<T> newHead = new Node<>(value);
            newHead.next = head;
            this.head = newHead;
            return newHead;
        }

        //Otherwise, we find the prev node using search() and insert the new node normally.
        Node<T> prev = search(head, idx);
        //null check
        if (prev == null) {
            throw new IndexOutOfBoundsException("Index " + idx + " is OOB.");
        }
        Node<T> newNode = new Node<>(value);
        insertIntoList(prev, newNode);
        return head;
    }

    //Deletes a node at a specified index, returning its head.
    public Node<T> delete(Node<T> head, int idx) {
        //null check
        if (head == null) {
            return null;
        }

        //Check for head node being deleted, return new head
        if (idx == 0) {
            Node<T> newHead = head.next;
            head.next = null;
            return newHead;
        }

        int count = 0;
        Node<T> curr = head;
        Node<T> prev = new Node<>(null);

        //Traversing to node location
        while (count < idx && curr != null) {
            prev = curr;
            curr = curr.next;
            count++;
        }

        //Deleting, nulling, and relinking nodes
        if (curr != null) {
            prev.next = curr.next;
            curr.next = null;
        }
        else {
            throw new IndexOutOfBoundsException("Index " + idx + " is OOB.");
        }
        return head;
    }

    //Helper method to display the linked list in stdout
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> tmp = this.head;

        while (tmp != null) {
            sb.append(tmp.data);
            if (tmp.next != null) {
                sb.append(", ");
            }
            tmp = tmp.next;
        }
        return sb.toString();
    }
 }
