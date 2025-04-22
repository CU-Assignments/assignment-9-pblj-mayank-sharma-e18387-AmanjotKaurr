// BankServiceImpl.java - Implements transfer logic with transaction management
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class BankServiceImpl implements BankService {

    @Override
    public void transferMoney(int fromAccountId, int toAccountId, double amount) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            Account from = session.get(Account.class, fromAccountId);
            Account to = session.get(Account.class, toAccountId);

            if (from.getBalance() < amount) {
                throw new RuntimeException("Insufficient funds!");
            }

            from.setBalance(from.getBalance() - amount);
            to.setBalance(to.getBalance() + amount);

            session.update(from);
            session.update(to);

            Transaction txn = new Transaction();
            txn.setFromAccount(fromAccountId);
            txn.setToAccount(toAccountId);
            txn.setAmount(amount);
            txn.setDate(new Date());

            session.save(txn);
            tx.commit();

            System.out.println("Transaction successful!");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.out.println("Transaction failed: " + e.getMessage());
        }
    }
}
