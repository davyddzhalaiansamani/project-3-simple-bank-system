public class Transaction {
    private String type; 
    private double amount; 

    public Transaction (int type, double amount, BankAccount account) {
        this.setType (type); 
        this.setAmount (amount); 
        this.operation(amount, account);
    }

    public void setAmount (double amount) {
        this.amount = amount; 
    }

    public void setType (int type) {
        if (type == 1) {
            this.type = "deposit"; 
        } else if( type == 2) {
            this.type = "withdrawl"; 
        } else {
            this.type = "invalid"; 
        }
    }

    public int getType () {
        if (this.type.equals("deposit"))return 1;
        if (this.type.equals("withdrawl"))return 2; 
        return 3;  
    }

    public void operation (double amount, BankAccount account) {
        if (this.getType() == 1 ) {
            amount += account.getBalance();
            account.setBalance(amount);
            
        } else if (this.getType() == 2) {
            amount = account.getBalance() - amount; 
            account.setBalance(amount); 
        } else {
            System.out.println ("erorr, invalid type for transaction"); 
        }
    }

    public void printInformation () {
        System.out.println (this.type + " with the amonut of " + this.amount); 
    }
}
