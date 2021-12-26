package ru.iteco.boot.useraccounts.model.dto;
import lombok.Builder;
import lombok.Data;
import ru.iteco.boot.useraccounts.validation.Created;
import ru.iteco.boot.useraccounts.validation.Currency;
import ru.iteco.boot.useraccounts.validation.Update;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Data
@Builder
public class BankBookDto {

    @Null(groups = Created.class)
    @NotNull(groups = Update.class)
    private Integer id;

    @NotNull
    private Integer userId;

    @NotBlank(message = "имя не может быть пустым")
    private String number;

    @PositiveOrZero
    @NotNull
    private BigDecimal amount;

    @Currency
    @NotNull
    private String currency;
}