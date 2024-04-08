import java.util.*;

class BankAccount {

    private int balance;

    public BankAccount(int firstAmount) {
        this.balance = firstAmount;
    }

    // total amount in account
    public int balance() {
        return balance;
    }

    // depositing amount to account
    public void deposite(int amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println(amount + " Rs. has been successfully deposited");
        } else {
            System.out.println("Insufficent amount added to account");
        }

    }

    // withdrawing amount from account
    public void withdraw(int amount) {
        if (amount <= balance) {
            balance = balance - amount;
            System.out.println(amount + " Rs. deducted from your account ");
        } else {
            System.out.println("Insufficient balance in account ");
        }
    }

}

class ATMInterface {
    private BankAccount account;

    public ATMInterface(BankAccount account) {
        this.account = account;
    }

    public void menu() {
        int ch;
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("\n\n             ---------ATM---------");
            System.out.println("--------------------------------------------------");
           
            System.out.println("            Select Your Transaction  ");
            System.out.println("               1. Deposit");
            System.out.println("               2. Withdrawal ");
            System.out.println("               3. Balance Inquiry");
            System.out.println("               4. Exit");
            System.out.println("--------------------------------------------------");

            System.out.print("Input (1-4) : ");
            ch = in.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("--------------------------------------------------");
                    System.out.print("Enter Deposite amount : ");
                    int depositeAmount = in.nextInt();
                    account.deposite(depositeAmount);
                    System.out.println("--------------------------------------------------");
                    break;
                case 2:
                    System.out.println("--------------------------------------------------");
                    System.out.print("Enter Amount to withdraw : ");
                    int withdrawAmount = in.nextInt();
                    account.withdraw(withdrawAmount);
                    System.out.println("--------------------------------------------------");
                    break;
                case 3:
                    System.out.println("--------------------------------------------------");
                    System.out.println("Loading Account Balance.....");
                    System.out.print("Available Balance : " + account.balance());
                    System.out.println("\n--------------------------------------------------");
                    break;

                case 4:
                    System.out.println("\n\n=========================================================");
                    System.out.println("You are sucessfully logout");
                    System.out.println("THANK YOU SO MUCH FOR USING THE SYSTEM !");
                    System.out.println("=========================================================");
                    System.exit(0);

                default:
                    System.out.println("--------------------------------------------------");
                    System.out.println("Option Not Available ");
                    System.out.println("--------------------------------------------------");
            }

        }

    }

}

public class Task3 {
    public static void main(String[] args) {
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("%%   ~~~~~~~~~~~~~~ATM                                %%");
        System.out.println("%%                       INTERFACE~~~~~~~~~~~~~~~     %%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("Account Processing......");
        Scanner sc = new Scanner(System.in);
        int pin = 2002;
        String Uname = "Rachana";
        System.out.print("Please Enter Your 4-Digit Pin : ");
        int pin2 = sc.nextInt();
        for (int i = 1; i <= 3; i++) {
            if (pin == pin2) {
                System.out.println("=========================================================");
                System.out.println("Welcome " + Uname + " to your account ");
                System.out.println("=========================================================");
                BankAccount account = new BankAccount(0);
                ATMInterface atm = new ATMInterface(account);
                atm.menu();
            } else {
                System.out.println("Wrong Password ! (" + (i + 1) + "/3)");
                System.out.print("Please Enter Pin :");
                pin2 = sc.nextInt();
            }
            if (i == 3) {
                System.out.println("Wrong Password ! Your account is temporalily blocked....!");

            }
        }
    }
}