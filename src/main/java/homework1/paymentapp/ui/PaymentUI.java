package homework1.paymentapp.ui;

import homework1.paymentapp.exceptions.InvalidAmountException;
import homework1.paymentapp.payment.*;
import homework1.paymentapp.payment.enums.Currency;
import homework1.paymentapp.payment.enums.PaymentType;
import homework1.paymentapp.service.PaymentService;
import homework1.paymentapp.validation.AmountValidator;

import javax.swing.*;
import java.awt.*;

public class PaymentUI extends JFrame {

    private JLabel resultLabel;

    public PaymentUI(PaymentService paymentService) {
        setTitle("ÖDEME EKRANI");
        setSize(600, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JComboBox<PaymentType> paymentBox = new JComboBox<>(PaymentType.values());
        JComboBox<Currency> currencyBox = new JComboBox<>(Currency.values());
        JTextField amountField = new JTextField(10);

        JButton payButton = new JButton("Öde");

        resultLabel = new JLabel("Ödeme yöntemi seçiniz");

        payButton.addActionListener(e -> {

            try {
                double amount = AmountValidator.validate(amountField.getText());
                PaymentType selectedPayment = (PaymentType) paymentBox.getSelectedItem();
                Currency selectedCurrency = (Currency) currencyBox.getSelectedItem();
                String message = paymentService.payAmount(selectedPayment, amount, selectedCurrency);
                resultLabel.setText(message);
            } catch (InvalidAmountException ex) {
                resultLabel.setText(ex.getMessage());
            }
        });

        add(paymentBox);
        add(amountField);
        add(currencyBox);
        add(payButton);
        add(resultLabel);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
