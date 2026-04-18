package homework1.app.payment;

import homework1.app.payment.enums.Currency;

public class PayPal implements PaymentMethod {
    @Override
    public String pay(double tutar, Currency currency) {
        return "PayPal ile " + tutar +  " " + currency + " değerindeki ödemeniz başarılı bir şekilde yapılmıştır";
    }
}
