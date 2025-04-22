// TestTransaction.java - Demonstrates success and failure scenarios
public class TestTransaction {
    public static void main(String[] args) {
        BankService bankService = new BankServiceImpl();

        // Successful transfer
        bankService.transferMoney(1, 2, 100.0);

        // Failed transfer (insufficient funds)
        bankService.transferMoney(1, 2, 100000.0);
    }
}
