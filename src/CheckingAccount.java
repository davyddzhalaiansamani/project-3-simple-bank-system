public class CheckingAccount extends BankAccount {
    private double overdraftlimit; 

    public CheckingAccount (String name, String password, double overdraftlimit) {
        super(name, password) ;
        this.setOverdraftLimit(overdraftlimit); 
    }

    public void setOverdraftLimit (double amount) {
        this.overdraftlimit = amount; 
    }

    public double getOverdraftLimit () {
        return this.overdraftlimit; 
    }

    @Override
    public void withdraw(double amount, String pass) {
        if (this.getPassword().equals (pass)) {
            if (amount > 0 && this.getBalance()-amount >= -overdraftlimit) {
                double newBalance = this.getBalance()-amount;
                this.setBalance(newBalance);
                Transaction transaction = new Transaction (2, amount, this); 
                this.addTransaction(transaction);
            } else {
                System.out.println("Withdrawl exceeds overdraft Limit!"); 
            }
        } else {
            System.out.println ("Incorrect Password!");   
        }
    }

    @Override
    public void displayInformation () {
        System.out.println ("The Name of Account Holder : " + this.getaccountHolder()) ;
        System.out.println ("The Account number : " + this.getaccountNumber()); 
        System.out.println ("Account Type : Checking Account"); 
        System.out.println ("Current Balance : " + this.getBalance()); 
        System.out.println ("Overdraft Limit : " + this.getOverdraftLimit()); 
    }
}
