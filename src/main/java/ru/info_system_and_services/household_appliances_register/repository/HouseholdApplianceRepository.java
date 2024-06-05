package ru.info_system_and_services.household_appliances_register.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.info_system_and_services.household_appliances_register.model.entity.HouseholdAppliance;
import ru.info_system_and_services.household_appliances_register.model.entity.ProductName;

import java.util.Optional;

public interface HouseholdApplianceRepository extends JpaRepository<HouseholdAppliance, Long> {

    Optional<HouseholdAppliance> getByProductNameAndCountryAndCompany(
            ProductName productName, String country, String company);
}
