import java.util.Scanner;


 class Atminterface {

    private double balance;
    public Atminterface(double  intialBalance)
    {
        balance = intialBalance;
    }

    public double getBalance()
    {
        return balance;
    }
   public void deposit(double amount)
   {
    if(amount>0)
    {
        balance += amount;
        System.out.println("Money Deposited:"  +amount);
    }
    else
    {
        System.out.println("Invalid amount for deposit");
    }
   }

   public void withdraw(double amount)
   {
    if(amount > 0 &&amount <=balance)
    {
        balance -= amount;
        System.out.println("Money Withdraw:" + amount);
    }
    else
    { 
        System.out.println("Insufficient funds or Invalid amount for withdrawal");

    }
   }
    
}

class ATM
{
    private Atminterface account ;
    private Scanner scanner;

    public ATM(Atminterface account)
    {
        this.account = account;
        scanner= new Scanner(System.in);
    }
    public void showmenu()
    {
        System.out.println("**__________Welcome to ATM__________**");
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Cash");
        System.out.println("3. Withdraw Cash");
        System.out.println("4.Exit");
        System.out.println("Thank You for Visiting");
    }
    public void start()
    {
        int choice;
        do
        {
            showmenu();
            System.out.println("Enter Your choice:");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                     checkBalance();
                     break;
                case 2:
                     deposit();
                     break;
            
                case 3:
                     withdraw();
                     break;
            
                case 4:
                     System.out.println("Exiting ATM, Thank You !!");
                     break;
            
            
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
        while (choice !=4); 
        scanner.close();
    }

    private void checkBalance()
    {
        System.out.println("Current Balance:" + account.getBalance());
    }

    private void deposit()
    {
        System.out.println("Enter deposit account:");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    private void withdraw()
    {
        System.out.println("Enter withdrawal amount:");
        double amount =scanner.nextDouble();
        account.withdraw(amount);
    }
}
public class main{
public static void main(String[] args)
{
    Atminterface userAccount = new Atminterface(1000);
    ATM atm = new ATM(userAccount);
    atm.start();
}
}
