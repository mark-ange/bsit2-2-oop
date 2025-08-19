public class BankAccount {
    static String bankName = "Liceo Bank";
    static int totalAccounts = 0;
    static double interestRate = 0.03;

    private String accountNumber;
    private String accountHolderName;
    private double balance;

    private static String generateAccountNumber() {
        totalAccounts++;
        return String.format("ACC%03d", totalAccounts);
    }

    public BankAccount(String accountHolderName, double initialBalance) {
        this.accountNumber = generateAccountNumber();
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;

        System.out.println("Account Created: " + accountNumber + " for "
                + accountHolderName + " with initial balance: $"
                + String.format("%.1f", initialBalance));
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(accountHolderName + " deposited $"
                    + String.format("%.1f", amount)
                    + ". New balance: $" + String.format("%.1f", balance));
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(accountHolderName + " withdrew $"
                    + String.format("%.1f", amount)
                    + ". New balance: $" + String.format("%.1f", balance));
        }
    }

    public double calculateInterest() {
        return balance * interestRate;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }
}
