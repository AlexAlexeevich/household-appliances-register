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
@Table(name = "fridge")
public class Fridge extends Model {

    @Column(name = "door_fridge_quantity")
    private String doorFridgeQuantity;

    @Column(name = "compressor_type")
    private String compressorType;

    public Fridge(String name, String serialNumber, String color, String size, BigDecimal price, Boolean isAvailable, String doorFridgeQuantity, String compressorType) {
        super(name, serialNumber, color, size, price, isAvailable);
        this.doorFridgeQuantity = doorFridgeQuantity;
        this.compressorType = compressorType;
    }
}
