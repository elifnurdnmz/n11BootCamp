package homework1.paymentapp.payment;

import homework1.paymentapp.payment.enums.Currency;

public interface PaymentMethod {
    String pay(double tutar, Currency currency);
}
