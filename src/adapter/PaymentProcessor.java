package adapter;

public interface PaymentProcessor {
    boolean pay(String accountId, int amountCents, String currency);
}
