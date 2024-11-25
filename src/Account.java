public class Account {
    
    private String accountHolder;
    private int accountNumber; 
    int countAccounts = 0; 

    public Account (String name) {
        this.setaccountHolder (name); 
        countAccounts ++ ; 
        this.setaccountNumber (countAccounts); 
    }

    public void setaccountHolder (String name) {
        this.accountHolder = name; 
    }

    public String getaccountHolder () {
        return this.accountHolder; 
    }

    public int getaccountNumber () {
        return this.accountNumber; 
    }

    public void setaccountNumber (int number) {
        this.accountNumber = number; 
    }
    
    public void displayInformation () {
        System.out.println ("The Name of Account Holder : " + this.getaccountHolder()) ;
        System.out.println ("The Account number : " + this.getaccountNumber()); 
    }
}
