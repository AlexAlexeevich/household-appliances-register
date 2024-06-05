package ru.info_system_and_services.household_appliances_register.mapper;

import org.springframework.stereotype.Component;
import ru.info_system_and_services.household_appliances_register.model.dto.hoover.CreateHooverDto;
import ru.info_system_and_services.household_appliances_register.model.dto.hoover.HooverDto;
import ru.info_system_and_services.household_appliances_register.model.entity.Hoover;

@Component
public class HooverMapper {

    public Hoover dtoToEntity(CreateHooverDto createHooverDto) {
        return new Hoover(
                createHooverDto.getName(),
                createHooverDto.getSerialNumber(),
                createHooverDto.getColor(),
                createHooverDto.getSize(),
                createHooverDto.getPrice(),
                createHooverDto.getIsAvailable(),
                createHooverDto.getDustCollectorVolume(),
                createHooverDto.getModeQuantity()
        );
    }

    public HooverDto entityToDto(Hoover hoover) {
        return new HooverDto(
                hoover.getId(),
                hoover.getHouseholdAppliance().getProductName(),
                hoover.getHouseholdAppliance().getCountry(),
                hoover.getHouseholdAppliance().getCompany(),
                hoover.getHouseholdAppliance().getIsOrderOnline(),
                hoover.getHouseholdAppliance().getIsPossibleInstallments(),
                hoover.getName(),
                hoover.getSerialNumber(),
                hoover.getColor(),
                hoover.getSize(),
                hoover.getPrice(),
                hoover.getIsAvailable(),
                hoover.getDustCollectorVolume(),
                hoover.getModeQuantity()
        );
    }
}
