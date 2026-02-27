package main.java.com.example.repository;

import main.java.com.example.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BankRepository extends MongoRepository<User, String> {
}
