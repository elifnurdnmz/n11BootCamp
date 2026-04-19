package homework1.paymentapp.repo;

public class FileRepo implements PaymentRepository {
    @Override
    public void save(String paymentDetails) {
        System.out.println("LOG: Metin dosyasına kaydedildi: " + paymentDetails);
    }
}
