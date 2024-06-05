package ru.info_system_and_services.household_appliances_register.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.info_system_and_services.household_appliances_register.model.dto.hoover.HooverDto;
import ru.info_system_and_services.household_appliances_register.model.entity.Hoover;
import ru.info_system_and_services.household_appliances_register.model.entity.HouseholdAppliance;
import ru.info_system_and_services.household_appliances_register.model.entity.ProductName;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface HooverRepository extends JpaRepository<Hoover, Long> {

    @Query(value = "SELECT " +
            "new ru.info_system_and_services.household_appliances_register.model.dto.hoover.HooverDto" +
            "(h.id, ha.productName, ha.country, ha.company, ha.isOrderOnline, ha.isPossibleInstallments, h.name," +
            " h.serialNumber, h.color, h.size, h.price, h.isAvailable, h.dustCollectorVolume, h.modeQuantity) " +
            "FROM Hoover h " +
            "JOIN HouseholdAppliance ha ON ha.id = h.householdAppliance.id " +
            "WHERE h.name LIKE :name " +
            "AND h.isAvailable = true " +
            "AND (:productName IS NULL OR ha.productName = :productName) " +
            "AND (:color IS NULL OR h.color = :color) " +
            "AND ((:startPrice IS NULL OR h.price >= :startPrice) AND (:endPrice IS NULL OR h.price <= :endPrice)) " +
            "AND (:dustCollectorVolume IS NULL OR h.dustCollectorVolume = :dustCollectorVolume) " +
            "AND (:modeQuantity IS NULL OR h.modeQuantity = :modeQuantity)" +
            "ORDER BY h.name, h.price ASC")
    List<HooverDto> findByName(
            @Param("name") String name,
            @Param("productName") ProductName productName,
            @Param("color") String color,
            @Param("startPrice") BigDecimal startPrice,
            @Param("endPrice") BigDecimal endPrice,
            @Param("dustCollectorVolume") String dustCollectorVolume,
            @Param("modeQuantity") String modeQuantity);

    Optional<Hoover> findByNameAndColorAndSizeAndDustCollectorVolumeAndModeQuantityAndHouseholdAppliance(
            String name,
            String color,
            String size,
            String dustCollectorVolume,
            String modeQuantity,
            HouseholdAppliance householdAppliance
    );
}
