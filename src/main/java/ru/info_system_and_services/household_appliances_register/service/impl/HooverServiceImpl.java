package ru.info_system_and_services.household_appliances_register.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.info_system_and_services.household_appliances_register.exception.SuchModelAlreadyExistException;
import ru.info_system_and_services.household_appliances_register.mapper.HooverMapper;
import ru.info_system_and_services.household_appliances_register.mapper.HouseholdApplianceMapper;
import ru.info_system_and_services.household_appliances_register.model.dto.hoover.CreateHooverDto;
import ru.info_system_and_services.household_appliances_register.model.dto.hoover.HooverDto;
import ru.info_system_and_services.household_appliances_register.model.entity.Hoover;
import ru.info_system_and_services.household_appliances_register.model.entity.HouseholdAppliance;
import ru.info_system_and_services.household_appliances_register.model.entity.ProductName;
import ru.info_system_and_services.household_appliances_register.repository.HooverRepository;
import ru.info_system_and_services.household_appliances_register.repository.HouseholdApplianceRepository;
import ru.info_system_and_services.household_appliances_register.service.HooverService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HooverServiceImpl implements HooverService {

    private final HouseholdApplianceRepository householdApplianceRepository;
    private final HooverRepository hooverRepository;

    private final HouseholdApplianceMapper householdApplianceMapper;
    private final HooverMapper hooverMapper;

    @Override
    public List<HooverDto> getAllByName(String name, String productName, String color, BigDecimal startPrice,
                                        BigDecimal endPrice, String dustCollectorVolume, String modeQuantity) {
        return hooverRepository.findByName(
                name,
                ProductName.valueOf(productName),
                color,
                startPrice,
                endPrice,
                dustCollectorVolume,
                modeQuantity
        );
    }

    @Override
    public HooverDto addNewHoover(CreateHooverDto createHooverDto) {
        Optional<HouseholdAppliance> householdAppliance = householdApplianceRepository
                .getByProductNameAndCountryAndCompany(
                        createHooverDto.getProductName(),
                        createHooverDto.getCountry(),
                        createHooverDto.getCompany()
                );

        Hoover hoover = hooverMapper.dtoToEntity(createHooverDto);

        if (householdAppliance.isPresent()) {
            Optional<Hoover> model = hooverRepository.findByNameAndColorAndSizeAndDustCollectorVolumeAndModeQuantityAndHouseholdAppliance(
                    createHooverDto.getName(),
                    createHooverDto.getColor(),
                    createHooverDto.getSize(),
                    createHooverDto.getDustCollectorVolume(),
                    createHooverDto.getModeQuantity(),
                    householdAppliance.get());

            if (model.isPresent()) {
                throw new SuchModelAlreadyExistException();
            }

            hoover.setHouseholdAppliance(householdAppliance.get());

        } else {
            HouseholdAppliance householdApplianceForSave = householdApplianceMapper.dtoToEntity(createHooverDto);
            HouseholdAppliance householdApplianceSaved = householdApplianceRepository.save(householdApplianceForSave);
            hoover.setHouseholdAppliance(householdApplianceSaved);
        }

        return hooverMapper.entityToDto(hooverRepository.save(hoover));
    }
}
