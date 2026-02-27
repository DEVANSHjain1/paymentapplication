package main.java.com.example.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "registered", groupId = "bank-users")
    public void consume(String message){
        System.out.println("Message received -> " + message);
    }

}
