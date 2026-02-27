package main.java.com.example.config;

import main.java.com.example.temporal.BankActivity;
import main.java.com.example.temporal.BankActivityImpl;
import main.java.com.example.temporal.BankWorkFlow;
import main.java.com.example.temporal.BankWorkFlowImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import io.temporal.client.WorkflowOptions;

@Component
@Configuration
public class TemporalConfig {
    @Value("$temporal.service.address")
    private String temporalServiceAddress;

    private String temporalNamespace = "Users";

    @Bean
    public WorkflowServiceStubs workflowServiceStubs() {
        return WorkflowServiceStubs.newLocalServiceStubs();
    }

    @Bean
    public WorkflowClient workflowClient(WorkflowServiceStubs workflowServiceStubs) {
        return WorkflowClient.newInstance(workflowServiceStubs);
    }

    @Bean
    public WorkerFactory workerFactory(WorkflowClient workflowClient) {
        return WorkerFactory.newInstance(workflowClient);
    }

    @Bean
    public BankActivityImpl userRegister() {
        return new BankActivityImpl();
    }

}
