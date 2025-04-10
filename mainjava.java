package ATMsystem;
import java.util.Scanner;


public class mainjava {
    public static void main(String[] args) {
        AtmoperationsInterf op = new AtmOperationImpl();
        int atmnumber = 12345;
        int atmpin = 123;
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to ATM MACHINE");
        System.out.println("Enter Atm number :");
        int atmNumber = in.nextInt();
        System.out.println("Enter pin :");
        int pin = in.nextInt();
        if ((atmnumber == atmNumber) && (atmpin == pin)) {
            while(true) {
                System.out.println("1. View Available Balance\n2.Withdraw Amount\n3.Deposit Amount\n4.view MInistatement\n5.Exit:");
                System.out.println("Enter your choice:");
                int ch = in.nextInt();
                if (ch == 1) {
                    op.viewBalance();

                }else if(ch == 2) {
                    System.out.println("Enter Amount to Withdraw:");
                    double withdrawAmount = in.nextDouble();
                    op.withdrawAmount(withdrawAmount);

                }else if(ch == 3) {
                    System.out.println("Enter Amount to Deposit:");
                    double depositAmount=in.nextDouble();//5000
                    op.depositAmount(depositAmount);

                }else if(ch == 4) {
                    op.viewMinistatement();

                }else if(ch == 5) {
                    System.out.println("collect your ATM Card\n Thank you for using ATM MACHINE");
                    System.exit(0);
                }
                else
                {
                    System.out.println("Please enter correct choice:");
                }
            }
        } else {
            System.out.println("Incorrect Atm Number or Pin");
            System.exit(0);
        }

    }
}