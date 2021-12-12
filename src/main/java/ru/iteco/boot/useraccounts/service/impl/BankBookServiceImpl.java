package ru.iteco.boot.useraccounts.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import ru.iteco.boot.useraccounts.model.BankBookDto;
import ru.iteco.boot.useraccounts.model.BankBookNotFoundException;
import ru.iteco.boot.useraccounts.model.BankBookNumberCannotBeModifiedException;
import ru.iteco.boot.useraccounts.model.BankBookWithCurrencyAlreadyHaveException;
import ru.iteco.boot.useraccounts.service.BankBookService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Component
public class BankBookServiceImpl implements BankBookService {

    private final Map<Integer, BankBookDto> bankBookDtoMap = new ConcurrentHashMap<>();
    private final AtomicInteger sequenceId = new AtomicInteger(1);

    @PostConstruct
    void init() {
        bankBookDtoMap.put(1, BankBookDto.builder()
                .id(1)
                .userId(4)
                .number("num1")
                .amount(BigDecimal.TEN)
                .currency("RUB")
                .build());
    }

    @Override
    public List<BankBookDto> findAll() {
        return new ArrayList<>(bankBookDtoMap.values());
    }

    @Override
    public List<BankBookDto> findByUserId(Integer userId) {
        List<BankBookDto> bankBookDtos = bankBookDtoMap.values().stream()
                .filter(bankBookDto -> userId.equals(bankBookDto.getUserId()))
                .collect(Collectors.toList());
        if (CollectionUtils.isEmpty(bankBookDtos)) {
            throw new BankBookNotFoundException("Пользователь по userId: " + userId + " не найден!");
        }
        return bankBookDtos;
    }

    @Override
    public BankBookDto findById(Integer id) {
        BankBookDto bankBookDto = bankBookDtoMap.get(id);
        if (bankBookDto == null) {
            throw new BankBookNotFoundException("Пользователь по id не найден!");
        }
        return bankBookDto;
    }

    @Override
    public BankBookDto create(BankBookDto bankBookDto) {
        boolean hasBankBook = bankBookDtoMap.values().stream()
                .anyMatch(bankBook -> bankBook.getUserId().equals(bankBookDto.getUserId())
                        && bankBook.getNumber().equals(bankBook.getNumber())
                        && bankBook.getCurrency().equals(bankBook.getCurrency())
                );
        if (hasBankBook) {
            throw new BankBookWithCurrencyAlreadyHaveException("Cчёт с данной валютой уже существует!");
        }
        int id = sequenceId.getAndIncrement();
        bankBookDto.setId(id);
        bankBookDtoMap.put(id, bankBookDto);
        return bankBookDto;
    }

    @Override
    public BankBookDto update(BankBookDto bankBookDto) {
        BankBookDto bankBookDtoFromMap = bankBookDtoMap.get(bankBookDto.getId());
        if (bankBookDtoFromMap == null) {
            throw new BankBookNotFoundException("Лицевой счет не найден");
        }
        if (!bankBookDtoFromMap.getNumber().equals(bankBookDto.getNumber())) {
            throw new BankBookNumberCannotBeModifiedException("Номер лицевого счёта менять нельзя!");
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        bankBookDtoMap.remove(id);
    }

    @Override
    public void deleteByUserId(Integer userId) {
        List<Integer> bankBookRemoveId = bankBookDtoMap.values().stream()
                .filter(bankBookDto -> bankBookDto.getUserId().equals(userId))
                .map(BankBookDto::getId)
                .collect(Collectors.toList());

        for (Integer removeId : bankBookRemoveId) {
            bankBookDtoMap.remove(removeId);
        }
    }
}
