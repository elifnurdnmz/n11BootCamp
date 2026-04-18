package homework1.app.payment.enums;

public enum PaymentType {
    APPLE_PAY("Apple Pay"),
    CREDIT_CARD("Kredi Kartı"),
    DEBIT_CARD("Banka Kartı"),
    PAYPAL("PayPal");

    private final String s;

    PaymentType(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s;
    }
}
