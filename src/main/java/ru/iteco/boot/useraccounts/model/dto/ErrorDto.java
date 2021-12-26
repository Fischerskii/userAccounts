package ru.iteco.boot.useraccounts.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ErrorDto {

    private String status;
    private String message;
}
