package ru.iteco.boot.useraccounts.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.iteco.boot.useraccounts.model.BankBookNotFoundException;
import ru.iteco.boot.useraccounts.model.BankBookNumberCannotBeModifiedException;
import ru.iteco.boot.useraccounts.model.BankBookWithCurrencyAlreadyHaveException;
import ru.iteco.boot.useraccounts.model.ErrorDto;

@RestControllerAdvice
public class BankBookRestExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(BankBookNotFoundException.class)
    public ErrorDto handleBankBookNotFoundException(BankBookNotFoundException exception) {
        return new ErrorDto(HttpStatus.NOT_FOUND.name(), exception.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BankBookNumberCannotBeModifiedException.class)
    public ErrorDto handleBankBookNumberCannotBeModifiedException(BankBookNumberCannotBeModifiedException exception) {
        return new ErrorDto(HttpStatus.BAD_REQUEST.name(), exception.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BankBookWithCurrencyAlreadyHaveException.class)
    public ErrorDto handleBankBookWithCurrencyAlreadyHaveException(BankBookWithCurrencyAlreadyHaveException exception) {
        return new ErrorDto(HttpStatus.BAD_REQUEST.name(), exception.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingPathVariableException.class)
    public ErrorDto handleMissingPathVariableException(MissingPathVariableException exception) {
        return new ErrorDto(HttpStatus.BAD_REQUEST.name(), exception.getMessage());
    }
}