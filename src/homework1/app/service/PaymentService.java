package homework1.app.service;

import homework1.app.payment.PaymentMethod;
import homework1.app.payment.enums.Currency;

public class PaymentService {

    private PaymentMethod paymentMethod;

    public PaymentService(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void payAmount(double tutar, Currency currency) {
        paymentMethod.pay(tutar, currency);
    }

}
