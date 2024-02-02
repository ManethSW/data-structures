package Q5;

public class PriorityQueue {
    private Node head;

    public PriorityQueue() {
        this.head = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void clear() {
        this.head = null;
    }

    public void enqueue(int index, int distance) {
        Node newNode = new Node(index, distance);
        if (isEmpty() || distance < head.distance) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.distance < distance) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public int[] dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return new int[]{-1, -1};
        } else {
            int deletedIndex = head.index;
            int deletedDistance = head.distance;
            head = head.next;
            return new int[]{deletedIndex, deletedDistance};
        }
    }
}