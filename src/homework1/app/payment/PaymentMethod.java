package homework1.app.payment;

import homework1.app.payment.enums.Currency;

public interface PaymentMethod {
    String pay(double tutar, Currency currency);
}
