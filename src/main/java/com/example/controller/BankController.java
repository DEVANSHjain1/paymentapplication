package main.java.com.example.controller;

import main.java.com.example.model.User;
import main.java.com.example.service.BankService;
import main.java.com.example.kafka.KafkaProducer;
import main.java.com.example.service.BankService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bank")
public class BankController {

    @Autowired
    private BankService bankService;
    private KafkaProducer kafkaProducer;

    public BankController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    /*@PostMapping("/register")
    public User registerUser(@RequestBody User user){
        return bankService.registerUser(user);
    }*/
    /*@PostMapping("/transfer")
    public User registerUser(@RequestBody User user){
        return bankService.registerUser(user);
    }*/

    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
        User user1 =  bankService.registerUser(user);
        String message = "Account has been created for user" + user1.getUserName() + " with opening balance of " + user1.getBalance();
        kafkaProducer.sendMessage(message);
        return user1;
    }

}
