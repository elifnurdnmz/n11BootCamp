package homework1.paymentapp.payment;

import homework1.paymentapp.payment.enums.PaymentType;
import jakarta.annotation.PostConstruct;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PaymentRegistry {
    private final Map<PaymentType, PaymentMethod> payments = new HashMap<>();
    private final ApplicationContext applicationContext;

    public PaymentRegistry(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        autoRegister();
    }

    @PostConstruct
    private void autoRegister() {
        try {
            for (PaymentType type : PaymentType.values()) {
                String className = "homework1.paymentapp.payment." + formatClassName(type.name());
                Class<?> clazz = Class.forName(className);

                PaymentMethod instance = (PaymentMethod) applicationContext.getBean(clazz);

                payments.put(type, instance);
            }
        } catch (Exception e) {
            System.err.println("Reflection hatası: Bazı ödeme yöntemleri yüklenemedi.");
        }
    }

    private String formatClassName(String enumName) {
        StringBuilder sb = new StringBuilder();
        String[] parts = enumName.split("_");
        for (String part : parts) {
            sb.append(part.substring(0, 1).toUpperCase())
                    .append(part.substring(1).toLowerCase());
        }
        return sb.toString();
    }

    public PaymentMethod get(PaymentType type) {
        return payments.get(type);
    }
}
