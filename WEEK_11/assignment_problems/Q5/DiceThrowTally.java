import java.util.*;

public class DiceThrowTally {
    static int[] diceSort(int[] rolls) {
        int[] count = new int[7];

        for (int roll : rolls) {
            count[roll]++;
        }

        System.out.print("Counts: ");
        for (int i = 1; i <= 6; i++) {
            System.out.print(i + ":" + count[i]);
            if (i < 6) {
                System.out.print(" ");
            }
        }
        System.out.println();

        int[] result = new int[rolls.length];
        int index = 0;

        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j < count[i]; j++) {
                result[index++] = i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] rolls = new int[n];

        for (int i = 0; i < n; i++) {
            rolls[i] = sc.nextInt();
        }

        System.out.println("Sorted: " + Arrays.toString(diceSort(rolls)));
    }
}