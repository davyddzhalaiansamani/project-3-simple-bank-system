import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankAccount extends Account {
    Scanner scanner = new Scanner (System.in); 
    private double balance; 
    private String password; 
    private List <Transaction> transactionHistory = new ArrayList(); 
    
    public BankAccount(String name, String password) { 
        super(name); 
        this.setBalance (0.0) ;
        this.setPassword (password); 
    }   

    public void setBalance(double amount) {
        this.balance = amount;
    }

    public double getBalance () {
        return this.balance; 
    }

    public void setPassword (String pass) {
        this.password = pass; 
    }

    public String getPassword () {
        return this.password; 
    }

    public boolean checkBalance (double amount) {
        if (this.getBalance() >= amount)return true; 
        return false; 
    }

    public void addTransaction (Transaction t) {
        this.transactionHistory.add(t); 
    }
    //deposit
    public void deposit(double amount) {
        System.out.println ("Please Input your password : "); 
        String pass = scanner.nextLine(); 
        if (this.getPassword().equals (pass)) {
            Transaction transaction = new Transaction (1, amount, this); 
            this.addTransaction(transaction);
        } else {
            System.out.println ("Incorrect Password!");   
        }
    }

    //withdraw
    public void withdraw(double amount) {
        System.out.println ("Please Input your password : "); 
        String pass = scanner.nextLine(); 
        if (this.getPassword().equals (pass)) {
            if (checkBalance(amount)) {
                Transaction transaction = new Transaction (2, amount, this); 
                this.addTransaction(transaction);
            } else {
                System.out.println("not enough balance for transaction!");
            }
            //create new transaction of withdraw type
        } else {
            System.out.println ("Incorrect Password!");   
        }
    }

    //check balance
    public void checkBalance () {
        System.out.println ("Please Input your password : "); 
        String pass = scanner.nextLine(); 
        if (this.getPassword().equals(pass)) {
            System.out.println ("current balance : " + this.getBalance()); 
        } else {
            System.out.println ("Incorrect Password");
        }
    }

    //get transaction history
    public void transactionHistory () {
        System.out.println ("Please Input your password : "); 
        String pass = scanner.nextLine(); 
        if (this.getPassword().equals(pass)) {
            System.out.println("current transaction history : "); 
            for (Transaction i : transactionHistory) {
                i.printInformation(); 
            }
        } else {
            System.out.println ("Incorrect Password");
        }
    }
}
