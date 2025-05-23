// Transaction.java - Entity representing a money transfer transaction
import javax.persistence.*;
import java.util.Date;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int fromAccount;
    private int toAccount;
    private double amount;
    private Date date;

    // Getters and setters
    public int getId() { return id; }

    public int getFromAccount() { return fromAccount; }

    public void setFromAccount(int fromAccount) { this.fromAccount = fromAccount; }

    public int getToAccount() { return toAccount; }

    public void setToAccount(int toAccount) { this.toAccount = toAccount; }

    public double getAmount() { return amount; }

    public void setAmount(double amount) { this.amount = amount; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }
}
