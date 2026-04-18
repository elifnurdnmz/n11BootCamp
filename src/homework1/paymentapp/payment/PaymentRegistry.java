package homework1.paymentapp.payment;

import homework1.paymentapp.payment.enums.PaymentType;

import java.util.HashMap;
import java.util.Map;

public class PaymentRegistry {
    private final Map<PaymentType, PaymentMethod> payments = new HashMap<>();

    public PaymentRegistry() {
        payments.put(PaymentType.APPLE_PAY, new ApplePay());
        payments.put(PaymentType.CREDIT_CARD, new CreditCard());
        payments.put(PaymentType.DEBIT_CARD, new DebitCard());
        payments.put(PaymentType.PAYPAL, new PayPal());
    }

    public PaymentMethod get(PaymentType type) {
        return payments.get(type);
    }
}
