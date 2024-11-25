import java.util.Scanner;

public class banksystem {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to my simple bank system"); 
        System.out.println("to create a bank account please input your name : "); 
        String name = scanner.nextLine();
        System.out.println("please choose a password : "); 
        String pass = scanner.nextLine(); 
        
        BankAccount BA = new BankAccount(name, pass);
        
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
        
        scanner.close(); 
    }
}
