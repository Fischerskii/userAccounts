package ru.iteco.boot.useraccounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.iteco.boot.useraccounts.model.entity.CurrencyEntity;

public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Integer> {

    CurrencyEntity findByName(String name);
}
