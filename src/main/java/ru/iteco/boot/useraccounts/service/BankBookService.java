package ru.iteco.boot.useraccounts.service;


import ru.iteco.boot.useraccounts.model.dto.BankBookDto;

import java.util.List;

public interface BankBookService {
    List<BankBookDto> findByUserId(Integer userId);
    BankBookDto findById(Integer id);
    BankBookDto create(BankBookDto bankBookDto);
    BankBookDto update(BankBookDto bankBookDto);
    void delete(Integer id);
    void deleteByUserId(Integer userId);
}