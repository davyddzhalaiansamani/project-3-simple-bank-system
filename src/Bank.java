import java.util.ArrayList;

public class Bank {
    ArrayList<BankAccount> Accounts = new ArrayList<>(); 

    public Bank () {}; 

    public void createBankAccount (int type, String name, String Password, double a) {
        if (type == 1) {
            CreateSavingsAccount(name, Password, a);
        } else if (type == 2){
            CreateCheckingAccount(name, Password, a);
        } else {
            System.out.println ("invalid type for account."); 
        }
    }

    public void CreateSavingsAccount (String name, String Password, double interestRate) {
        BankAccount account = new SavingsAccount(name, Password, interestRate);
        Accounts.add(account); 
        System.out.println ("New Savings Account created for " + name + " with Account number : " + account.getaccountNumber()); 
    }
    
    public void CreateCheckingAccount (String name, String Password, double overdraftlimit) {
        BankAccount account = new SavingsAccount(name, Password, overdraftlimit);
        Accounts.add(account); 
        System.out.println ("New Checking Account created for " + name + " with Account number : " + account.getaccountNumber()); 
    }

    public void closeAccount (int accountnumber, String Password) {
        BankAccount account = getAccountByID(accountnumber);
        if (account.getPassword().equals(Password))  {
            if (account != null) {
                Accounts.remove (account); 
                System.out.println ("Account number " + accountnumber + " is removed."); 
            }
        } else {
            System.out.println ("Incorrect Password"); 
        }
    }

    public void displayAccountDetails (int accountnumber,String Password) {
        BankAccount account = getAccountByID(accountnumber);
        if (account.getPassword().equals(Password))  {
            account.displayInformation();
        } else {
            System.out.println ("Incorrect Password"); 
        }
    }

    public BankAccount getAccountByID(int accountnumber) {
        for (BankAccount account : Accounts) {
            if (account.getaccountNumber() == accountnumber) {
                return account;
            }
        }
        System.out.println ("account not found."); 
        return null;
    }
}
