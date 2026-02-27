package main.java.com.example.temporal;

import io.temporal.workflow.SignalMethod;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface BankWorkFlow {
    public static final String QUEUE_NAME = "Users";

    @WorkflowMethod
    void userRegisterWorkflow();

    @SignalMethod
    void balanceCreditedWorkflow();

    @SignalMethod
    void balanceDebitedWorkflow();

    @SignalMethod
    void userDeletionWorkflow();
}
