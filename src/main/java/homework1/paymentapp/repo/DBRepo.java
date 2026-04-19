package homework1.paymentapp.repo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class DBRepo implements PaymentRepository{
    @Override
    public void save(String paymentDetails) {
        System.out.println("LOG: Veritabanına kaydedildi: " + paymentDetails);
    }
}
