import java.util.*;

class Staff {
    String name;
    double baseSalary;

    Staff(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    double getBonus() {
        return 0;
    }
}

class Teacher extends Staff {
    Teacher(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    double getBonus() {
        return 5000;
    }
}

class LabAssistant extends Staff {
    LabAssistant(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    double getBonus() {
        return 2000;
    }
}

public class CampusStaffSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Staff[] staff = new Staff[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            if (type.equals("Teacher")) {
                staff[i] = new Teacher(name, salary);
            } else if (type.equals("LabAssistant")) {
                staff[i] = new LabAssistant(name, salary);
            } else {
                staff[i] = new Staff(name, salary);
            }
        }

        double grandTotal = 0;

        for (Staff s : staff) {
            double bonus = s.getBonus();
            double total = s.baseSalary + bonus;
            grandTotal += total;

            System.out.println(s.name + " (" + s.getClass().getSimpleName()
                    + "): base " + s.baseSalary + ", bonus " + bonus
                    + ", total " + total);
        }

        System.out.println("Grand Total Salary: " + grandTotal);
    }
}