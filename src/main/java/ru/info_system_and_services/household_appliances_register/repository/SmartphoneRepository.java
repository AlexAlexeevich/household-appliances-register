package ru.info_system_and_services.household_appliances_register.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.info_system_and_services.household_appliances_register.model.dto.smartphone.SmartphoneDto;
import ru.info_system_and_services.household_appliances_register.model.entity.HouseholdAppliance;
import ru.info_system_and_services.household_appliances_register.model.entity.ProductName;
import ru.info_system_and_services.household_appliances_register.model.entity.Smartphone;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface SmartphoneRepository extends JpaRepository<Smartphone, Long> {

    @Query(value = "SELECT " +
            "new ru.info_system_and_services.household_appliances_register.model.dto.smartphone.SmartphoneDto" +
            "(s.id, ha.productName, ha.country, ha.company, ha.isOrderOnline, ha.isPossibleInstallments, s.name," +
            " s.serialNumber, s.color, s.size, s.price, s.isAvailable, s.memory, s.cameraQuantity) " +
            "FROM Smartphone s " +
            "JOIN HouseholdAppliance ha ON ha.id = s.householdAppliance.id " +
            "WHERE s.name LIKE :name " +
            "AND s.isAvailable = true " +
            "AND (:productName IS NULL OR ha.productName = :productName) " +
            "AND (:color IS NULL OR s.color = :color) " +
            "AND ((:startPrice IS NULL OR s.price >= :startPrice) AND (:endPrice IS NULL OR s.price <= :endPrice)) " +
            "AND (:memory IS NULL OR s.memory = :memory) " +
            "AND (:cameraQuantity IS NULL OR s.cameraQuantity = :cameraQuantity)" +
            "ORDER BY s.name, s.price ASC")
    List<SmartphoneDto> findByName(
            @Param("name") String name,
            @Param("productName") ProductName productName,
            @Param("color") String color,
            @Param("startPrice") BigDecimal startPrice,
            @Param("endPrice") BigDecimal endPrice,
            @Param("memory") String memory,
            @Param("cameraQuantity") String cameraQuantity);

    Optional<Smartphone> findByNameAndColorAndSizeAndMemoryAndCameraQuantityAndHouseholdAppliance(
            String name,
            String color,
            String size,
            String memory,
            String cameraQuantity,
            HouseholdAppliance householdAppliance
    );
}
