package ru.info_system_and_services.household_appliances_register.mapper;

import org.springframework.stereotype.Component;
import ru.info_system_and_services.household_appliances_register.model.dto.smartphone.CreateSmartphoneDto;
import ru.info_system_and_services.household_appliances_register.model.dto.smartphone.SmartphoneDto;
import ru.info_system_and_services.household_appliances_register.model.entity.Smartphone;

@Component
public class SmartphoneMapper {

    public Smartphone dtoToEntity(CreateSmartphoneDto createSmartphoneDto) {

        return new Smartphone(
                createSmartphoneDto.getName(),
                createSmartphoneDto.getSerialNumber(),
                createSmartphoneDto.getColor(),
                createSmartphoneDto.getSize(),
                createSmartphoneDto.getPrice(),
                createSmartphoneDto.getIsAvailable(),
                createSmartphoneDto.getMemory(),
                createSmartphoneDto.getCameraQuantity()
        );
    }

    public SmartphoneDto entityToDto(Smartphone smartphone) {
        return new SmartphoneDto(
                smartphone.getId(),
                smartphone.getHouseholdAppliance().getProductName(),
                smartphone.getHouseholdAppliance().getCountry(),
                smartphone.getHouseholdAppliance().getCompany(),
                smartphone.getHouseholdAppliance().getIsOrderOnline(),
                smartphone.getHouseholdAppliance().getIsPossibleInstallments(),
                smartphone.getName(),
                smartphone.getSerialNumber(),
                smartphone.getColor(),
                smartphone.getSize(),
                smartphone.getPrice(),
                smartphone.getIsAvailable(),
                smartphone.getMemory(),
                smartphone.getCameraQuantity()
        );
    }
}
