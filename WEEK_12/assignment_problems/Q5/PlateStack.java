import java.util.*;

public class PlateStack {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    static Node top = null;
    static int size = 0;

    static void push(String plate) {
        Node node = new Node(plate);
        node.next = top;
        top = node;
        size++;

        System.out.println("push " + plate + " -> top " + top.data + ", size " + size);
    }

    static void pop() {
        if (isEmpty()) {
            System.out.println("pop -> stack is empty");
            return;
        }

        String plate = top.data;
        top = top.next;
        size--;

        System.out.println("pop -> " + plate + ", size " + size);
    }

    static void peek() {
        if (isEmpty()) {
            System.out.println("peek -> stack is empty");
        } else {
            System.out.println("peek -> " + top.data);
        }
    }

    static boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String command = sc.next();

            switch (command) {
                case "push":
                    push(sc.next());
                    break;

                case "pop":
                    pop();
                    break;

                case "peek":
                    peek();
                    break;

                case "isEmpty":
                    System.out.println("isEmpty -> " + isEmpty());
                    break;
            }
        }
    }
}