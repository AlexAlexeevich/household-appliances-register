package ru.info_system_and_services.household_appliances_register.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.info_system_and_services.household_appliances_register.exception.SuchModelAlreadyExistException;
import ru.info_system_and_services.household_appliances_register.mapper.ComputerMapper;
import ru.info_system_and_services.household_appliances_register.mapper.HouseholdApplianceMapper;
import ru.info_system_and_services.household_appliances_register.model.dto.computer.ComputerDto;
import ru.info_system_and_services.household_appliances_register.model.dto.computer.CreateComputerDto;
import ru.info_system_and_services.household_appliances_register.model.entity.Computer;
import ru.info_system_and_services.household_appliances_register.model.entity.HouseholdAppliance;
import ru.info_system_and_services.household_appliances_register.model.entity.ProductName;
import ru.info_system_and_services.household_appliances_register.repository.ComputerRepository;
import ru.info_system_and_services.household_appliances_register.repository.HouseholdApplianceRepository;
import ru.info_system_and_services.household_appliances_register.service.ComputerService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ComputerServiceImpl implements ComputerService {

    private final HouseholdApplianceRepository householdApplianceRepository;
    private final ComputerRepository computerRepository;

    private final HouseholdApplianceMapper householdApplianceMapper;
    private final ComputerMapper computerMapper;

    @Override
    public List<ComputerDto> getAllByName(String name, String productName, String color, BigDecimal startPrice,
                                          BigDecimal endPrice, String category, String processorType) {
        return computerRepository.findByName(
                name,
                ProductName.valueOf(productName),
                color,
                startPrice,
                endPrice,
                category,
                processorType
        );
    }

    @Override
    public ComputerDto addNewComputer(CreateComputerDto createComputerDto) {
        Optional<HouseholdAppliance> householdAppliance = householdApplianceRepository
                .getByProductNameAndCountryAndCompany(
                        createComputerDto.getProductName(),
                        createComputerDto.getCountry(),
                        createComputerDto.getCompany()
                );

        Computer computer = computerMapper.dtoToEntity(createComputerDto);

        if (householdAppliance.isPresent()) {
            Optional<Computer> model = computerRepository.findByNameAndColorAndSizeAndCategoryAndProcessorTypeAndHouseholdAppliance(
                    createComputerDto.getName(),
                    createComputerDto.getColor(),
                    createComputerDto.getSize(),
                    createComputerDto.getCategory(),
                    createComputerDto.getProcessorType(),
                    householdAppliance.get());

            if (model.isPresent()) {
                throw new SuchModelAlreadyExistException();
            }

            computer.setHouseholdAppliance(householdAppliance.get());

        } else {
            HouseholdAppliance householdApplianceForSave = householdApplianceMapper.dtoToEntity(createComputerDto);
            HouseholdAppliance householdApplianceSaved = householdApplianceRepository.save(householdApplianceForSave);
            computer.setHouseholdAppliance(householdApplianceSaved);
        }

        return computerMapper.entityToDto(computerRepository.save(computer));
    }
}
