package ru.info_system_and_services.household_appliances_register.mapper;

import org.springframework.stereotype.Component;
import ru.info_system_and_services.household_appliances_register.model.dto.base.ModelDto;
import ru.info_system_and_services.household_appliances_register.model.entity.HouseholdAppliance;

@Component
public class HouseholdApplianceMapper {

    public HouseholdAppliance dtoToEntity(ModelDto modelDto) {

        return HouseholdAppliance.builder()
                .productName(modelDto.getProductName())
                .country(modelDto.getCountry())
                .company(modelDto.getCompany())
                .isOrderOnline(false)
                .isPossibleInstallments(false)
                .build();
    }
}
