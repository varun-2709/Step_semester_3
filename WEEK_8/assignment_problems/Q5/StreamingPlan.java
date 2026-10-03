import java.util.*;
import java.time.LocalDate;

abstract class Plan {
    LocalDate startDate;

    Plan(LocalDate startDate) {
        this.startDate = startDate;
    }

    abstract LocalDate renewalDate();
}

class Basic extends Plan {
    Basic(LocalDate startDate) {
        super(startDate);
    }

    LocalDate renewalDate() {
        return startDate.plusDays(30);
    }
}

class Standard extends Plan {
    Standard(LocalDate startDate) {
        super(startDate);
    }

    LocalDate renewalDate() {
        return startDate.plusDays(90);
    }
}

class Premium extends Plan {
    Premium(LocalDate startDate) {
        super(startDate);
    }

    LocalDate renewalDate() {
        return startDate.plusDays(365);
    }
}

public class StreamingPlan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            Plan plan;

            switch (type) {
                case "BASIC":
                    plan = new Basic(startDate);
                    break;
                case "STANDARD":
                    plan = new Standard(startDate);
                    break;
                default:
                    plan = new Premium(startDate);
            }

            System.out.printf("%s: %s%n", name, plan.renewalDate());
        }
    }
}