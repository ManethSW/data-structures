package Q5;

public class Node {
    public int index;
    public int distance;
    public Node next;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
        this.next = null;
    }
}