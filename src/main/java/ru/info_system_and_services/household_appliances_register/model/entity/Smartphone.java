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
@Table(name = "smartphone")
public class Smartphone extends Model {

    @Column(name = "memory")
    private String memory;

    @Column(name = "camera_quantity")
    private String cameraQuantity;

    public Smartphone(String name, String serialNumber, String color, String size, BigDecimal price,
                      Boolean isAvailable, String memory, String cameraQuantity) {
        super(name, serialNumber, color, size, price, isAvailable);
        this.memory = memory;
        this.cameraQuantity = cameraQuantity;
    }
}
