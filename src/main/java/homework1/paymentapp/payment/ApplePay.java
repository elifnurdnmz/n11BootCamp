package homework1.paymentapp.payment;

import homework1.paymentapp.payment.enums.Currency;
import org.springframework.stereotype.Component;

@Component
public class ApplePay implements PaymentMethod {
    @Override
    public String pay(double tutar, Currency currency) {
        return String.format("Apple Pay ile %.2f %s değerindeki ödemeniz başarılıdır.", tutar, currency);
    }
}
