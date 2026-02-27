package main.java.com.example.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;

@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String userName;
    private BigDecimal balance;
    private String status;

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getStatus() {
        return status;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
