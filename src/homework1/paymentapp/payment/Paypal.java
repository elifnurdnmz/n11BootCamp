package homework1.paymentapp.payment;

import homework1.paymentapp.payment.enums.Currency;

public class Paypal implements PaymentMethod {
    @Override
    public String pay(double tutar, Currency currency) {
        return String.format("PayPal ile %.2f %s değerindeki ödemeniz başarılıdır.", tutar, currency);
    }
}
