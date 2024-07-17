import java.util.*;
public class Bank{
   static Scanner in=new Scanner(System.in);
    HashMap<Integer, Integer> Account_Details = new HashMap<>();
    HashMap<Integer, Double> Account_Balance = new HashMap<>();

    public void createAccount(){
        System.out.println("Enter your Name: ");
        String Name=in.next();

        Random rand=new Random();
        int Account_number=rand.nextInt(671000100,671000999);

        System.out.println("Set new Pin code: ");
        int pin=in.nextInt();

        System.out.println("Deposit amount to continue: ");
        double balance =in.nextDouble();
        if(Account_Details.containsValue(pin)) {
            System.out.println("Create an Unique Pin !!");
            return;
        }
        Account_Details.put(Account_number, pin);
        Account_Balance.put(Account_number, balance);
        System.out.println("ACCOUNT CREATED SUCCESSFULLY !!!!");
        System.out.printf("\n YOUR ACCOUNT INFORMATION IS SHOWN BELOW \n Name : "+Name+"\n Account number: "+Account_number+"\n Balance : "+balance);
        System.out.println(" ");
    }
    public void withdraw(){
        System.out.println("Enter your Account Number: ");
        int Account_number=in.nextInt();
        if(Account_Balance.containsKey(Account_number) && Account_Details.containsKey(Account_number)){
            System.out.println("Enter your PIN: ");
            int pin=in.nextInt();
            if(Account_Details.get(Account_number)==pin){
                System.out.println("Enter the amount to be debited");
                double balance=in.nextDouble();
                if(Account_Balance.get(Account_number)>=balance){
                   double newBal=Account_Balance.get(Account_number)-balance;
                    Account_Balance.replace(Account_number,newBal);
                    System.out.println("DEBITED RS."+balance+" SUCESSFULLY !!");
                    System.out.println(" ");
                }
                else{
                    System.out.println("INSUFFICIENT BALANCE !!");
                    System.out.println(" ");
                }
            }
            else{
                System.out.println("INVALID PIN!!!");
                System.out.println(" ");
            }
        }
        else{
            System.out.println("ACCOUNT NOT FOUND !!!");
            System.out.println(" ");
        }
    }

    public void deposit(){
        System.out.println("Enter your Account Number: ");
        int Account_number=in.nextInt();
        if(Account_Details.containsKey(Account_number)){
            System.out.println("Enter your PIN ");
            int pin=in.nextInt();
            if(Account_Details.get(Account_number)==pin){
                System.out.println("Enter the deposit amount");
                double balance=in.nextDouble();
                if(balance<0.00) {
                    System.out.println("Wrong format !!!");
                    System.out.println(" ");
                    return;
                }
                if(Account_Balance.containsKey(Account_number)){
                   double newBal=Account_Balance.get(Account_number)+balance;
                    Account_Balance.replace(Account_number,newBal);
                    System.out.println("DEPOSITED RS."+balance+"SUCESSFULLY !!");
                    System.out.println(" ");
                }
                
            }
            else{
                System.out.println("Check your PIN !!!");
                System.out.println(" ");
            }
            
        }
        else{
            System.out.println("ACCOUNT NOT FOUND !!!");
            System.out.println(" ");
        }
    }
    public void transfer(){
        System.out.println("Enter the Sender's Account Number: ");
        int sac=in.nextInt();
        System.out.println("Enter the Receiver's Account Number: ");
        int rac=in.nextInt();
        if(Account_Details.containsKey(sac) && Account_Balance.containsKey(rac)){
            System.out.println("Enter your PIN: ");
            int pin =in.nextInt();
            if(Account_Details.get(sac)==pin){
                System.out.println("Enter the Amount to be transferred- ");
                double balance=in.nextDouble();
                if(Account_Balance.get(sac)>=balance){
                    double newBal=Account_Balance.get(sac)-balance;
                    Account_Balance.replace(sac, newBal);
                    double newBalr=Account_Balance.get(rac)+balance;
                    Account_Balance.replace(rac, newBalr);
                    System.out.println("TRANSFERRED RS."+balance+"SUCESSFULLY");
                }
                else{
                    System.out.println("INSUFFICIENT AMOUNT ");
                    System.out.println(" ");
                }
            }
            else{
                System.out.println("WRONG PIN !!");
                System.out.println(" ");
            }
        }
        else{
            System.out.println("ACCOUNT NOT FOUND !!");
        }
    }

    public void display(){
        System.out.println("Enter Your Account Number- ");
        int Account_number=in.nextInt();
        if(Account_Details.containsKey(Account_number)){
            System.out.println("Enter 4-Digit Transaction Pin- ");
            int pin=in.nextInt();
            if (Account_Details.get(Account_number)==pin) {
                System.out.println("CURRENT MONEY = "+Account_Balance.get(Account_number)+". ");
                System.out.println(" ");
            }
            else{
                System.out.println("WRONG PIN!!");
                System.out.println(" ");
            }
        }
        else{
            System.out.println("ACCOUNT NOT FOUND!!!");
            System.out.println(" ");
        }

    }
    public static void main(String[] args) {
        Bank obj=new Bank();
        while(true){
            System.out.println("--------------WELCOME-------------------");
            System.out.println("SELECT 1 TO CREATE AN ACCOUNT");
            System.out.println("SELECT 2 TO DEPOSIT");
            System.out.println("SELECT 3 TO WITHDRAW");
            System.out.println("SELECT 4 TO TRANSFER MONEY TO ANOTHER ACCOUNT");
            System.out.println("SELECT 5 TO BALANCE");
            System.out.println("SELECT 6 TO EXIT");
            System.out.println(" ");
            System.out.println("Enter your Choice : ");
            int choice=in.nextInt();
            switch(choice){
                case 1:
                    obj.createAccount();
                    break;
                case 2:
                    obj.deposit();
                    break;
                case 3:
                    obj.withdraw();
                    break;
                case 4:
                    obj.transfer();
                    break;
                case 5:
                    obj.display();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please Enter a Valid Choice !!");
            }
        }
        
    }
}