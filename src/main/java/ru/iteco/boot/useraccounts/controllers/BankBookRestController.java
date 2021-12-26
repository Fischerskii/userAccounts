package ru.iteco.boot.useraccounts.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import ru.iteco.boot.useraccounts.model.dto.BankBookDto;
import ru.iteco.boot.useraccounts.service.BankBookService;
import ru.iteco.boot.useraccounts.validation.Created;
import ru.iteco.boot.useraccounts.validation.Update;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("bank/bank-book")
@Validated
public class BankBookRestController {

    private final BankBookService bankBookService;

    @GetMapping({"/id", "/"})
    public ResponseEntity<BankBookDto> getBankBookById(@Min(2) @PathVariable Integer id) {
        return ResponseEntity.ok(bankBookService.findById(id));
    }

    @GetMapping({"/by-user-id/{userID}", "/by-user-id/"})
    public ResponseEntity<List<BankBookDto>> getBankBookByUserId(@CookieValue Integer userId, @RequestHeader Map<String, String> headers) {
        log.info("Headers: {}", headers);
        return ResponseEntity.ok(bankBookService.findByUserId(userId));
    }

    @Validated(Created.class)
    @PostMapping
    public ResponseEntity<BankBookDto> createBankBook(@Valid @RequestBody BankBookDto bankBookDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(bankBookService.create(bankBookDto));
    }

    @Validated(Update.class)
    @PutMapping
    public BankBookDto updateBankBook(@Valid @RequestBody BankBookDto bankBookDto) {
        return bankBookService.update(bankBookDto);
    }

    @DeleteMapping({"/id", "/"})
    public void deleteBankBook(@PathVariable Integer id) {
        bankBookService.delete(id);
    }

    @DeleteMapping({"/bu-user-id/{id}", "/by-user-id/"})
    public void deleteBankBookByUserId(@PathVariable Integer userId) {
        bankBookService.deleteByUserId(userId);
    }
}
