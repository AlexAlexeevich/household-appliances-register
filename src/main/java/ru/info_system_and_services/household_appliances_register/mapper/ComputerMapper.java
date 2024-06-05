package ru.info_system_and_services.household_appliances_register.mapper;

import org.springframework.stereotype.Component;
import ru.info_system_and_services.household_appliances_register.model.dto.computer.ComputerDto;
import ru.info_system_and_services.household_appliances_register.model.dto.computer.CreateComputerDto;
import ru.info_system_and_services.household_appliances_register.model.entity.Computer;

@Component
public class ComputerMapper {

    public Computer dtoToEntity(CreateComputerDto createComputerDto) {

        return new Computer(
                createComputerDto.getName(),
                createComputerDto.getSerialNumber(),
                createComputerDto.getColor(),
                createComputerDto.getSize(),
                createComputerDto.getPrice(),
                createComputerDto.getIsAvailable(),
                createComputerDto.getCategory(),
                createComputerDto.getProcessorType()
        );
    }

    public ComputerDto entityToDto(Computer computer) {
        return new ComputerDto(
                computer.getId(),
                computer.getHouseholdAppliance().getProductName(),
                computer.getHouseholdAppliance().getCountry(),
                computer.getHouseholdAppliance().getCompany(),
                computer.getHouseholdAppliance().getIsOrderOnline(),
                computer.getHouseholdAppliance().getIsPossibleInstallments(),
                computer.getName(),
                computer.getSerialNumber(),
                computer.getColor(),
                computer.getSize(),
                computer.getPrice(),
                computer.getIsAvailable(),
                computer.getCategory(),
                computer.getProcessorType()
        );
    }
}
