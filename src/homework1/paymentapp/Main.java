package homework1.paymentapp;

import homework1.paymentapp.payment.PaymentRegistry;
import homework1.paymentapp.service.PaymentService;
import homework1.paymentapp.ui.PaymentUI;

public class Main {
    public static void main(String[] args) {
        PaymentRegistry registry = new PaymentRegistry();
        PaymentService service = new PaymentService(registry);

        new PaymentUI(service);
    }
}