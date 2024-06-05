package ru.info_system_and_services.household_appliances_register.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.info_system_and_services.household_appliances_register.model.entity.base.Model;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hoover")
public class Hoover extends Model {

    @Column(name = "dust_collector_volume")
    private String dustCollectorVolume;

    @Column(name = "mode_quantity")
    private String modeQuantity;

    public Hoover(String name, String serialNumber, String color, String size, BigDecimal price, Boolean isAvailable,
                  String dustCollectorVolume, String modeQuantity) {
        super(name, serialNumber, color, size, price, isAvailable);
        this.dustCollectorVolume = dustCollectorVolume;
        this.modeQuantity = modeQuantity;
    }
}
