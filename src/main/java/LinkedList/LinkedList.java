package LinkedList;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        head = tail = null;
    }

    private boolean isEmpty() {
        return head == null && tail == null;
    }

    private boolean isValidIndex(int index) {
        return index >= size || index < 0;
    }

    public int getSize() {
        return size;
    }

    public void addToTail(int data) {
        if (isEmpty()) {
            head = tail = new Node(data);
        } else {
            Node temp = new Node(data);
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    public void removeAtIndex(int index) {
        if (isEmpty()) {
            System.out.println("Linked List is empty");
        } else if (isValidIndex(index)) {
            throw new IndexOutOfBoundsException("Invalid index");
        } else if (index == 0) {
            head = head.next;
        } else {
            Node temp = head;
            index--;
            for (int count = 0; count < index; temp = temp.next) {
                count++;
            }
            temp.next = temp.next.next;
        }
        size--;
    }

    public int getAtIndex(int index) {
        if (isEmpty()) {
            System.out.println("Linked List is empty");
        } else if (isValidIndex(index)) {
            throw new IndexOutOfBoundsException("Invalid index");
        } else {
            Node temp = head;
            for (int count = 0; count < index; temp = temp.next) {
                count++;
            }
            return temp.data;
        }
        return -1;
    }
}