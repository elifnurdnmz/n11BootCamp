package homework1.paymentapp.payment;

import homework1.paymentapp.payment.enums.PaymentType;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

@Component
public class PaymentRegistry {
    private final Map<PaymentType, PaymentMethod> payments = new HashMap<>();

    public PaymentRegistry() {
        autoRegister();
    }

    private void autoRegister() {
        try {
            for (PaymentType type : PaymentType.values()) {
                String className = "homework1.paymentapp.payment." + formatClassName(type.name());

                Class<?> clazz = Class.forName(className);
                Constructor<?> constructor = clazz.getConstructor();
                PaymentMethod instance = (PaymentMethod) constructor.newInstance();

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
