package adapter;

import java.util.Map;

public class LegacyBankApiAdapter implements PaymentProcessor {
    private static final Map<String, Double> RATES_TO_EUR = Map.of(
            "EUR", 1.0,
            "USD", 0.92,
            "RUB", 0.0095
    );

    private final LegacyBankApi legacyApi;

    public LegacyBankApiAdapter(LegacyBankApi legacyApi) {
        this.legacyApi = legacyApi;
    }

    @Override
    public boolean pay(String accountId, int amountCents, String currency) {
        Double rate = RATES_TO_EUR.get(currency);
        if (rate == null) {
            System.out.println("  [Adapter] Неподдерживаемая валюта: " + currency);
            return false;
        }
        double amountInEuros = Math.round(amountCents * rate) / 100.0;
        return legacyApi.charge(accountId, amountInEuros) == 0;
    }
}
