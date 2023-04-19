import java.util.Scanner;

public class BankAccount {
    // instance variables
    private int accountNumber;
    private String accountHolderName;
    private float accountBalance;
    private String transactionHistory;

    // constructor to initialize the instance variables
    public BankAccount(int accountNumber, String accountHolderName, float accountBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountBalance = accountBalance;
        this.transactionHistory = "Account initialized with balance " + accountBalance;
    }

    // method to deposit money
    public void deposit(float amount) {
        accountBalance += amount;
        transactionHistory += "\nDeposited " + amount + ", new balance " + accountBalance;
        System.out.println("Deposit successful!");
    }

    // method to withdraw money
    public void withdraw(float amount) {
        if (amount <= accountBalance) {
            accountBalance -= amount;
            transactionHistory += "\nWithdrawn " + amount + ", new balance " + accountBalance;
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    // method to print transaction history
    public void printTransactionHistory() {
        System.out.println("Transaction history:\n" + transactionHistory);
    }

    // method to print account summary
    public void printAccountSummary() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Account Balance: " + accountBalance);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your full name:");
        String accountHolderName = sc.nextLine();
        System.out.println("Enter your account number:");
        int accountNumber = sc.nextInt();
        System.out.println("Enter your account balance:");
        float accountBalance = sc.nextFloat();
        BankAccount account = new BankAccount(accountNumber, accountHolderName, accountBalance);
        int choice;
        boolean exit = false;
        do {
            System.out.println("Enter a choice :");
            System.out.println("1.To Deposit ");
            System.out.println("2.To Withdraw ");
            System.out.println("3.To print the Transactions ");
            System.out.println("4.To print the Summary ");
            System.out.println("5.To Exist ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    float depositAmount = sc.nextFloat();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    float withdrawAmount = sc.nextFloat();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.printTransactionHistory();
                    break;
                case 4:
                    account.printAccountSummary();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (!exit);
    }
}




