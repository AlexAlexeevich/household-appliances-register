package ru.info_system_and_services.household_appliances_register.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.info_system_and_services.household_appliances_register.model.dto.tv.TvDto;
import ru.info_system_and_services.household_appliances_register.model.entity.HouseholdAppliance;
import ru.info_system_and_services.household_appliances_register.model.entity.ProductName;
import ru.info_system_and_services.household_appliances_register.model.entity.TV;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface TvRepository extends JpaRepository<TV, Long> {

    @Query(value = "SELECT " +
            "new ru.info_system_and_services.household_appliances_register.model.dto.tv.TvDto" +
            "(t.id, ha.productName, ha.country, ha.company, ha.isOrderOnline, ha.isPossibleInstallments, t.name, t.serialNumber, t.color, t.size, t.price, t.isAvailable, t.category, t.technology) " +
            "FROM TV t " +
            "JOIN HouseholdAppliance ha ON ha.id = t.householdAppliance.id " +
            "WHERE t.name LIKE :name " +
            "AND t.isAvailable = true " +
            "AND (:productName IS NULL OR ha.productName = :productName) " +
            "AND (:color IS NULL OR t.color = :color) " +
            "AND ((:startPrice IS NULL OR t.price >= :startPrice) AND (:endPrice IS NULL OR t.price <= :endPrice)) " +
            "AND (:category IS NULL OR t.category = :category) " +
            "AND (:technology IS NULL OR t.category = :technology)" +
            "ORDER BY t.name, t.price ASC")
    List<TvDto> findByName(
            @Param("name") String name,
            @Param("productName") ProductName productName,
            @Param("color") String color,
            @Param("startPrice") BigDecimal startPrice,
            @Param("endPrice") BigDecimal endPrice,
            @Param("category") String category,
            @Param("technology") String technology);

    Optional<TV> findByNameAndColorAndSizeAndCategoryAndTechnologyAndHouseholdAppliance(
            String name,
            String color,
            String size,
            String category,
            String technology,
            HouseholdAppliance householdAppliance
    );
}
