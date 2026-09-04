import java.util.Scanner;

public class ATM_PIN_Length_Validator {

    static void validatePIN(String pin) {
        if (pin.length() == 4 || pin.length() == 6) {
            System.out.println("Valid PIN");
        } else {
            System.out.println("Invalid PIN");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String pin = sc.nextLine();

        validatePIN(pin);

        sc.close();
    }
}