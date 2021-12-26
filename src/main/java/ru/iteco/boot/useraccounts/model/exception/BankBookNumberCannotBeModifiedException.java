package ru.iteco.boot.useraccounts.model.exception;

public class BankBookNumberCannotBeModifiedException extends RuntimeException {
    public BankBookNumberCannotBeModifiedException(String message) {
        super(message);
    }
}
