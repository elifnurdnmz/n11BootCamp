package homework1.app.payment;

import homework1.app.payment.enums.Currency;

public class ApplePay implements PaymentMethod {
    @Override
    public String pay(double tutar, Currency currency) {
        return "Apple Pay ile " + tutar + " " + currency + " değerindeki ödemeniz başarılı bir şekilde yapılmıştır.";
    }
}
