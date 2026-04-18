package homework1.app.ui;

import homework1.app.exceptions.InvalidAmountException;
import homework1.app.payment.*;
import homework1.app.payment.enums.Currency;
import homework1.app.payment.enums.PaymentType;
import homework1.app.validation.AmountValidator;

import javax.swing.*;
import java.awt.*;

public class PaymentUI extends JFrame {

    private JLabel resultLabel;

    public PaymentUI() {
        setTitle("ÖDEME EKRANI");
        setSize(500, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JComboBox<PaymentType> paymentBox = new JComboBox<>(PaymentType.values());
        JComboBox<Currency> currencyBox = new JComboBox<>(Currency.values());
        JTextField amountField = new JTextField(10);

        JButton payButton = new JButton("Öde");

        resultLabel = new JLabel("Ödeme yöntemi seçiniz");

        PaymentRegistry payments = new PaymentRegistry();

        payButton.addActionListener(e -> {

            PaymentType selectedPayment = (PaymentType) paymentBox.getSelectedItem();
            Currency selectedCurrency = (Currency) currencyBox.getSelectedItem();

            double amount;

            try {
                amount = AmountValidator.validate(amountField.getText());
            } catch (InvalidAmountException ex) {
                resultLabel.setText(ex.getMessage());
                return;
            }

            PaymentMethod payment = payments.get(selectedPayment);
            resultLabel.setText(payment.pay(amount, selectedCurrency));
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
