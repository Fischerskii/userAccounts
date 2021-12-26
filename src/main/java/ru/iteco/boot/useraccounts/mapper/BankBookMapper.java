package ru.iteco.boot.useraccounts.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.iteco.boot.useraccounts.model.entity.BankBookEntity;
import ru.iteco.boot.useraccounts.model.dto.BankBookDto;

@Mapper(componentModel = "spring")
public interface BankBookMapper {

    @Mapping(target = "currency", source = "currency.name")
    BankBookDto mapToDto(BankBookEntity bankBookEntity);
    @Mapping(target = "currency.name", source = "currency")
    BankBookEntity mapToEntity(BankBookDto bankBookDto);
}