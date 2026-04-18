package homework1.app.payment;

import homework1.app.payment.enums.Currency;

public class CreditCard implements PaymentMethod {
    @Override
    public String pay(double tutar, Currency currency) {
        return "Kredi Kartı ile " + tutar + " " + currency + " değerindeki ödemeniz başarılı bir şekilde yapılmıştır.";
    }
}
