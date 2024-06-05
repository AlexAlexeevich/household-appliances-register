package ru.info_system_and_services.household_appliances_register.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.info_system_and_services.household_appliances_register.exception.SuchModelAlreadyExistException;
import ru.info_system_and_services.household_appliances_register.mapper.HouseholdApplianceMapper;
import ru.info_system_and_services.household_appliances_register.mapper.TvMapper;
import ru.info_system_and_services.household_appliances_register.model.dto.tv.CreateTvDto;
import ru.info_system_and_services.household_appliances_register.model.dto.tv.TvDto;
import ru.info_system_and_services.household_appliances_register.model.entity.HouseholdAppliance;
import ru.info_system_and_services.household_appliances_register.model.entity.ProductName;
import ru.info_system_and_services.household_appliances_register.model.entity.TV;
import ru.info_system_and_services.household_appliances_register.repository.HouseholdApplianceRepository;
import ru.info_system_and_services.household_appliances_register.repository.TvRepository;
import ru.info_system_and_services.household_appliances_register.service.TvService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TvServiceImpl implements TvService {

    private final HouseholdApplianceRepository householdApplianceRepository;
    private final TvRepository tvRepository;

    private final HouseholdApplianceMapper householdApplianceMapper;
    private final TvMapper tvMapper;

    @Override
    public List<TvDto> getAllByName(String name, String productName, String color, BigDecimal startPrice,
                                    BigDecimal endPrice, String category, String technology) {
        return tvRepository.findByName(
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
    public TvDto addNewTv(CreateTvDto createTvDto) {
        Optional<HouseholdAppliance> householdAppliance = householdApplianceRepository
                .getByProductNameAndCountryAndCompany(
                        createTvDto.getProductName(),
                        createTvDto.getCountry(),
                        createTvDto.getCompany()
                );

        TV tv = tvMapper.dtoToEntity(createTvDto);

        if (householdAppliance.isPresent()) {
            Optional<TV> model = tvRepository.findByNameAndColorAndSizeAndCategoryAndTechnologyAndHouseholdAppliance(
                    createTvDto.getName(),
                    createTvDto.getColor(),
                    createTvDto.getSize(),
                    createTvDto.getCategory(),
                    createTvDto.getTechnology(),
                    householdAppliance.get());

            if (model.isPresent()) {
                throw new SuchModelAlreadyExistException();
            }

            tv.setHouseholdAppliance(householdAppliance.get());

        } else {
            HouseholdAppliance householdApplianceForSave = householdApplianceMapper.dtoToEntity(createTvDto);
            HouseholdAppliance householdApplianceSaved = householdApplianceRepository.save(householdApplianceForSave);
            tv.setHouseholdAppliance(householdApplianceSaved);
        }

        return tvMapper.entityToDto(tvRepository.save(tv));
    }
}
