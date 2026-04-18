package homework1.paymentapp.payment;

import homework1.paymentapp.payment.enums.Currency;

public class CreditCard implements PaymentMethod {
    @Override
    public String pay(double tutar, Currency currency) {
        return String.format("Kredi Kartı ile %.2f %s değerindeki ödemeniz başarılıdır.", tutar, currency);
    }
}
