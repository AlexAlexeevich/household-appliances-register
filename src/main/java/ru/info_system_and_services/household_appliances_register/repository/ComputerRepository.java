package ru.info_system_and_services.household_appliances_register.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.info_system_and_services.household_appliances_register.model.dto.computer.ComputerDto;
import ru.info_system_and_services.household_appliances_register.model.entity.Computer;
import ru.info_system_and_services.household_appliances_register.model.entity.HouseholdAppliance;
import ru.info_system_and_services.household_appliances_register.model.entity.ProductName;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ComputerRepository extends JpaRepository<Computer, Long> {

    @Query(value = "SELECT " +
            "new ru.info_system_and_services.household_appliances_register.model.dto.computer.ComputerDto" +
            "(c.id, ha.productName, ha.country, ha.company, ha.isOrderOnline, ha.isPossibleInstallments, c.name," +
            " c.serialNumber, c.color, c.size, c.price, c.isAvailable, c.category, c.processorType) " +
            "FROM Computer c " +
            "JOIN HouseholdAppliance ha ON ha.id = c.householdAppliance.id " +
            "WHERE c.name LIKE :name " +
            "AND c.isAvailable = true " +
            "AND (:productName IS NULL OR ha.productName = :productName) " +
            "AND (:color IS NULL OR c.color = :color) " +
            "AND ((:startPrice IS NULL OR c.price >= :startPrice) AND (:endPrice IS NULL OR c.price <= :endPrice)) " +
            "AND (:category IS NULL OR c.category = :category) " +
            "AND (:processorType IS NULL OR c.processorType = :processorType)" +
            "ORDER BY c.name, c.price ASC")
    List<ComputerDto> findByName(
            @Param("name") String name,
            @Param("productName") ProductName productName,
            @Param("color") String color,
            @Param("startPrice") BigDecimal startPrice,
            @Param("endPrice") BigDecimal endPrice,
            @Param("category") String category,
            @Param("processorType") String processorType);

    Optional<Computer> findByNameAndColorAndSizeAndCategoryAndProcessorTypeAndHouseholdAppliance(
            String name,
            String color,
            String size,
            String category,
            String processorType,
            HouseholdAppliance cameraQuantity
    );
}
