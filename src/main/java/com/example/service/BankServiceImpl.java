package main.java.com.example.service;

import main.java.com.example.model.User;
import main.java.com.example.repository.BankRepository;
import main.java.com.example.temporal.BankWorkFlow;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private WorkflowClient workflowClient;
    @Autowired
    WorkflowServiceStubs workflowServiceStubs;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @Override
    public User registerUser(User user){
        User savedUser = bankRepository.save(user);
        BankWorkFlow workflow = createWorkFlowConnection(user.getId());
        WorkflowClient.start(workflow::userRegisterWorkflow);
        return savedUser;
    }

    public BankWorkFlow createWorkFlowConnection(String id) {
        WorkflowOptions options = WorkflowOptions.newBuilder().setTaskQueue(BankWorkFlow.QUEUE_NAME)
                .setWorkflowId("User_" + id).build();
        return workflowClient.newWorkflowStub(BankWorkFlow.class, options);
    }
}
