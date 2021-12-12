package ru.iteco.boot.useraccounts.service;


import ch.qos.logback.core.util.InvocationGate;
import ru.iteco.boot.useraccounts.model.BankBookDto;

import java.util.List;

public interface BankBookService {
    List<BankBookDto> findAll();
    List<BankBookDto> findByUserId(Integer userId);
    BankBookDto findById(Integer id);
    BankBookDto create(BankBookDto bankBookDto);
    BankBookDto update(BankBookDto bankBookDto);
    void delete(Integer id);
    void deleteByUserId(Integer userId);
}
