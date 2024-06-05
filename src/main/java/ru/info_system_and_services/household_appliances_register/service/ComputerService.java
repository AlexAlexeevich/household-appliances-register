package ru.info_system_and_services.household_appliances_register.service;

import ru.info_system_and_services.household_appliances_register.model.dto.computer.ComputerDto;
import ru.info_system_and_services.household_appliances_register.model.dto.computer.CreateComputerDto;

import java.math.BigDecimal;
import java.util.List;

public interface ComputerService {

    List<ComputerDto> getAllByName(
            String name,
            String productName,
            String color,
            BigDecimal startPrice,
            BigDecimal endPrice,
            String category,
            String processorType
    );

    ComputerDto addNewComputer(CreateComputerDto createComputerDto) throws Exception;
}
