package homework1.paymentapp.payment;

import homework1.paymentapp.payment.enums.Currency;

public class DebitCard implements PaymentMethod {
    @Override
    public String pay(double tutar, Currency currency) {
        return String.format("Banka Kartı ile %.2f %s değerindeki ödemeniz başarılıdır.", tutar, currency);
    }
}
