package ru.info_system_and_services.household_appliances_register.service;

import ru.info_system_and_services.household_appliances_register.model.dto.fridge.CreateFridgeDto;
import ru.info_system_and_services.household_appliances_register.model.dto.fridge.FridgeDto;

import java.math.BigDecimal;
import java.util.List;

public interface FridgeService {

    List<FridgeDto> getAllByName(
            String name,
            String productName,
            String color,
            BigDecimal startPrice,
            BigDecimal endPrice,
            String category,
            String technology
    );

    FridgeDto addNewFridge(CreateFridgeDto createFridgeDto) throws Exception;
}
