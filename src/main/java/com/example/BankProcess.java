package main.java.com.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.context.ConfigurableApplicationContext;

import main.java.com.example.temporal.BankActivity;
import main.java.com.example.temporal.BankWorkFlow;
import main.java.com.example.temporal.BankWorkFlowImpl;

import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;


@SpringBootApplication
@EnableKafka
public class BankProcess {
    public static void main(String[] args) {
        ConfigurableApplicationContext appContext = SpringApplication.run(BankProcess.class, args);
        WorkerFactory factory = appContext.getBean(WorkerFactory.class);
        BankActivity userRegisterActivity = appContext.getBean(BankActivity.class);
        Worker worker = factory.newWorker(BankWorkFlow.QUEUE_NAME);
        worker.registerWorkflowImplementationTypes(BankWorkFlowImpl.class);
        worker.registerActivitiesImplementations(userRegisterActivity);
        factory.start();
    }
}
