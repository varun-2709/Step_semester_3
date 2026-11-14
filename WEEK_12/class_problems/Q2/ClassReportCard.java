import java.util.*;

class Student {
    private String name;
    private int a, b, c;

    Student(String name) {
        this.name = name;
    }

    boolean setMarks(int a, int b, int c) {
        if (a < 0 || a > 100 || b < 0 || b > 100 || c < 0 || c > 100) {
            return false;
        }

        this.a = a;
        this.b = b;
        this.c = c;
        return true;
    }

    int getTotal() {
        return a + b + c;
    }

    double getAverage() {
        return getTotal() / 3.0;
    }

    char getGrade() {
        double avg = getAverage();

        if (avg >= 80) return 'A';
        if (avg >= 70) return 'B';
        if (avg >= 60) return 'C';
        if (avg >= 40) return 'D';
        return 'F';
    }

    @Override
    public String toString() {
        return String.format(Locale.US,
                "%s total=%d avg=%.2f grade=%c",
                name, getTotal(), getAverage(), getGrade());
    }
}

public class ClassReportCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] students = new Student[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            Student s = new Student(name);

            if (s.setMarks(a, b, c)) {
                students[count++] = s;
            } else {
                System.out.println(name + " skipped: marks must be 0 to 100");
            }
        }

        int passes = 0;

        for (int i = 0; i < count - 1; i++) {
            boolean swapped = false;
            passes++;

            for (int j = 0; j < count - i - 1; j++) {
                if (students[j].getTotal() < students[j + 1].getTotal()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + students[i]);
        }

        System.out.println("Sorted in " + passes + " passes");
    }
}