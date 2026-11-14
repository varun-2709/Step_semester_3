import java.util.*;

public class LateComersLine {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    static Node addFirst(Node head, String name) {
        Node node = new Node(name);
        node.next = head;
        return node;
    }

    static Node addLast(Node head, String name) {
        Node node = new Node(name);

        if (head == null) {
            return node;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = node;
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
        Node head = null;

        for (int i = 0; i < n; i++) {
            head = addLast(head, sc.next());
        }

        int operations = sc.nextInt();

        for (int i = 0; i < operations; i++) {
            String command = sc.next();
            String name = sc.next();

            if (command.equals("addFirst")) {
                head = addFirst(head, name);
            } else if (command.equals("addLast")) {
                head = addLast(head, name);
            }
        }

        print(head);
    }
}