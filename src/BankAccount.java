import java.util.ArrayList;

public class BankAccount extends Account {
    private double balance; 
    private String password; 
    private ArrayList <Transaction> transactionHistory = new ArrayList<>(); 
    
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
    public void deposit(double amount,String pass) {
        if (this.getPassword().equals (pass)) {
            Transaction transaction = new Transaction (1, amount, this); 
            this.addTransaction(transaction);
        } else {
            System.out.println ("Incorrect Password!");   
        }
    }

    //withdraw
    public void withdraw(double amount,String pass) {
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
    public void checkBalance (String pass) {
        if (this.getPassword().equals(pass)) {
            System.out.println ("current balance : " + this.getBalance()); 
        } else {
            System.out.println ("Incorrect Password");
        }
    }

    //get transaction history
    public void transactionHistory (String pass) {
        if (this.getPassword().equals(pass)) {
            System.out.println("current transaction history : "); 
            for (Transaction i : transactionHistory) {
                i.printInformation(); 
            }
        } else {
            System.out.println ("Incorrect Password");
        }
    }

    @Override
    public void displayInformation () {
        System.out.println ("The Name of Account Holder : " + this.getaccountHolder()) ;
        System.out.println ("The Account number : " + this.getaccountNumber()); 
        System.out.println ("Current Balance : " + this.getBalance()); 
    }
}
