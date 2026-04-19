package homework1.paymentapp;

import homework1.paymentapp.service.PaymentService;
import homework1.paymentapp.ui.PaymentUI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import javax.swing.SwingUtilities;

@Component
public class UIInitializer implements CommandLineRunner {

    private final PaymentService paymentService;

    public UIInitializer(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public void run(String... args) throws Exception {
        SwingUtilities.invokeLater(() -> {
            new PaymentUI(paymentService);
        });
    }
}