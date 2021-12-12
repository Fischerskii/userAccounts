package ru.iteco.boot.useraccounts.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.iteco.boot.useraccounts.model.BankBookDto;
import ru.iteco.boot.useraccounts.service.BankBookService;

import java.util.List;

@RestController
@RequestMapping("bank/bank-book")
public class BankBookRestController {

    private final BankBookService bankBookService;

    public BankBookRestController(BankBookService bankBookService) {
        this.bankBookService = bankBookService;
    }

    @GetMapping
    public ResponseEntity<List<BankBookDto>> getAll() {
        return ResponseEntity.ok(bankBookService.findAll());
    }

    @GetMapping({"/by-user-id/{userID}", "/by-user-id/"})
    public ResponseEntity<List<BankBookDto>> getByUserId(@PathVariable Integer userID) {
        return ResponseEntity.ok(bankBookService.findByUserId(userID));
    }

    @GetMapping({"/by-id/{id}", "/"})
    public ResponseEntity<BankBookDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(bankBookService.findById(id));
    }

    @PostMapping
    public ResponseEntity<BankBookDto> createAccount(@RequestBody BankBookDto bankBookDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(bankBookService.create(bankBookDto));
    }

    @PutMapping
    public BankBookDto updateBankBook(@RequestBody BankBookDto bankBookDto) {
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
