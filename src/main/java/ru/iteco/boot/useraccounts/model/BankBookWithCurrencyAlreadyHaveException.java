package ru.iteco.boot.useraccounts.model;

public class BankBookWithCurrencyAlreadyHaveException extends RuntimeException {

    public BankBookWithCurrencyAlreadyHaveException(String message) {
        super(message);
    }
}
