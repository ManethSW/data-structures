package Q4;

public class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addToTail(25);
        ll.addToTail(40);
        ll.addToTail(70);
        ll.removeAtIndex(1);
        int indexData = ll.getAtIndex(1);
        System.out.println(indexData);
        ll.addToTail(80);
        int size = ll.getSize();
        System.out.println(size);
    }
}