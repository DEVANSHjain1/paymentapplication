package main.java.com.example.temporal;

public class BankActivityImpl implements BankActivity {
    @Override
    public void userRegister() {
        System.out.println("***** User has been registered");
    }
    @Override
    public void balanceCredited() {
        System.out.println("amount credited");
    }

    @Override
    public void balanceDebited() {
        System.out.println("amount debited");
    }

    @Override
    public void userDeletion() {
        System.out.println("user deleted");
    }
}
