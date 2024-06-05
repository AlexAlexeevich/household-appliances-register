package ru.info_system_and_services.household_appliances_register.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.info_system_and_services.household_appliances_register.exception.SuchModelAlreadyExistException;
import ru.info_system_and_services.household_appliances_register.mapper.FridgeMapper;
import ru.info_system_and_services.household_appliances_register.mapper.HouseholdApplianceMapper;
import ru.info_system_and_services.household_appliances_register.model.dto.fridge.CreateFridgeDto;
import ru.info_system_and_services.household_appliances_register.model.dto.fridge.FridgeDto;
import ru.info_system_and_services.household_appliances_register.model.entity.Fridge;
import ru.info_system_and_services.household_appliances_register.model.entity.HouseholdAppliance;
import ru.info_system_and_services.household_appliances_register.model.entity.ProductName;
import ru.info_system_and_services.household_appliances_register.repository.FridgeRepository;
import ru.info_system_and_services.household_appliances_register.repository.HouseholdApplianceRepository;
import ru.info_system_and_services.household_appliances_register.service.FridgeService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FridgeServiceImpl implements FridgeService {

    private final HouseholdApplianceRepository householdApplianceRepository;
    private final FridgeRepository fridgeRepository;

    private final HouseholdApplianceMapper householdApplianceMapper;
    private final FridgeMapper fridgeMapper;

    @Override
    public List<FridgeDto> getAllByName(String name, String productName, String color, BigDecimal startPrice,
                                        BigDecimal endPrice, String category, String technology) {
        return fridgeRepository.findByName(
                name,
                ProductName.valueOf(productName),
                color,
                startPrice,
                endPrice,
                category,
                technology
        );
    }

    @Override
    public FridgeDto addNewFridge(CreateFridgeDto createFridgeDto) {
        Optional<HouseholdAppliance> householdAppliance = householdApplianceRepository
                .getByProductNameAndCountryAndCompany(
                        createFridgeDto.getProductName(),
                        createFridgeDto.getCountry(),
                        createFridgeDto.getCompany()
                );

        Fridge fridge = fridgeMapper.dtoToEntity(createFridgeDto);

        if (householdAppliance.isPresent()) {
            Optional<Fridge> model = fridgeRepository.findByNameAndColorAndSizeAndDoorFridgeQuantityAndCompressorTypeAndHouseholdAppliance(
                    createFridgeDto.getName(),
                    createFridgeDto.getColor(),
                    createFridgeDto.getSize(),
                    createFridgeDto.getDoorFridgeQuantity(),
                    createFridgeDto.getCompressorType(),
                    householdAppliance.get());

            if (model.isPresent()) {
                throw new SuchModelAlreadyExistException();
            }

            fridge.setHouseholdAppliance(householdAppliance.get());

        } else {
            HouseholdAppliance householdApplianceForSave = householdApplianceMapper.dtoToEntity(createFridgeDto);
            HouseholdAppliance householdApplianceSaved = householdApplianceRepository.save(householdApplianceForSave);
            fridge.setHouseholdAppliance(householdApplianceSaved);
        }

        return fridgeMapper.entityToDto(fridgeRepository.save(fridge));
    }
}
