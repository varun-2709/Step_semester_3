import java.util.*;

abstract class Student {
    protected String name;

    Student(String name) {
        this.name = name;
    }

    abstract double tuitionFee();

    double totalFee() {
        return tuitionFee();
    }
}

interface BusUser {
    double transportFee();
}

class DayScholar extends Student implements BusUser {
    DayScholar(String name) {
        super(name);
    }

    double tuitionFee() {
        return 40000;
    }

    public double transportFee() {
        return 12000;
    }

    double totalFee() {
        return tuitionFee() + transportFee();
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double tuitionFee() {
        return 40000;
    }

    double totalFee() {
        return tuitionFee() + 60000;
    }
}

class Scholar extends Student implements BusUser {
    Scholar(String name) {
        super(name);
    }

    double tuitionFee() {
        return 20000;
    }

    public double transportFee() {
        return 12000;
    }

    double totalFee() {
        return tuitionFee() + transportFee();
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Student student;

            if (type.equals("DAY_SCHOLAR"))
                student = new DayScholar(name);
            else if (type.equals("HOSTELLER"))
                student = new Hosteller(name);
            else
                student = new Scholar(name);

            double fee = student.totalFee();
            total += fee;

            System.out.printf("%s: %.2f%n", name, fee);
        }

        System.out.printf("Total Collected: %.2f%n", total);
    }
}