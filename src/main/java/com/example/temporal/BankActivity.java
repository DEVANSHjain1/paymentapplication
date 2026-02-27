package main.java.com.example.temporal;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface BankActivity {
    @ActivityMethod
    void userRegister();

    @ActivityMethod
    void balanceCredited();

    @ActivityMethod
    void balanceDebited();

    @ActivityMethod
    void userDeletion();
}
