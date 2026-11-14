import java.util.*;

public class CancelBooking {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    static Node removeFirst(Node head, String booking) {
        if (head == null) {
            System.out.println(booking + " not found");
            return null;
        }

        if (head.data.equals(booking)) {
            return head.next;
        }

        Node current = head;

        while (current.next != null &&
               !current.next.data.equals(booking)) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println(booking + " not found");
        } else {
            current.next = current.next.next;
        }

        return head;
    }

    static void print(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
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

        String booking = sc.next();
        head = removeFirst(head, booking);
        print(head);
    }
}