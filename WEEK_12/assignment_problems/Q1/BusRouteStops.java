import java.util.*;

public class BusRouteStops {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    static Node build(String[] stops) {
        Node head = null, tail = null;

        for (String stop : stops) {
            Node node = new Node(stop);

            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }

            tail = node;
        }

        return head;
    }

    static void printRoute(Node head) {
        Node current = head;
        int count = 0;
        String first = head.data;
        String last = "";

        while (current != null) {
            System.out.print(current.data + " -> ");
            last = current.data;
            count++;
            current = current.next;
        }

        System.out.println("null");
        System.out.println("Stops: " + count + ", First: " + first + ", Last: " + last);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] stops = new String[n];

        for (int i = 0; i < n; i++) {
            stops[i] = sc.next();
        }

        Node head = build(stops);
        printRoute(head);
    }
}