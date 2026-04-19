package homework1.paymentapp.controller;

import homework1.paymentapp.payment.enums.Currency;
import homework1.paymentapp.payment.enums.PaymentType;
import homework1.paymentapp.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/pay")
    public String makePayment(
            @RequestParam PaymentType type,
            @RequestParam double amount,
            @RequestParam Currency currency) {

        return paymentService.payAmount(type, amount, currency);
    }

    //Optional
//    @GetMapping("/pay-json")
//    public Map<String, Object> makePaymentJson(
//            @RequestParam PaymentType type,
//            @RequestParam double amount,
//            @RequestParam Currency currency) {
//
//        String result = paymentService.payAmount(type, amount, currency);
//
//        Map<String, Object> response = new HashMap<>();
//        response.put("status", "SUCCESS");
//        response.put("message", result);
//        response.put("timestamp", System.currentTimeMillis());
//
//        return response;
//    }

}
