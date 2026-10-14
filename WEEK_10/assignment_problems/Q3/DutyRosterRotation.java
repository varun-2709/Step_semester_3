import java.util.Scanner;

public class DutyRosterRotation {
    static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        String[] result = new String[n];
        k %= n;

        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = names[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }

        int k = sc.nextInt();
        String[] result = rotateRoster(names, k);

        System.out.print("[");
        for (int i = 0; i < n; i++) {
            System.out.print(result[i]);
            if (i < n - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}