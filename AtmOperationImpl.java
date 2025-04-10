package ATMsystem;
import java.util.HashMap;
import java.util.Map;

public class AtmOperationImpl implements AtmoperationsInterf {
    ATM atm=new ATM();
    Map<Double,String> ministmt=new HashMap<>();
    @Override
    public void viewBalance() {
        System.out.println(" Available Balance of your ATM is: "+atm.getBalance());

    }

    @Override
    public void withdrawAmount(double withdrawAmount) {
        if(withdrawAmount%500==0){
            if(withdrawAmount<=atm.getBalance()){
                ministmt.put(withdrawAmount, "Amount withdrawn");
                System.out.println("collect the cash "+withdrawAmount);
                atm.setBalance(atm.getBalance()-withdrawAmount);
                viewBalance();
            }else{
                System.out.println("insufficient balance !!");
            }
        }
        else{
            System.out.println(" Please enter the amount in multiple of 500 !!");
        }

    }

    @Override
    public void depositAmount(double depositAmount) {
        ministmt.put(depositAmount, "Amount deposited");
        System.out.println(depositAmount+"Deposited Sucessfully !!");
        atm.setBalance(atm.getBalance()+depositAmount);
        viewBalance();

    }

    @Override
    public void viewMinistatement() {
        for(Map.Entry<Double,String> entry:ministmt.entrySet()){
            System.out.println(entry.getKey()+": "+entry.getValue());
        }

    }
}
