import java.util.Scanner;

public class banksystem {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            Bank myBank = new Bank();
            while (true) {
                System.out.println("Welcome to my simple bank system"); 
                System.out.println ("Type 1 to create a new account."); 
                System.out.println ("Type 2 if you already have an account."); 
                System.out.println ("Type 3 if you want to exit the program."); 

                int op = scanner.nextInt(); 
                scanner.nextLine(); 
                
                if (op == 1) {
                    System.out.println ("Type 1 for a Savings account and 2 for a Checking account.");
                    int accountType = scanner.nextInt(); 
                    scanner.nextLine();
                    System.out.println("please input your name : "); 
                    String name = scanner.nextLine();
                    System.out.println("please choose a password : "); 
                    String pass = scanner.nextLine();
                    double a = 0; 
                    if (accountType == 1) {
                        System.out.println ("please enter your desired interest Rate.");
                        a = scanner.nextDouble(); 
                        scanner.nextLine(); 
                    }
                    if (accountType == 2) {
                        System.out.println ("please enter your desired overdraftlimit.");
                        a = scanner.nextDouble(); 
                        scanner.nextLine(); 
                    }
                    myBank.createBankAccount(accountType, name, pass, a);
                } else if (op == 2) {
                    System.out.println ("please enter your account number :"); 
                    int accountnumber = scanner.nextInt(); 
                    scanner.nextLine(); 
                    System.out.println ("please enter your password :"); 
                    String accountpass = scanner.nextLine();
                    BankAccount account = myBank.getAccountByID(accountnumber); 
                    while (true) {
                        System.out.println ("you can choose to do one of the following actions : "); 
                        System.out.println ("type 1 for deposit"); 
                        System.out.println ("type 2 for withdral"); 
                        System.out.println ("type 3 for checking the balance"); 
                        System.out.println ("type 4 for transaction hisotry");
                        System.out.println ("type 5 to get account information") ; 
                        System.out.println ("type 6 to exit"); 
            
                        int type = scanner.nextInt(); 
                        if (type == 1) {
                            System.out.println("please enter your desired amonut of deposit : "); 
                            double amount = scanner.nextDouble(); 
                            scanner.nextLine(); 
                            account.deposit(amount,accountpass);
                        } else if (type == 2) {
                            System.out.println("please enter your desired amonut of withdrawl : "); 
                            double amount = scanner.nextDouble(); 
                            scanner.nextLine(); 
                            account.withdraw(amount,accountpass);
                        } else if (type == 3) {
                            account.checkBalance(accountpass);
                        } else if (type == 4) {
                            account.transactionHistory(accountpass);
                        } else if (type == 5) {
                            myBank.displayAccountDetails(accountnumber,accountpass); 
                        } else if (type == 6) {
                            break; 
                        } else {
                            System.out.println ("invalid type for operation. "); 
                            break; 
                        }
                    }
                } else if (op == 3) {
                    break; 
                } else {
                    System.out.println ("unavailable action."); 
                }
            /*  
            
            while (true) {
                System.out.println ("you can choose to do one of the following actions : "); 
                System.out.println ("type 1 for deposit"); 
                System.out.println ("type 2 for withdral"); 
                System.out.println ("type 3 for checking the balance"); 
                System.out.println ("type 4 for transaction hisotry"); 
                System.out.println ("type 5 to exit"); 

                int type = scanner.nextInt(); 
                if (type == 1) {
                    System.out.println("please enter your desired amonut of deposit : "); 
                    double amount = scanner.nextDouble(); 
                    scanner.nextLine(); 
                    BA.deposit(amount);
                } else if (type == 2) {
                    System.out.println("please enter your desired amonut of withdrawl : "); 
                    double amount = scanner.nextDouble(); 
                    scanner.nextLine(); 
                    BA.withdraw(amount);
                } else if (type == 3) {
                    BA.checkBalance();
                } else if (type == 4) {
                    BA.transactionHistory();
                } else if (type == 5) {
                    break; 
                } else {
                    System.out.println ("invalid type for operation. "); 
                    break; 
                }
            }
            */
            }
        }
    }
}
