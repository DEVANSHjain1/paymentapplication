package main.java.com.example.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

public class kafkaConfig {
    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Bean
    public NewTopic bankTopic(){
        return TopicBuilder.name(topicName)
                .build();
    }
}
