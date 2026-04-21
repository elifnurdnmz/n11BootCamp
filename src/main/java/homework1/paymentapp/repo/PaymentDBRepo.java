package homework1.paymentapp.repo;

import homework1.paymentapp.payment.table.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDBRepo extends JpaRepository<Payment, Long> {

}
