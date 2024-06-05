package ru.info_system_and_services.household_appliances_register.mapper;

import org.springframework.stereotype.Component;
import ru.info_system_and_services.household_appliances_register.model.dto.tv.CreateTvDto;
import ru.info_system_and_services.household_appliances_register.model.dto.tv.TvDto;
import ru.info_system_and_services.household_appliances_register.model.entity.TV;

@Component
public class TvMapper {

    public TV dtoToEntity(CreateTvDto createTvDto) {
        return new TV(
                createTvDto.getName(),
                createTvDto.getSerialNumber(),
                createTvDto.getColor(),
                createTvDto.getSize(),
                createTvDto.getPrice(),
                createTvDto.getIsAvailable(),
                createTvDto.getCategory(),
                createTvDto.getTechnology()
        );
    }

    public TvDto entityToDto(TV tv) {
        return new TvDto(
                tv.getId(),
                tv.getHouseholdAppliance().getProductName(),
                tv.getHouseholdAppliance().getCountry(),
                tv.getHouseholdAppliance().getCompany(),
                tv.getHouseholdAppliance().getIsOrderOnline(),
                tv.getHouseholdAppliance().getIsPossibleInstallments(),
                tv.getName(),
                tv.getSerialNumber(),
                tv.getColor(),
                tv.getSize(),
                tv.getPrice(),
                tv.getIsAvailable(),
                tv.getCategory(),
                tv.getTechnology()
        );
    }
}
