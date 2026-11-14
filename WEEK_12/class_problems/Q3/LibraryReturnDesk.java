import java.util.*;

public class LibraryReturnDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] pile = new String[3];
        String[] line = new String[3];

        int top = -1;
        int front = 0, rear = -1, size = 0;

        for (int i = 0; i < n; i++) {
            String command = sc.next();

            switch (command) {
                case "RETURN": {
                    String book = sc.next();

                    if (top == 2) {
                        System.out.println(book + " rejected: pile is full");
                    } else {
                        pile[++top] = book;
                        System.out.println(book + " placed on pile");
                    }
                    break;
                }

                case "SHELVE": {
                    if (top == -1) {
                        System.out.println("pile is empty");
                    } else {
                        System.out.println("shelved " + pile[top--]);
                    }
                    break;
                }

                case "WAIT": {
                    String name = sc.next();

                    if (size == 3) {
                        System.out.println(name + " rejected: line is full");
                    } else {
                        rear = (rear + 1) % 3;
                        line[rear] = name;
                        size++;
                        System.out.println(name + " joined the line");
                    }
                    break;
                }

                case "SERVE": {
                    if (size == 0) {
                        System.out.println("no one waiting");
                    } else {
                        System.out.println("served " + line[front]);
                        front = (front + 1) % 3;
                        size--;
                    }
                    break;
                }
            }
        }
    }
}