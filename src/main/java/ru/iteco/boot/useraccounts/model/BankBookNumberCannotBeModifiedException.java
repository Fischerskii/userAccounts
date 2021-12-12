package ru.iteco.boot.useraccounts.model;

public class BankBookNumberCannotBeModifiedException extends RuntimeException {
    public BankBookNumberCannotBeModifiedException(String message) {
        super(message);
    }
}
