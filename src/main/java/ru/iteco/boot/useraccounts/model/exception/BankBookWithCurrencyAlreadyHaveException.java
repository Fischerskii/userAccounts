package ru.iteco.boot.useraccounts.model.exception;

public class BankBookWithCurrencyAlreadyHaveException extends RuntimeException {

    public BankBookWithCurrencyAlreadyHaveException(String message) {
        super(message);
    }
}
