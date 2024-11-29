public class SavingsAccount extends BankAccount{
    private double interestRate; 
    public SavingsAccount (String name, String password, double InterestRate) {
        super(name, password); 
        this.setInterestRate(InterestRate); 
    }

    private void setInterestRate(double rate) {
        this.interestRate = rate; 
    }

    public double getInterestRate () {
        return this.interestRate; 
    }

    public void addInterest (String pass) {
        double interest = getBalance() * this.getInterestRate() / 100; 
        deposit (interest,pass); 
        System.out.println ("An Interest of " + interest + " has been added to the balance."); 
    }

    @Override
    public void displayInformation () {
        System.out.println ("The Name of Account Holder : " + this.getaccountHolder()) ;
        System.out.println ("The Account number : " + this.getaccountNumber()); 
        System.out.println ("Account Type : Saving Account"); 
        System.out.println ("Current Balance : " + this.getBalance()); 
        System.out.println ("Interest Rate : " + this.getInterestRate()); 
    }
}
