package ru.info_system_and_services.household_appliances_register.mapper;

import org.springframework.stereotype.Component;
import ru.info_system_and_services.household_appliances_register.model.dto.fridge.CreateFridgeDto;
import ru.info_system_and_services.household_appliances_register.model.dto.fridge.FridgeDto;
import ru.info_system_and_services.household_appliances_register.model.entity.Fridge;

@Component
public class FridgeMapper {

    public Fridge dtoToEntity(CreateFridgeDto createFridgeDto) {
        return new Fridge(
                createFridgeDto.getName(),
                createFridgeDto.getSerialNumber(),
                createFridgeDto.getColor(),
                createFridgeDto.getSize(),
                createFridgeDto.getPrice(),
                createFridgeDto.getIsAvailable(),
                createFridgeDto.getDoorFridgeQuantity(),
                createFridgeDto.getCompressorType()
        );
    }

    public FridgeDto entityToDto(Fridge fridge) {
        return new FridgeDto(
                fridge.getId(),
                fridge.getHouseholdAppliance().getProductName(),
                fridge.getHouseholdAppliance().getCountry(),
                fridge.getHouseholdAppliance().getCompany(),
                fridge.getHouseholdAppliance().getIsOrderOnline(),
                fridge.getHouseholdAppliance().getIsPossibleInstallments(),
                fridge.getName(),
                fridge.getSerialNumber(),
                fridge.getColor(),
                fridge.getSize(),
                fridge.getPrice(),
                fridge.getIsAvailable(),
                fridge.getDoorFridgeQuantity(),
                fridge.getCompressorType()
        );
    }
}
