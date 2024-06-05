package ru.info_system_and_services.household_appliances_register.service;

import ru.info_system_and_services.household_appliances_register.model.dto.hoover.CreateHooverDto;
import ru.info_system_and_services.household_appliances_register.model.dto.hoover.HooverDto;

import java.math.BigDecimal;
import java.util.List;

public interface HooverService {

    List<HooverDto> getAllByName(
            String name,
            String productName,
            String color,
            BigDecimal startPrice,
            BigDecimal endPrice,
            String category,
            String technology
    );

    HooverDto addNewHoover(CreateHooverDto createHooverDto) throws Exception;
}
