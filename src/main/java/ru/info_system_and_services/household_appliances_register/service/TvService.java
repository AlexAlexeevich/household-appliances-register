package ru.info_system_and_services.household_appliances_register.service;

import ru.info_system_and_services.household_appliances_register.model.dto.tv.CreateTvDto;
import ru.info_system_and_services.household_appliances_register.model.dto.tv.TvDto;

import java.math.BigDecimal;
import java.util.List;

public interface TvService {

    List<TvDto> getAllByName(
            String name,
            String productName,
            String color,
            BigDecimal startPrice,
            BigDecimal endPrice,
            String category,
            String technology
    );

    TvDto addNewTv(CreateTvDto createTvDto) throws Exception;
}
