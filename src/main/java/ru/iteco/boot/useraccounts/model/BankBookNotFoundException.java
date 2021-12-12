package ru.iteco.boot.useraccounts.model;

public class BankBookNotFoundException extends RuntimeException {

    private final String idNotFound;

    public BankBookNotFoundException(String idNotFound) {
        this.idNotFound = idNotFound;
    }

    public BankBookNotFoundException(String message, String idNotFound) {
        super(message);
        this.idNotFound = idNotFound;
    }

    public BankBookNotFoundException(String message, Throwable cause, String idNotFound) {
        super(message, cause);
        this.idNotFound = idNotFound;
    }

    public BankBookNotFoundException(Throwable cause, String idNotFound) {
        super(cause);
        this.idNotFound = idNotFound;
    }

    public BankBookNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String idNotFound) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.idNotFound = idNotFound;
    }

    public String getIdNotFound() {
        return idNotFound;
    }
}
