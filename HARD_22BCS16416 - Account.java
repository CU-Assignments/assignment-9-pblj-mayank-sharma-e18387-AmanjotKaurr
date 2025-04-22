// Account.java - Entity representing a bank account
import javax.persistence.*;

@Entity
public class Account {

    @Id
    private int id;
    private String holderName;
    private double balance;

    // Getters and setters
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getHolderName() { return holderName; }

    public void setHolderName(String holderName) { this.holderName = holderName; }

    public double getBalance() { return balance; }

    public void setBalance(double balance) { this.balance = balance; }
}
