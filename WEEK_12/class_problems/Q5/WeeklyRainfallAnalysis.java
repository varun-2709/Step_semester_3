import java.util.*;

public class WeeklyRainfallAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] rainfall = new double[7];

        double total = 0;
        int wettest = 0;
        int dryDays = 0;

        for (int i = 0; i < 7; i++) {
            rainfall[i] = sc.nextDouble();
            total += rainfall[i];

            if (rainfall[i] == 0) {
                dryDays++;
            }

            if (rainfall[i] > rainfall[wettest]) {
                wettest = i;
            }
        }

        System.out.print("Rainfall (mm): ");

        for (double value : rainfall) {
            System.out.print(value + " ");
        }

        System.out.println();
        System.out.println("Total Rainfall: " + total + " mm");
        System.out.printf(Locale.US, "Average Rainfall: %.2f mm%n", total / 7);
        System.out.println("Wettest Day: Day " + (wettest + 1)
                + " (" + rainfall[wettest] + " mm)");
        System.out.println("Total Dry Days: " + dryDays);
    }
}