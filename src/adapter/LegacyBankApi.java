package adapter;

public class LegacyBankApi {
    public int charge(String accountId, double amountInEuros) {
        if (amountInEuros <= 0) {
            return 1;
        }
        System.out.println("  LegacyBankApi: списание " + String.format("%.2f", amountInEuros)
                + " EUR со счёта " + accountId);
        return 0;
    }
}
