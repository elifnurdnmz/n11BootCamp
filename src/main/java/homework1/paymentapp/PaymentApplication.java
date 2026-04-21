package homework1.paymentapp;

import homework1.paymentapp.payment.table.Payment;
import homework1.paymentapp.repo.PaymentDBRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class PaymentApplication {
    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(PaymentApplication.class);
        builder.headless(false).run(args);
    }

    @Bean
    public CommandLineRunner runOnStart(PaymentDBRepo test) {
        return args -> {
            Payment payment = new Payment();
            payment.setCustomerName("Elifnur Donmez");
            payment.setAmount(new BigDecimal("1500.00"));

            test.save(payment);

            System.out.println("--- Veritabanına başarıyla kayıt eklendi! ---");
        };
    }
}
