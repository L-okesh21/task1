import java.util.Scanner;

class Account {
    int accountNumber;
    String accountHolderName, email, phoneNumber;
    double balance;

    Account(int accNo, String name, double bal, String email, String phone) {
        this.accountNumber = accNo;
        this.accountHolderName = name;
        this.balance = bal;
        this.email = email;
        this.phoneNumber = phone;
    }

    void deposit(double amount) {
        if (amount > 0) balance += amount;
        else System.out.println("Invalid deposit amount!");
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) balance -= amount;
        else System.out.println("Invalid or insufficient balance!");
    }

    void displayAccountDetails() {
        System.out.println("Acc No: " + accountNumber + ", Name: " + accountHolderName +
                ", Balance: " + balance + ", Email: " + email + ", Phone: " + phoneNumber);
    }

    void updateContactDetails(String email, String phone) {
        this.email = email;
        this.phoneNumber = phone;
    }
}

public class banking_method {
    static Account[] accounts = new Account[100];
    static int count = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1.Create 2.Deposit 3.Withdraw 4.View 5.Update 6.Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> createAccount();
                case 2 -> performDeposit();
                case 3 -> performWithdrawal();
                case 4 -> showAccountDetails();
                case 5 -> updateContact();
                case 6 -> { System.out.println("Bye!"); return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void createAccount() {
        System.out.print("Name: "); sc.nextLine(); String name = sc.nextLine();
        System.out.print("Initial deposit: "); double bal = sc.nextDouble();
        System.out.print("Email: "); sc.nextLine(); String email = sc.nextLine();
        System.out.print("Phone: "); String phone = sc.nextLine();
        accounts[count] = new Account(1000 + count, name, bal, email, phone);
        System.out.println("Account created! No: " + accounts[count].accountNumber);
        count++;
    }

    static Account findAccount(int accNo) {
        for (int i = 0; i < count; i++)
            if (accounts[i].accountNumber == accNo) return accounts[i];
        return null;
    }

    static void performDeposit() {
        System.out.print("Acc No: "); int accNo = sc.nextInt();
        Account acc = findAccount(accNo);
        if (acc != null) { System.out.print("Amount: "); acc.deposit(sc.nextDouble()); }
        else System.out.println("Account not found!");
    }

    static void performWithdrawal() {
        System.out.print("Acc No: "); int accNo = sc.nextInt();
        Account acc = findAccount(accNo);
        if (acc != null) { System.out.print("Amount: "); acc.withdraw(sc.nextDouble()); }
        else System.out.println("Account not found!");
    }

    static void showAccountDetails() {
        System.out.print("Acc No: "); int accNo = sc.nextInt();
        Account acc = findAccount(accNo);
        if (acc != null) acc.displayAccountDetails();
        else System.out.println("Account not found!");
    }

    static void updateContact() {
        System.out.print("Acc No: "); int accNo = sc.nextInt(); sc.nextLine();
        Account acc = findAccount(accNo);
        if (acc != null) {
            System.out.print("New Email: "); String email = sc.nextLine();
            System.out.print("New Phone: "); String phone = sc.nextLine();
            acc.updateContactDetails(email, phone);
        } else System.out.println("Account not found!");
    }
}
