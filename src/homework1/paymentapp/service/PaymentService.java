package homework1.paymentapp.service;

import homework1.paymentapp.payment.PaymentMethod;
import homework1.paymentapp.payment.PaymentRegistry;
import homework1.paymentapp.payment.enums.Currency;
import homework1.paymentapp.payment.enums.PaymentType;

public class PaymentService {
    private final PaymentRegistry registry;

    public PaymentService(PaymentRegistry registry) {
        this.registry = registry;
    }

    public String payAmount(PaymentType type, double amount, Currency currency) {
        PaymentMethod method = registry.get(type);
        if (method == null) {
            return "Geçersiz ödeme yöntemi!";
        }
        return method.pay(amount, currency);
    }
}
