package homework1.paymentapp;

import homework1.paymentapp.payment.PaymentRegistry;
import homework1.paymentapp.repo.DBRepo;
import homework1.paymentapp.repo.PaymentRepository;
import homework1.paymentapp.service.PaymentService;
import homework1.paymentapp.ui.PaymentUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        PaymentRegistry registry = new PaymentRegistry();
        PaymentRepository repo = new DBRepo();
        PaymentService service = new PaymentService(registry, repo);

        SwingUtilities.invokeLater(() -> {
            new PaymentUI(service);
        });
    }
}