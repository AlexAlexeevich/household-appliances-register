package ru.info_system_and_services.household_appliances_register.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.info_system_and_services.household_appliances_register.model.dto.fridge.FridgeDto;
import ru.info_system_and_services.household_appliances_register.model.entity.Fridge;
import ru.info_system_and_services.household_appliances_register.model.entity.HouseholdAppliance;
import ru.info_system_and_services.household_appliances_register.model.entity.ProductName;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface FridgeRepository extends JpaRepository<Fridge, Long> {

    @Query(value = "SELECT " +
            "new ru.info_system_and_services.household_appliances_register.model.dto.fridge.FridgeDto" +
            "(f.id, ha.productName, ha.country, ha.company, ha.isOrderOnline, ha.isPossibleInstallments, f.name," +
            " f.serialNumber, f.color, f.size, f.price, f.isAvailable, f.doorFridgeQuantity, f.compressorType) " +
            "FROM Fridge f " +
            "JOIN HouseholdAppliance ha ON ha.id = f.householdAppliance.id " +
            "WHERE f.name LIKE :name " +
            "AND f.isAvailable = true " +
            "AND (:productName IS NULL OR ha.productName = :productName) " +
            "AND (:color IS NULL OR f.color = :color) " +
            "AND ((:startPrice IS NULL OR f.price >= :startPrice) AND (:endPrice IS NULL OR f.price <= :endPrice)) " +
            "AND (:doorFridgeQuantity IS NULL OR f.doorFridgeQuantity = :doorFridgeQuantity) " +
            "AND (:compressorType IS NULL OR f.compressorType = :compressorType)" +
            "ORDER BY f.name, f.price ASC")
    List<FridgeDto> findByName(
            @Param("name") String name,
            @Param("productName") ProductName productName,
            @Param("color") String color,
            @Param("startPrice") BigDecimal startPrice,
            @Param("endPrice") BigDecimal endPrice,
            @Param("doorFridgeQuantity") String doorFridgeQuantity,
            @Param("compressorType") String compressorType);

    Optional<Fridge> findByNameAndColorAndSizeAndDoorFridgeQuantityAndCompressorTypeAndHouseholdAppliance(
            String name,
            String color,
            String size,
            String doorFridgeQuantity,
            String compressorType,
            HouseholdAppliance householdAppliance
    );
}
