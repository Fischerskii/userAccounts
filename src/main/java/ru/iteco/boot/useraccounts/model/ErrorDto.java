package ru.iteco.boot.useraccounts.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDto {

    private String status;
    private String message;
}
