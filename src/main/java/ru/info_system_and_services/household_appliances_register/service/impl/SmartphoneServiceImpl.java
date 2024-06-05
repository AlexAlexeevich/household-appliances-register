package ru.info_system_and_services.household_appliances_register.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.info_system_and_services.household_appliances_register.exception.SuchModelAlreadyExistException;
import ru.info_system_and_services.household_appliances_register.mapper.HouseholdApplianceMapper;
import ru.info_system_and_services.household_appliances_register.mapper.SmartphoneMapper;
import ru.info_system_and_services.household_appliances_register.model.dto.smartphone.CreateSmartphoneDto;
import ru.info_system_and_services.household_appliances_register.model.dto.smartphone.SmartphoneDto;
import ru.info_system_and_services.household_appliances_register.model.entity.HouseholdAppliance;
import ru.info_system_and_services.household_appliances_register.model.entity.ProductName;
import ru.info_system_and_services.household_appliances_register.model.entity.Smartphone;
import ru.info_system_and_services.household_appliances_register.repository.HouseholdApplianceRepository;
import ru.info_system_and_services.household_appliances_register.repository.SmartphoneRepository;
import ru.info_system_and_services.household_appliances_register.service.SmartphoneService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SmartphoneServiceImpl implements SmartphoneService {

    private final HouseholdApplianceRepository householdApplianceRepository;
    private final SmartphoneRepository smartphoneRepository;

    private final HouseholdApplianceMapper householdApplianceMapper;
    private final SmartphoneMapper smartphoneMapper;

    @Override
    public List<SmartphoneDto> getAllByName(String name, String productName, String color, BigDecimal startPrice,
                                            BigDecimal endPrice, String memory, String cameraQuantity) {
        return smartphoneRepository.findByName(
                name,
                ProductName.valueOf(productName),
                color,
                startPrice,
                endPrice,
                memory,
                cameraQuantity
        );
    }

    @Override
    public SmartphoneDto addNewSmartphone(CreateSmartphoneDto createSmartphoneDto) {
        Optional<HouseholdAppliance> householdAppliance = householdApplianceRepository
                .getByProductNameAndCountryAndCompany(
                        createSmartphoneDto.getProductName(),
                        createSmartphoneDto.getCountry(),
                        createSmartphoneDto.getCompany()
                );

        Smartphone smartphone = smartphoneMapper.dtoToEntity(createSmartphoneDto);

        if (householdAppliance.isPresent()) {
            Optional<Smartphone> model = smartphoneRepository.findByNameAndColorAndSizeAndMemoryAndCameraQuantityAndHouseholdAppliance(
                    createSmartphoneDto.getName(),
                    createSmartphoneDto.getColor(),
                    createSmartphoneDto.getSize(),
                    createSmartphoneDto.getMemory(),
                    createSmartphoneDto.getCameraQuantity(),
                    householdAppliance.get());

            if (model.isPresent()) {
                throw new SuchModelAlreadyExistException();
            }

            smartphone.setHouseholdAppliance(householdAppliance.get());

        } else {
            HouseholdAppliance householdApplianceForSave = householdApplianceMapper.dtoToEntity(createSmartphoneDto);
            HouseholdAppliance householdApplianceSaved = householdApplianceRepository.save(householdApplianceForSave);
            smartphone.setHouseholdAppliance(householdApplianceSaved);
        }

        return smartphoneMapper.entityToDto(smartphoneRepository.save(smartphone));
    }
}
