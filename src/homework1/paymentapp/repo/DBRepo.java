package homework1.paymentapp.repo;

public class DBRepo implements PaymentRepository{
    @Override
    public void save(String paymentDetails) {
        System.out.println("LOG: Veritabanına kaydedildi: " + paymentDetails);
    }
}
