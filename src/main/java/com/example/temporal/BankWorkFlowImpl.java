package main.java.com.example.temporal;

import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;
import main.java.com.example.temporal.BankActivity;
import main.java.com.example.temporal.BankActivityImpl;
import io.temporal.common.RetryOptions;

import java.time.Duration;


public class BankWorkFlowImpl implements BankWorkFlow{

    private final RetryOptions retryoptions = RetryOptions.newBuilder().setInitialInterval(Duration.ofSeconds(1))
            .setMaximumInterval(Duration.ofSeconds(100)).setBackoffCoefficient(2).setMaximumAttempts(50000).build();
    private final ActivityOptions options = ActivityOptions.newBuilder().setStartToCloseTimeout(Duration.ofSeconds(30))
            .setRetryOptions(retryoptions).build();

    private final BankActivity activity = Workflow.newActivityStub(BankActivity.class, options);
    public boolean isOrderConfirmed = false;

    public boolean isOrderPickedUp = false;

    public boolean isOrderDelivered = false;

    @Override
    public void userRegisterWorkflow() {

        activity.userRegister();

        System.out.println("User Registered");
        Workflow.await(() -> isOrderConfirmed);

        System.out.println("***** Please wait till we assign a delivery executive");
        Workflow.await(() -> isOrderPickedUp);

        Workflow.await(() -> isOrderDelivered);

    }
    @Override
    public void balanceCreditedWorkflow() {
        activity.balanceCredited();
        this.isOrderConfirmed = true;
    }

    @Override
    public void balanceDebitedWorkflow() {
        activity.balanceDebited();
        this.isOrderPickedUp = true;
    }

    @Override
    public void userDeletionWorkflow() {
        activity.userDeletion();
        this.isOrderDelivered = true;
    }

}
