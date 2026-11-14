import java.util.*;

public class BookCopyFinder {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    static String find(Node head, String id) {
        int position = 1;
        int first = -1;
        int copies = 0;

        Node current = head;

        while (current != null) {
            if (current.data.equals(id)) {
                if (first == -1) {
                    first = position;
                }
                copies++;
            }

            position++;
            current = current.next;
        }

        if (copies == 0) {
            return id + " not found";
        }

        return id + " first at position " + first + ", copies: " + copies;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Node head = null, tail = null;

        for (int i = 0; i < n; i++) {
            Node node = new Node(sc.next());

            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }

            tail = node;
        }

        String id = sc.next();
        System.out.println(find(head, id));
    }
}