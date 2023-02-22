import java.util.ArrayList;
import java.util.Scanner;

public class lab4{
    private static int Acc_Number;
    private static String AccHolderName;
    private static float Account_Balance;
    static ArrayList<String> transactions = new ArrayList<>();

static void customer_details(){
    Scanner input = new Scanner(System.in);
    System.out.println("Enter your full name:");
    AccHolderName = input.nextLine();
    //input.nextLine();
    System.out.println("Enter your account number:");
    Acc_Number = input.nextInt();
    System.out.println("Enter your account Balance:");
    Account_Balance = input.nextInt();
    transactions.add("Account initialized with balance " + Account_Balance);
    System.out.println("Account created successfully!");
}

static void deposit(){
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter amount to deposit: ");
    float amount = sc.nextInt();
    Account_Balance += amount;
    transactions.add("Deposited " + amount + ", new balance " + Account_Balance);
    System.out.println("Deposit successful!");
}


static void withdraw(){
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the amount to withdraw: ");
    float amount = sc.nextInt();
    if (amount <= Account_Balance) {
        Account_Balance -= amount;
        transactions.add("Withdrawn " + amount + ", new balance " + Account_Balance);
        System.out.println("Withdrawal successful!");
    } else {
        System.out.println("Insufficient balance!");
    }
}


static void transactions(){
    for (String transaction : transactions) {
        System.out.println(transactions);
    }
}

static void summary(){
    System.out.println("Account Number: " + Acc_Number);
        System.out.println("Account Holder Name: " + AccHolderName);
        System.out.println("Account Balance: " + Account_Balance);
        System.out.println("Account Transactions :" + transactions);
    }

public static void main(String[]args){
    Scanner sc = new Scanner (System.in);
    int choice;
    boolean exit = false;

    customer_details();

    do{
        System.out.println("Enter a choice :");
        System.out.println("1.To Deposit ");
        System.out.println("2.To Withdraw ");
        System.out.println("3.To print the Transactions ");
        System.out.println("4.To print the Summary ");
        System.out.println("5.To Exist ");
    
    choice = sc.nextInt();
            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    transactions();
                    break;
                case 4:
                    summary();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }}
          while(!exit);
        }
    } 

    




