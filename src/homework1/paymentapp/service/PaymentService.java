package homework1.paymentapp.service;

import homework1.paymentapp.payment.PaymentMethod;
import homework1.paymentapp.payment.PaymentRegistry;
import homework1.paymentapp.payment.enums.Currency;
import homework1.paymentapp.payment.enums.PaymentType;
import homework1.paymentapp.repo.PaymentRepository;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PaymentService {
    private static final Logger logger = Logger.getLogger(PaymentService.class.getName());

    private final PaymentRegistry registry;
    private final PaymentRepository repository;

    public PaymentService(PaymentRegistry registry,  PaymentRepository repository) {
        this.registry = registry;
        this.repository = repository;
    }

    public String payAmount(PaymentType type, double amount, Currency currency) {
        logger.info("Ödeme işlemi başlatıldı. Yöntem: " + type + ", Tutar: " + amount + " " + currency);
        try {
            PaymentMethod method = registry.get(type);

            String result = method.pay(amount, currency);
            logger.info("Ödeme başarıyla gerçekleşti. Sonuç: " + result);

            repository.save(result);
            logger.info("Ödeme kaydı sisteme işlendi.");

            return result;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Ödeme işlemi sırasında bir hata oluştu!", e);
            return "Hata: Ödeme tamamlanamadı. " + e.getMessage();
        }
    }
}
