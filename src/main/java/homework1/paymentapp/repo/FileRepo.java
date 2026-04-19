package homework1.paymentapp.repo;

import org.springframework.stereotype.Repository;

@Repository
public class FileRepo implements PaymentRepository {
    @Override
    public void save(String paymentDetails) {
        System.out.println("LOG: Metin dosyasına kaydedildi: " + paymentDetails);
    }
}
