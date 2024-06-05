package ru.info_system_and_services.household_appliances_register.service;

import ru.info_system_and_services.household_appliances_register.model.dto.smartphone.CreateSmartphoneDto;
import ru.info_system_and_services.household_appliances_register.model.dto.smartphone.SmartphoneDto;

import java.math.BigDecimal;
import java.util.List;

public interface SmartphoneService {

    List<SmartphoneDto> getAllByName(
            String name,
            String productName,
            String color,
            BigDecimal startPrice,
            BigDecimal endPrice,
            String memory,
            String cameraQuantity
    );

    SmartphoneDto addNewSmartphone(CreateSmartphoneDto createSmartphoneDto) throws Exception;
}
