package homework1.paymentapp.validation;

import homework1.paymentapp.exceptions.InvalidAmountException;

public class AmountValidator {

    public static double validate(String input) {
        try {
            double amount = Double.parseDouble(input);

            if (amount <= 0) {
                throw new InvalidAmountException("Tutar 0'dan büyük olmalı!");
            }

            return amount;

        } catch (NumberFormatException e) {
            throw new InvalidAmountException("Geçerli bir sayı giriniz!");
        }
    }
}
