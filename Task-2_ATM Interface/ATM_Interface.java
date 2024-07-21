import java.util.*;
class ATM{
    int acc_no = 12345;
    int pin = 123;
    double balance = 2000;
    int transaction = 0;
    String transactionHistory = "";
    Scanner sc = new Scanner(System.in);
    void check_balance(){
        System.out.println("Account Balance : " + balance);
    }
    void withdraw(){
        try{
            System.out.print("Enter the amount to withdraw : ");
            double cash = sc.nextDouble();
        if(cash<=balance){
            balance -= cash;
            transaction++;
            System.out.println("Cash Withdraw Successfully");
            String str = cash + " Cash Withdraw \n";
            transactionHistory = transactionHistory.concat(str);
            check_balance();
        }
        else{
            System.out.println("Insufficient Balance in Account");
            check_balance();
        }}
        catch (Exception e){
            System.out.println(e);
        }
    }
    void deposit(){
        try{
            System.out.print("Enter the amount to deposit : ");
            double cash = sc.nextDouble();
            if(cash>0){
                balance += cash;
                transaction++;
                System.out.println("Cash Deposited Successfully ");
                String str = cash + " Cash Deposited \n";
                transactionHistory = transactionHistory.concat(str);
                check_balance();
            }
            else{
                System.out.println("Invalid Amount ");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    void transfer(){
        try{
        System.out.print("Enter the name of account holder to transfer : ");
        String name = sc.next();
        System.out.print("Enter the amount to transfer : ");
        double cash = sc.nextDouble();
        if(cash<=balance){
            balance -= cash;
            transaction++;
            System.out.println("RS" + cash + " has been successfully transfered to " + name + "\n");
            check_balance();
            String str = cash + " Cash Transfered to " + name ;
            transactionHistory = transactionHistory.concat(str);
        }
        else{
            System.out.println("Insufficient balance to transfer ");
        }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    void transHistory(){
        if(transaction==0){
            System.out.println("No Transactions Occured ");
        }
        else{
            System.out.println("Total no of transactions : " + transaction);
            System.out.println( transactionHistory);
        }
    }
    boolean login(){
        System.out.print("Enter the account number : ");
        int no = sc.nextInt();
        if(acc_no==no){
        System.out.print("Enter the pin : ");
        int p = sc.nextInt();
        if(pin==p){
            System.out.println("Login Successful ");
            return true;
        }
        else{
            System.out.println("Invalid Pin ");
        }
        }
        else{
            System.out.println("Invalid Account Number ");
        }
        return false;
    }

}
public class ATM_Interface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            ATM a = new ATM();
            System.out.println("-----------------------------Welcome to the ATM----------------------------------");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            if(choice==1){
                if(a.login()){
                    while(true){
                        System.out.println("---------------------------------------Welcome USER----------------------------------");
                        System.out.println("1. Check Balance");
                        System.out.println("2. Withdraw ");
                        System.out.println("3. Deposit ");
                        System.out.println("4. Transfer ");
                        System.out.println("5. Transaction History ");
                        System.out.println("6. Exit");
                        System.out.println();
                        System.out.print("Enter Your choice : ");
                        int c = sc.nextInt();
                        if(c==1){
                            a.check_balance();
                        }
                        else if(c==2){
                            a.withdraw();
                        }
                        else if(c==3){
                            a.deposit();
                        }
                        else if(c==4){
                            a.transfer();
                        }
                        else if(c==5){
                            a.transHistory();
                        }
                        else if(c==6){
                            break;
                        }
                        else{
                            System.out.println("Invalid Input");
                        }
                    }

                }
            }
            else if(choice==2){
                break;
            }
            else{
                System.out.println("Invalid Input");
            }
        }
        System.out.println("---------------------------Thank You Visit Again----------------------------------------");
    }
}
