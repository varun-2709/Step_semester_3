public class MessWallet {
    private double balance;

    public MessWallet(double initialBalance) {
        if (initialBalance >= 0) {
            balance = initialBalance;
        } else {
            balance = 0;
        }
    }

    public void topUp(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void deduct(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        MessWallet wallet = new MessWallet(500);

        wallet.topUp(200);
        wallet.deduct(150);

        System.out.println("Balance: " + wallet.getBalance());
    }
}